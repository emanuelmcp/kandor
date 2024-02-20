package io.github.com.core.accounts.dto.input;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationDataDTO implements Serializable {
    String uuid;
    String password;
}
