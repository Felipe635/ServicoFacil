package com.example.servicofacil.service;

import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.UserRepository;
import com.example.servicofacil.utils.Encoded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    public void userSave(User user) {

/*
        User existUser = userRepository.findByLogin(user.getLogin());

        if(existUser != null){
            throw new Error("Usuario já existente");
        }
*/

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }

    public User findByLogin(String login) throws Exception {

        var existUser = userRepository.findByLogin(login);
        Encoded encoded = new Encoded();

       return existUser;
    }
    public User findUserById(Long id) {

        var user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("admin"))
        );    }
}