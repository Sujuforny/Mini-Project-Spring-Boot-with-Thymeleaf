package com.istad.projectthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProflieController {
    @GetMapping("/profile")
    String viewProfile(){
        return "pages/profile";
    }
}
