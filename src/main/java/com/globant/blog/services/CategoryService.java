package com.globant.blog.services;

import com.globant.blog.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    List<CategoryEntity> listCategories();
    CategoryEntity createCategory(CategoryEntity category);
}
