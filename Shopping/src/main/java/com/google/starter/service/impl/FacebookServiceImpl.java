package com.google.starter.service.impl;

import com.google.starter.entity.FacebookEntity;
import com.google.starter.mapper.FacebookMapper;
import com.google.starter.model.FacebookDTO;
import com.google.starter.repository.FacebookRepository;
import com.google.starter.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacebookServiceImpl implements FacebookService {

    @Autowired
    FacebookRepository facebookRepository;
    @Override
    public FacebookDTO registerNewUser(FacebookDTO facebookDTO) {
        FacebookEntity facebookEntity = FacebookMapper.convertFacebookDTOToEntity(facebookDTO);
        FacebookEntity facebookEntityDB  =facebookRepository.save(facebookEntity);
        return FacebookMapper.convertFacebookEntityToDTO(facebookEntityDB);
    }

    @Override
    public boolean validUser(String emailAddress, Long mobileNo, String password) {
        FacebookEntity facebookEntity =
                facebookRepository.findByPasswordAndEmailAddressOrMobile(password,
                        emailAddress, mobileNo);
        if(facebookEntity != null){
            return true;
        }
        return false;
    }

    @Override
    public List<String> getAllFacebookValidAccounts() {
        return facebookRepository.findAll()
                .stream().map(FacebookEntity::getEmailAddress)
                .collect(Collectors.toList());

    }

    @Override
    public List<FacebookDTO> getAllFaceBookAccountsBeforeDate(LocalDateTime localDateTime) {
        return facebookRepository.findAll()
                .stream()
                .filter(x->x.getCreatedDate().isBefore(localDateTime))
                .map(x->FacebookMapper.convertFacebookEntityToDTO(x))
                .collect(Collectors.toList());

    }
}
