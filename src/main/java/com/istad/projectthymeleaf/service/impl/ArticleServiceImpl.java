package com.istad.projectthymeleaf.service.impl;

import com.istad.projectthymeleaf.model.Article;
import com.istad.projectthymeleaf.model.FileUpload;
import com.istad.projectthymeleaf.repository.StaticRepository;
import com.istad.projectthymeleaf.service.ArticleService;
import com.istad.projectthymeleaf.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    public boolean save(Article article, MultipartFile file) {
        FileUpload fileUpload =fileUploadService.uploadSingle(file);
        if (fileUpload.isSucceed()){
            article.setThumbnail(fileUpload.fileName());
            staticRepository.getArticles().add(0,article);

        }

        return true;
    }

}
