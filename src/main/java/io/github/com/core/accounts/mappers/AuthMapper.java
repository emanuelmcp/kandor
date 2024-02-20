package io.github.com.core.accounts.mappers;

import io.github.com.core.accounts.dto.input.AuthenticationDataDTO;
import io.github.com.entities.staff.Account;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {
    public Account registerWithMinecraftDTOToAccount(@NotNull AuthenticationDataDTO dto) {
        return Account
            .builder()
            .uuid(dto.getUuid())
            .password(dto.getPassword())
            .build();
    }
}
