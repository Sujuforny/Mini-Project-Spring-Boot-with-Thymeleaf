package com.istad.projectthymeleaf.controller;

import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.model.Categories;
import com.istad.projectthymeleaf.model.User;
import com.istad.projectthymeleaf.service.ArticleService;
import com.istad.projectthymeleaf.service.CategoriesService;
import com.istad.projectthymeleaf.service.UserService;
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
    private final CategoriesService categoriesService;
    private final UserService userService;
    @GetMapping("/")
    String viewHome (Model model){
        //System.out.println(articleService.findAll());//sout merl tha yg ttul ban list l'bos articleService ot
        List<User> userList = userService.findAll();
        List<Categories> categories =categoriesService.findAll();
        List<Article> articles = articleService.findAll();//yg oy list bos articleService oy tv articles

        model.addAttribute("categories",categories);

        return "pages/index";
    }
    @GetMapping("/article/new")
    String newArticle(Model model, Article article , Categories categories){
        List<Categories> categoriess = categoriesService.findAll();
        List<User> userList = userService.findAll();

        model.addAttribute("categoriess",categoriess);

        return "pages/new_article";
    }
    @PostMapping("/article/new")
    String doSavePost(@ModelAttribute @Valid Article article, BindingResult result ,Model model,Categories categories){
        List<Categories> categoriess = categoriesService.findAll();
        List<Article> articles = articleService.findAll();
        List<User> userList = userService.findAll();
        if (result.hasErrors()){

            model.addAttribute("categoriess",categoriess);




           return "pages/new_article";
        }
        System.out.println(article);
        return "redirect:/article/new";
    }
}
