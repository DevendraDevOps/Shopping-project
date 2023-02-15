package com.google.starter.service;

import com.google.starter.model.FacebookDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface FacebookService {

    FacebookDTO registerNewUser(FacebookDTO facebookDTO);
    boolean validUser(String emailAddress, Long mobileNo, String password);
    List<String> getAllFacebookValidAccounts();
    List<FacebookDTO> getAllFaceBookAccountsBeforeDate(LocalDateTime localDateTime);
}
