package com.istad.projectthymeleaf.service.impl;

import com.istad.projectthymeleaf.model.Categories;
import com.istad.projectthymeleaf.repository.StaticRepository;
import com.istad.projectthymeleaf.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {
    private final StaticRepository staticRepository;

    @Override
    public List<Categories> findAll() {
        return staticRepository.getCategoriesList();
    }
}
