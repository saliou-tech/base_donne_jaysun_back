package com.anbiko.anbiko.Service.implementation;

import com.anbiko.anbiko.Dto.LoginRequest;
import com.anbiko.anbiko.Dto.LoginResponse;
import com.anbiko.anbiko.Dto.RegisterRequest;
import com.anbiko.anbiko.Dto.UserDetailDto;
import com.anbiko.anbiko.Entity.User;
import com.anbiko.anbiko.Entity.UserDetail;
import com.anbiko.anbiko.Exception.InvalidCredentialException;
import com.anbiko.anbiko.enums.Helper.UserDetailsMapper;
import com.anbiko.anbiko.Repository.UserDetailsRepository;
import com.anbiko.anbiko.Repository.UserRepository;
import com.anbiko.anbiko.Service.AuthService;
import com.anbiko.anbiko.security.JwtProvider;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserDetailsRepository userDetailsRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;




    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = findUserByCredentials(loginRequest.getUsername(), loginRequest.getPassword());
        return LoginResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .role(user.getRole())
                .token(jwtProvider.generateTokenWithUsername(user.getUsername()))
                .build();
    }

    @Override
    public UserDetailDto register(RegisterRequest registerRequest) {

        checkIfUsernameExists(registerRequest.getUsername());
        //log.info("dans  le  servcie");

        registerRequest.setPassword(encodePassword(registerRequest.getPassword()));
        UserDetail userDetails = userDetailsRepository.save(UserDetailsMapper.registerToUserDetails(registerRequest));
        return UserDetailsMapper.userDetailsToDto(userDetails);

    }

    @Override
    public List<UserDetailDto> fetchAllUsers() {
        return userDetailsRepository
                .findAll()
                .stream()
                .map(UserDetailsMapper::userDetailsToDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDetailDto fetchUserById(Long id) {
        return UserDetailsMapper.userDetailsToDto(
                userDetailsRepository
                        .findById(id)
                        .orElseThrow(() -> new InvalidCredentialException("userId", "ID " + id + " doesn't exist")));
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        return false;
    }
    @Transactional(readOnly = true)
    public User findUserByCredentials(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new InvalidCredentialException("l'utilisateur", " " + username + " n'existe pas veuillez reéssayer"));

        if (!passwordEncoder.matches(password, user.getPassword())) throw new InvalidCredentialException("password", "Mot de passe incorrecte");
        return user;
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
