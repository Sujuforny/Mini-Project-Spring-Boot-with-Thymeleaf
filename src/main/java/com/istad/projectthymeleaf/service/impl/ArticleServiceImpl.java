package com.istad.projectthymeleaf.service.impl;

import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.repository.StaticRepository;
import com.istad.projectthymeleaf.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //
public class ArticleServiceImpl implements ArticleService {
    private final StaticRepository staticRepository;
    @Override
    public List<Article> findAll() {
        return staticRepository.getArticles();
    }
}
