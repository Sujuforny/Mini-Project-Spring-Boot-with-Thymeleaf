package com.istad.projectthymeleaf.service.impl;

import com.istad.projectthymeleaf.model.User;
import com.istad.projectthymeleaf.repository.StaticRepository;
import com.istad.projectthymeleaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final StaticRepository staticRepository;
    @Override
    public User findAll() {
        return staticRepository.getUser();
    }

    @Override
    public List<User> findAlls() {
        return staticRepository.getUserList();
    }
}
