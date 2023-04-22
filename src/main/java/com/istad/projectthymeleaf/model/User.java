package com.istad.projectthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String userName;
    private String profileImg;
    private String gender;
    private String description;
//    private String Email;
//    private String address;
//    private String phone;
}
