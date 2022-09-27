package com.anbiko.anbiko.Service;

import com.anbiko.anbiko.Dto.LoginRequest;
import com.anbiko.anbiko.Dto.LoginResponse;
import com.anbiko.anbiko.Dto.RegisterRequest;
import com.anbiko.anbiko.Dto.UserDetailDto;

import java.util.List;

public interface AuthService {
        LoginResponse login(LoginRequest loginRequest);

        UserDetailDto register(RegisterRequest registerRequest);


        List<UserDetailDto> fetchAllUsers();

        UserDetailDto fetchUserById(Long id);

        boolean checkIfUsernameExists(String username);

/*    Map<String, String> fetchSecurityQuestionForUser(String username);
    Map<String, String> validateAnswerAndUpdate(ForgotPasswordRequest forgotPasswordRequest);*/

}
