package com.istad.projectthymeleaf.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userName;
    private String profileImg;
    private String gender;
    private String description;
    private String email;
    private String address;
    private String cover;

//    private String Email;
//    private String address;
//    private String phone;
}
