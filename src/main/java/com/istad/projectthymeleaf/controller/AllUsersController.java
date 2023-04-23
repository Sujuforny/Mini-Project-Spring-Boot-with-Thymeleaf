package com.istad.projectthymeleaf.controller;
import com.istad.projectthymeleaf.model.User;
import com.istad.projectthymeleaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AllUsersController {
    private final UserService userService;
    @GetMapping("/all_users")
    String viewAllUsers(Model model){
        List<User> userList =userService.findAlls();
        model.addAttribute("userList",userList);
        System.out.println(userList);
        return "/pages/all_users";
    }
}
