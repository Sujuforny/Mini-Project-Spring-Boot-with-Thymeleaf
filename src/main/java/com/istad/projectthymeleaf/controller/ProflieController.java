package com.istad.projectthymeleaf.controller;

import com.istad.projectthymeleaf.model.User;
import com.istad.projectthymeleaf.repository.StaticRepository;
import com.istad.projectthymeleaf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProflieController {
    private final UserService userService;
    private final StaticRepository staticRepository;
    @GetMapping("/profile")
    String viewProfile(  Model model){
        List<User> userList = userService.findAlls();
        model.addAttribute("userlist",userList);
        return "pages/profile";
    }
    @GetMapping("/profile/user")
    String viewDetail(@ModelAttribute @RequestParam("userName") String userName ,Model model){
        List<User> userList =staticRepository.getUserList();
        List<User> findUser = new ArrayList<>();
        User user= userService.profileUser(userName);
        String userCover =user.getCover();
        model.addAttribute("user" ,user);
        model.addAttribute("userCover",userCover);
        return "pages/profile";
    }

}
