package com.google.starter.service;

import com.google.starter.entity.User;

public interface UserService {

    User addNewUser(User user);

    User getUserInformation(String userName);

    boolean isValidUser(String userName, String password);


}
