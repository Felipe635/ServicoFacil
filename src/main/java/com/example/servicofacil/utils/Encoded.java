package com.example.servicofacil.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoded {
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public boolean checkPassword(String userPassword, String loginPassword) {
        return passwordEncoder().matches(loginPassword, userPassword);
    }
}
