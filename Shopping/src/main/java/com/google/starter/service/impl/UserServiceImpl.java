package com.google.starter.service.impl;

import com.google.starter.entity.User;
import com.google.starter.repository.UserRepository;
import com.google.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserInformation(String userName) {
        return userRepository.findByUserName(userName);

    }

    @Override
    public boolean isValidUser(String userName, String password) {
        if(userRepository.findByUserNameAndPassword(userName, password)
         != null){
            return true;
        }
        return false;
    }
}
