package io.github.com.core.accounts.services;

import io.github.com.core.accounts.dto.output.LoginResponseDTO;
import io.github.com.core.accounts.dto.input.AuthenticationDataDTO;

public interface AuthService {
    LoginResponseDTO register(AuthenticationDataDTO dto);
    LoginResponseDTO login(AuthenticationDataDTO dto);
}
