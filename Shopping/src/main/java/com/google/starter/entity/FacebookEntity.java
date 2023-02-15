package com.google.starter.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class FacebookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long faceBookId;

    private String firstName;
    private String lastName;
    private String emailAddress;
    private Long mobile;
    private String password;
    private String dateOfBirth;
    private String gender;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
