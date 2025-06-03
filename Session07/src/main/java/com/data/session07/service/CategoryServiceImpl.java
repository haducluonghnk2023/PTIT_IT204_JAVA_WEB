package com.data.session07.service;

import com.data.session07.model.Category;
import com.data.session07.repository.CategoryRepository;
import com.data.session07.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements  CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
