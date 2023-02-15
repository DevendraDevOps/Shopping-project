package com.google.starter.controller;

import com.google.starter.entity.User;
import com.google.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> addNewUser(@RequestBody User user){
        User userDB = userService.addNewUser(user);
        if(userDB != null){
            return new ResponseEntity<>(userDB, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/userInfo")
    public ResponseEntity<Object> getUserInfo(@RequestParam("userName") String userName){
        User user = userService.getUserInformation(userName);
        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/validUser")
    public ResponseEntity<String> getUserInfo(@RequestParam("userName") String userName,
                                               @RequestParam("password") String password){
        Boolean user = userService.isValidUser(userName,password);
        if(user){
            return new ResponseEntity<>("Valid User", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Invalid User",HttpStatus.NOT_FOUND);
        }
    }
}
