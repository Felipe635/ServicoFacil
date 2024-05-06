package com.example.servicofacil.service;

import com.example.servicofacil.model.User;
import com.example.servicofacil.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void userSave(User user){
        userRepository.save(user);
    }

    public List<User> UserGetByLogin(User user) throws Exception {
        if(user.getName() == null || user.getPassword() == null)
            throw new Exception("Parametros invalidos");

        return userRepository.getUserByLogin(user.getName(), user.getPassword());
    }
}
