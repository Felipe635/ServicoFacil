package com.example.servicofacil.service;

import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.UserRepository;
import com.example.servicofacil.utils.Encoded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
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

        var idUser = userRepository.findUserByIdUser(id);
        return idUser;
    }
}