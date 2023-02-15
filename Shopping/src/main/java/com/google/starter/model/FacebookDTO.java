package com.google.starter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class FacebookDTO {
    @NotBlank(message = "First Name should not null")
    private String firstName;
    @NotBlank(message = "Last Name should not null")
    private String lastName;
    @Email(message = "Email Should be in proper format")
    private String emailAddress;
    @Pattern(regexp="(^$|[0-9]{10})", message = "Mobile Number should be 10 digits")
    private Long mobile;
    @JsonIgnore
    private String password;
    @DateTimeFormat( pattern="yyyy-MM-dd")
    private String dateOfBirth;
    @NotBlank(message = "First Name should not null")
    private String gender;
}
