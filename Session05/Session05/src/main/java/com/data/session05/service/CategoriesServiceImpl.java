package com.data.session05.service;

import com.data.session05.dao.CategoriesDAO;
import com.data.session05.dao.CategoriesDAOImpl;
import com.data.session05.model.Categories;

import java.util.List;

public class CategoriesServiceImpl implements  CategoriesService {
    public final CategoriesDAO categoriesDAO ;

    public CategoriesServiceImpl() {
        categoriesDAO = new CategoriesDAOImpl();
    }

    @Override
    public List<Categories> findAll() {
        return categoriesDAO.findAll();
    }

    @Override
    public boolean save(Categories catalog) {
        return categoriesDAO.save(catalog);
    }
}
