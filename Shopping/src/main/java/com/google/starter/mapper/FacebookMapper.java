package com.google.starter.mapper;

import com.google.starter.entity.FacebookEntity;
import com.google.starter.model.FacebookDTO;

import java.time.LocalDateTime;

public class FacebookMapper {
    public static FacebookEntity convertFacebookDTOToEntity(FacebookDTO facebookDTO){
        FacebookEntity facebookEntity = new FacebookEntity();
        facebookEntity.setCreatedDate(LocalDateTime.now());
        facebookEntity.setDateOfBirth(facebookDTO.getDateOfBirth());
        facebookEntity.setEmailAddress(facebookDTO.getEmailAddress());
        facebookEntity.setGender(facebookDTO.getGender());
        facebookEntity.setFirstName(facebookDTO.getFirstName());
        facebookEntity.setLastName(facebookDTO.getLastName());
        facebookEntity.setPassword(facebookDTO.getPassword());
        facebookEntity.setMobile(facebookDTO.getMobile());
        return facebookEntity;
    }

    public static FacebookDTO convertFacebookEntityToDTO(FacebookEntity facebookEntity){
        FacebookDTO facebookDTO = new FacebookDTO();
        facebookDTO.setGender(facebookEntity.getGender());
        facebookDTO.setEmailAddress(facebookEntity.getEmailAddress());
        facebookDTO.setFirstName(facebookEntity.getFirstName());
        facebookDTO.setLastName(facebookEntity.getLastName());
        facebookDTO.setMobile(facebookEntity.getMobile());
        facebookDTO.setDateOfBirth(facebookEntity.getDateOfBirth());
        return facebookDTO;
    }
}
