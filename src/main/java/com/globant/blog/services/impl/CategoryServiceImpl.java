package com.globant.blog.services.impl;

import com.globant.blog.entities.CategoryEntity;
import com.globant.blog.repositories.CategoryRepository;
import com.globant.blog.services.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryEntity> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public CategoryEntity createCategory(CategoryEntity category) {
        String categoryName = category.getName();
        if (categoryRepository.existsByNameIgnoreCase(categoryName)){
            throw new IllegalArgumentException("Category already exists: " + categoryName);
        }
        return categoryRepository.save(category);
    }
}
