package com.data.session11.repository;

import com.data.session11.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    boolean save(Category category);
    boolean existsByCategoryName(String categoryName);
    Category findById(int id);
    void update(Category category);
    void deleteById(int id);
}
