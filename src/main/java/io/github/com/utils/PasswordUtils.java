package io.github.com.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class PasswordUtils {
    private final BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10, new SecureRandom());
    public String hash(String password) {
        return bcrypt.encode(password);
    }
    public boolean verify(String plainPassword, String hash) {
        return bcrypt.matches(plainPassword, hash);
    }
}
