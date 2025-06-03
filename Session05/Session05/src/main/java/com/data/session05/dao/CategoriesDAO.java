package com.data.session05.dao;

import com.data.session05.model.Categories;

import java.util.List;

public interface CategoriesDAO {
    List<Categories> findAll();
    boolean save(Categories catalog);
}
