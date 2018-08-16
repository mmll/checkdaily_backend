package com.checkdaily.demo.service;

import com.checkdaily.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class SignupService {
    @Autowired
    private UserRepository repository;
    public Void createUser(User user){

        repository.insert(user);
        return null;
    }
}
