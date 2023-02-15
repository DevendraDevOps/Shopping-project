package com.google.starter.controller;

import com.google.starter.model.FacebookDTO;
import com.google.starter.service.FacebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FacebookController {

    @Autowired
    FacebookService facebookService;

    @PostMapping("/register")
    public ResponseEntity<Object> registerNewUser(@RequestBody @Valid FacebookDTO facebookDTO){
        FacebookDTO facebookDTODB = facebookService.registerNewUser(facebookDTO);
        if(facebookDTODB != null){
            return new ResponseEntity<>(facebookDTODB, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/validUserFacebook")
    public ResponseEntity<String> validateUser(@RequestParam(value = "username", required = false) String emailAddress,
                                               @RequestParam(value = "mobile", required = false) Long mobile,
                                               @RequestParam("password") String password){
        Boolean isValid = facebookService.validUser(emailAddress, mobile, password);
        if(isValid){
            return new ResponseEntity<>("Valid User", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Valid User", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/getAllFaceBookEmails")
    public ResponseEntity<Object> getAllFaceBookRegisteredEmails(){
        List<String> emailIds = facebookService.getAllFacebookValidAccounts();
        if(!CollectionUtils.isEmpty(emailIds)){
            return new ResponseEntity<>(emailIds, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
