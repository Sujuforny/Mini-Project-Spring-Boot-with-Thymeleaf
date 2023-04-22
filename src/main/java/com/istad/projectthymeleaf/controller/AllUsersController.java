package com.istad.projectthymeleaf.controller;

import ch.qos.logback.core.model.Model;
import com.istad.projectthymeleaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AllUsersController {
    private final UserService userService;
    @GetMapping("/all_users")
    String viewAllUsers(Model model){
        System.out.println(userService.findAll());
        return "/pages/all_users";
    }
}
