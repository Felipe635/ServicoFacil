package com.example.servicofacil.controller;

import com.example.servicofacil.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping ("/login")
    public String loegged() {
        return "redirect:/provider/provider-list";
    }

/*    @RequestMapping("/logged")
    public String createAuthenticationToken()  {
        //authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword()));
//
        //final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getLogin());
        //final String token = jwtTokenUtil.generateToken(userDetails);
//
        //return ResponseEntity.ok().body(new JwtResponse(token));

        return "search";

    }*/
}