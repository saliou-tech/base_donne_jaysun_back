package com.anbiko.anbiko.Controller;

import com.anbiko.anbiko.Dto.LoginRequest;
import com.anbiko.anbiko.Dto.LoginResponse;
import com.anbiko.anbiko.Service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@AllArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        log.info("controller");
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequest));
    }

}
