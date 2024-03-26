package io.github.com.dto.auth;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationDataDTO implements Serializable {
    String uuid;
    String password;
}
