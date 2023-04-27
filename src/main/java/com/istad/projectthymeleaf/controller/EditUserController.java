package com.istad.projectthymeleaf.controller;

import com.istad.projectthymeleaf.model.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EditUserController {
    @GetMapping("/edit/user")
    String editUser(Model model, User user){
        model.addAttribute("user",user);
        return "pages/edit_user";
    }
    @PostMapping("/edit/user")
    String editedUser(@ModelAttribute @Valid User user, BindingResult result ,
                       MultipartFile file,
                      Model model){
        System.out.println(user);
        return "redirect:/edit/user";
    }
}
