/*
package com.example.servicofacil.config;

import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.UserRepository;
import com.example.servicofacil.utils.JwtTokenUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Base64;
@Component
@RequiredArgsConstructor
public class CustomBasicAuthenticationFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION = "Authorization";
    private static final String BASIC = "Basic ";
    private final UserRepository userRepository;
    private final JwtTokenUtil jwtTokenUtil;

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (isBasicAuthentication(request)) {
            String[] credentials = decodeBase64(getHeader(request).replace(BASIC, "")).split(":");

            String login = credentials[0];
            String password = credentials[1];

            User user = userRepository.findByLoginFetchRoles(login);

            if (user == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("User does not exist!");
                return;
            }

            boolean valid = checkPassword(user.getPassword(), password);

            if (!valid) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Password not match");
                return;
            }

            UserPrincipal userPrincipal = UserPrincipal.create(user);
            String token = jwtTokenUtil.generateToken(userPrincipal);

            response.setHeader("Authorization", "Bearer " + token);
        }

        filterChain.doFilter(request, response);
    }

    private boolean checkPassword(String userPassword, String loginPassword) {
        return passwordEncoder().matches(loginPassword, userPassword);
    }

    private String decodeBase64(String base64) {
        byte[] decodeBytes = Base64.getDecoder().decode(base64);
        return new String(decodeBytes);
    }

    private boolean isBasicAuthentication(HttpServletRequest request) {
        String header = getHeader(request);
        return header != null && header.startsWith(BASIC);
    }

    private String getHeader(HttpServletRequest request) {
        return request.getHeader(AUTHORIZATION);
    }
}*/
