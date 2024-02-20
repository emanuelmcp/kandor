package io.github.com.core.accounts.services;

import io.github.com.core.accounts.mappers.AuthMapper;
import io.github.com.core.accounts.dto.input.AuthenticationDataDTO;
import io.github.com.core.accounts.dto.output.LoginResponseDTO;
import io.github.com.entities.staff.Account;
import io.github.com.repositories.staff.AccountRepository;
import io.github.com.utils.PasswordUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("unused")
public class AuthServiceImpl implements AuthService {

    private final AccountRepository accountRepository;
    private final PasswordUtils passwordUtils;
    private final AuthMapper authMapper;

    @Autowired
    public AuthServiceImpl(AccountRepository accountRepository, PasswordUtils passwordUtils, AuthMapper authMapper) {
        this.accountRepository = accountRepository;
        this.passwordUtils = passwordUtils;
        this.authMapper = authMapper;
    }

    public LoginResponseDTO register(@NotNull AuthenticationDataDTO dto) {
        String hashedPassword = passwordUtils.hash(dto.getPassword());
        dto.setPassword(hashedPassword);
        Account account = authMapper.registerWithMinecraftDTOToAccount(dto);
        return new LoginResponseDTO("token");
    }

    public LoginResponseDTO login(AuthenticationDataDTO dto) {
        return new LoginResponseDTO("token");
    }
}