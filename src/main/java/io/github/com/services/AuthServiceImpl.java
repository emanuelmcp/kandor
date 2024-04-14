package io.github.com.services;

import io.github.com.dto.auth.AuthenticationDataDTO;
import io.github.com.dto.auth.LoginResponseDTO;
import io.github.com.entities.staff.Account;
import io.github.com.mappers.AuthenticationDataDTOToAccount;
import io.github.com.repositories.AccountRepository;
import io.github.com.services.interfaces.AuthService;
import io.github.com.utils.PasswordUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final PasswordUtils passwordUtils;
    private final AuthenticationDataDTOToAccount authMapper;

    @Autowired
    public AuthServiceImpl(AccountRepository accountRepository, PasswordUtils passwordUtils, AuthenticationDataDTOToAccount authenticationDataDTOToAccount) {
        this.accountRepository = accountRepository;
        this.passwordUtils = passwordUtils;
        this.authMapper = authenticationDataDTOToAccount;
    }

    public LoginResponseDTO register(@NotNull AuthenticationDataDTO dto) {
        String hashedPassword = passwordUtils.hash(dto.getPassword());
        dto.setPassword(hashedPassword);
        Account account = authMapper.map(dto);
        return new LoginResponseDTO("token");
    }

    public LoginResponseDTO login(AuthenticationDataDTO dto) {
        return new LoginResponseDTO("token");
    }
}