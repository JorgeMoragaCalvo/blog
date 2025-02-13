package com.globant.blog.services;

import com.globant.blog.entities.CategoryEntity;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryEntity> listCategories();
    CategoryEntity createCategory(CategoryEntity category);
    void deleteCategory(UUID id);
}
