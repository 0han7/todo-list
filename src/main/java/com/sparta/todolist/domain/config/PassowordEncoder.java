package com.sparta.todolist.domain.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class PassowordEncoder {
    public String encode(String rawPassword) {
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }


    public boolean matches(String rawPassword, String encoderPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encoderPassword);
        return result.verified;
    }

}
