package com.istad.projectthymeleaf.controller;

import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.model.Categories;
import com.istad.projectthymeleaf.model.User;
import com.istad.projectthymeleaf.service.ArticleService;
import com.istad.projectthymeleaf.service.CategoriesService;
import com.istad.projectthymeleaf.service.FileUploadService;
import com.istad.projectthymeleaf.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
        List<Article> articles = articleService.findAll();//yg oy list bos articleService oy tv articles
        List<Categories> categoriesList = categoriesService.findAll();
        User user = userService.findAll();
        model.addAttribute("articles",articles);
        model.addAttribute("categoriesList",categoriesList);
        model.addAttribute("user",user);
        System.out.println(articles);
        return "pages/index";
    }


    //--------Create new post--------
    @GetMapping("/article/new")
    String newArticle( Model model, Article article){
        List<Categories> categoriesList = categoriesService.findAll();
        List<User> userList = userService.findAlls();
        model.addAttribute("categoriesList",categoriesList);
        model.addAttribute("article",article);
        model.addAttribute("userList", userList);
        return "pages/new_article";
    }
    @PostMapping("/article/new")
    String doSavePost(@ModelAttribute @Valid Article article, BindingResult result ,
                    @Valid  @RequestParam("thumbnailFile") MultipartFile file,
                      Model model){
        List<Categories> categoriesList = categoriesService.findAll();
        List<User> userList = userService.findAlls();
        model.addAttribute("categoriesList",categoriesList);
        model.addAttribute("userList", userList);
        if (result.hasErrors()){
            model.addAttribute("article",article);
            return "pages/new_article";
        }
        for ( User user: userList) {
            if(article.getUser().getUserName().equals(user.getUserName())) {
                article.setUser(user);
            }
        }

        boolean isSucceed = articleService.save(article ,file);
        if (isSucceed){
            return "redirect:/article/new";
        }
        return "pages/new_article";
    }
}
