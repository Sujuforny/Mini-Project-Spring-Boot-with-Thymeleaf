package com.istad.projectthymeleaf.controller;

import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.model.Categories;
import com.istad.projectthymeleaf.service.ArticleService;
import com.istad.projectthymeleaf.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CategoriesShowPostController {
    private final CategoriesService categoriesService;
    private final ArticleService articleService;
    @GetMapping("/categories/list")
    String viewCategories(@ModelAttribute  @RequestParam("cat") String cat, Model model){
        List<Categories> categoriesList = categoriesService.findAll();

        List<Article> articles = articleService.getAll(cat);
        model.addAttribute("categoriesList",categoriesList);
        model.addAttribute("articles",articles);
        return "pages/categories";
    }
}
