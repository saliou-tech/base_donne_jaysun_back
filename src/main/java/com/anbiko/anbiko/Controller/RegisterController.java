package com.anbiko.anbiko.Controller;

import com.anbiko.anbiko.Dto.RegisterRequest;
import com.anbiko.anbiko.Dto.UserDetailDto;
import com.anbiko.anbiko.Service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/register")
@RestController
@AllArgsConstructor
@CrossOrigin(origins="*")
public class RegisterController {
    @Autowired
    private AuthService authService;

    @PostMapping("/create-user")
    public ResponseEntity<UserDetailDto> register(@RequestBody RegisterRequest registerRequest) {

        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequest));
    }

  /*  @PutMapping
    public ResponseEntity<Map<String, String>> updateUser(@Valid @RequestBody UpdateRequest updateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.updateUser(updateRequest));
    }*/

    @GetMapping("/all-user")
    public ResponseEntity<List<UserDetailDto>> fetchAllUsers() {
        return (ResponseEntity<List<UserDetailDto>>) ResponseEntity.status(HttpStatus.OK).body(authService.fetchAllUsers());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDetailDto> fetchUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.fetchUserById(id));
    }
}
