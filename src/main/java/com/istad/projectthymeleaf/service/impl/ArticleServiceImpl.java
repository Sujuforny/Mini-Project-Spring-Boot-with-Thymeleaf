package com.istad.projectthymeleaf.service.impl;

import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.model.Categories;
import com.istad.projectthymeleaf.model.FileUpload;
import com.istad.projectthymeleaf.repository.StaticRepository;
import com.istad.projectthymeleaf.service.ArticleService;
import com.istad.projectthymeleaf.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor //
public class ArticleServiceImpl implements ArticleService {
    private final StaticRepository staticRepository;
    private final FileUploadService fileUploadService;
    @Override
    public List<Article> findAll() {
        return staticRepository.getArticles();
    }

    @Override
    public List<Article> getAll(String cat) {
        List<Article> articles = staticRepository.getArticles();
        List<Article> articleList = new ArrayList<>();
        for (Article article : articles) {
            // Filter articles based on category
            List<Categories> filteredCategories = article.getCategoriesList().stream()
                    .filter(cats -> cats.getCat().equals(cat))
                    .collect(Collectors.toList());

            // If article has the specified category, add it to the result list
            if (!filteredCategories.isEmpty()) {
                articleList.add(article);
            }
        }
        return articleList;
    }
//    public List<Article> getAll(String cat) {
//        List<Article> articless = staticRepository.getArticles();
//        List<Article> articleList = new ArrayList<>();
//        for (Article article:articless) {
//            article.getCategoriesList().stream()
//                    .filter(cats -> cats.equals(cat))
//                    .map(articles -> articles) //
//                    .forEach(articleList::add);
//        }
//        return articleList;
//    }

    @Override
    public boolean save(Article article, MultipartFile file) {
        FileUpload fileUpload =fileUploadService.uploadSingle(file);
        if (fileUpload.isSucceed()){
            article.setThumbnail("/resources/img/post/"+fileUpload.fileName());
            staticRepository.getArticles().add(0,article);

        }

        return true;
    }

}
