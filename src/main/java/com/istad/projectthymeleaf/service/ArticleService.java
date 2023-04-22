package com.istad.projectthymeleaf.service;

import com.istad.projectthymeleaf.model.Article;

import java.util.List;

public interface ArticleService {
    //Find all articles
    //1.Have POJO Class
    List <Article> findAll();
}
