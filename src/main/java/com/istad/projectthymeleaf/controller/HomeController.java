package com.istad.projectthymeleaf.controller;

import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final ArticleService articleService;
    @GetMapping("/")
    String viewHome (Model model){
        //System.out.println(articleService.findAll());//sout merl tha yg ttul ban list l'bos articleService ot
        List<Article> articles = articleService.findAll();//yg oy list bos articleService oy tv articles
        model.addAttribute("articles",articles);
        return "pages/index";
    }
    @GetMapping("/article/new")
    String newArticle( Model model, Article article){
        model.addAttribute("article",article);
        return "pages/new_article";
    }
    @PostMapping("/article/new")
    String doSavePost(@ModelAttribute @Valid Article article, BindingResult result ,Model model){
        if (result.hasErrors()){
            model.addAttribute("article",article);
            System.out.println(article);
           return "pages/new_article";
        }
        System.out.println(article);
        return "redirect:/article/new";
    }
}
