package com.data.session07.repository;

import com.data.session07.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryRepositoryImpl implements  CategoryRepository {
    private final List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(categories);
    }
}
