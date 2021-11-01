package com.g09.reto3.service;

import java.util.List;
import java.util.Optional;

import com.g09.reto3.entity.Category;

public interface CategoryService {

    Optional<Category> findOne(Long id);

    List<Category> findAllCategories();

    Category save(Category category);

    boolean delete(Long id);

    Category update(Category category);
    
}
