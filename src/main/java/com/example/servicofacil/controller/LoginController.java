package com.example.servicofacil.controller;

import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.UserRepository;
import com.example.servicofacil.responseModel.JwtResponse;
import com.example.servicofacil.service.UserDetailsServiceImpl;
import com.example.servicofacil.service.UserService;
import com.example.servicofacil.utils.JwtTokenUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @GetMapping("/login-view")
    public String login() {
        return "login";
    }

    @RequestMapping("/logged")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user, HttpServletResponse response) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok().body(new JwtResponse(token));

    }
}