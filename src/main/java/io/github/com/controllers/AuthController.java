package io.github.com.controllers;

import io.github.com.dto.auth.LoginResponseDTO;
import io.github.com.dto.auth.AuthenticationDataDTO;
import io.github.com.services.interfaces.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody AuthenticationDataDTO dto) {
        return ResponseEntity.status(201).body(authService.register(dto));
    }

    public ResponseEntity<LoginResponseDTO> login() {
        return null;
    }
}
