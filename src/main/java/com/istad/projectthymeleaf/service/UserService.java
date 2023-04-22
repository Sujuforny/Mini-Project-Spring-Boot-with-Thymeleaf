package com.istad.projectthymeleaf.service;

import com.istad.projectthymeleaf.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
