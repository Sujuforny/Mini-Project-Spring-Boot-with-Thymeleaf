package com.istad.projectthymeleaf.service;

import com.istad.projectthymeleaf.model.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    //Find all articles
    //1.Have POJO Class
    List <Article> findAll();
    boolean save(Article article, MultipartFile file);
}
