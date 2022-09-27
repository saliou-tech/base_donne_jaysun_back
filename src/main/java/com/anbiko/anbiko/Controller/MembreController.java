package com.anbiko.anbiko.Controller;


import com.anbiko.anbiko.Dto.LoginRequest;
import com.anbiko.anbiko.Dto.LoginResponse;
import com.anbiko.anbiko.Entity.Membre;
import com.anbiko.anbiko.Service.AuthService;
import com.anbiko.anbiko.Service.MembreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/membre")
@RestController
@AllArgsConstructor
@CrossOrigin(origins="*")
@Slf4j
public class MembreController {
    private final MembreService membreService;


    @PostMapping("/save")
    public ResponseEntity<Membre> addMembre(@RequestBody Membre membre) {
        log.info("controller");
        return ResponseEntity.status(HttpStatus.OK).body(membreService.ajoutMembre(membre));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Membre>> fetchAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(membreService.listMembre());
    }
}
