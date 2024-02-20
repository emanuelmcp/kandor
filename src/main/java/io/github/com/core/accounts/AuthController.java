package io.github.com.core.accounts;

import io.github.com.core.accounts.dto.output.LoginResponseDTO;
import io.github.com.core.accounts.dto.input.AuthenticationDataDTO;
import io.github.com.core.accounts.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@SuppressWarnings("unused")
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
