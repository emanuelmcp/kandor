package io.github.com.services.interfaces;

import io.github.com.dto.auth.LoginResponseDTO;
import io.github.com.dto.auth.AuthenticationDataDTO;

public interface AuthService {
    LoginResponseDTO register(AuthenticationDataDTO dto);
    LoginResponseDTO login(AuthenticationDataDTO dto);
}
