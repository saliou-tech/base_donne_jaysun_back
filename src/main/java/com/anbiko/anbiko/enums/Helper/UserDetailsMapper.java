package com.anbiko.anbiko.enums.Helper;

import com.anbiko.anbiko.Dto.RegisterRequest;
import com.anbiko.anbiko.Dto.UserDetailDto;
import com.anbiko.anbiko.Entity.User;
import com.anbiko.anbiko.Entity.UserDetail;
import com.anbiko.anbiko.enums.Sexe;

public class UserDetailsMapper {



    public static UserDetail registerToUserDetails(RegisterRequest registerRequest) {
        User user = User.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .role("user")
                .build();
        return   UserDetail.builder()
                .user(user)
                .adresse(registerRequest.getAddress())
                .email(registerRequest.getEmail())
                .nom(registerRequest.getNom())
                .prenom(registerRequest.getPrenom())
                .telephone(registerRequest.getTelephone())
                .dob(registerRequest.getDob())
                .sexe(Sexe.valueOf(registerRequest.getSexe()))
                .build();
    }

    public static UserDetailDto userDetailsToDto(UserDetail userDetails){
        return   UserDetailDto.builder()
                .userId(userDetails.getUserDetailsId())
                .nom(userDetails.getNom())
                .prenom(userDetails.getPrenom())
                .role(userDetails.getUser().getRole())
                .email(userDetails.getEmail())
                .dob(userDetails.getDob())
                .sexe(userDetails.getSexe().toString())
                .telephone(userDetails.getTelephone())
                .build();
    }
}
