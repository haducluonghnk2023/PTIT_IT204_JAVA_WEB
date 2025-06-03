package com.data.session07.repository;

import com.data.session07.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
}
