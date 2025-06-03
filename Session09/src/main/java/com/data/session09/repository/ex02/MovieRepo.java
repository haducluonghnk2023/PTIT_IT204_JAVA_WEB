package com.data.session09.repository.ex02;

import com.data.session09.model.ex02.Movie;

import java.util.List;

public interface MovieRepo {
    List<Movie> findAll();
    Movie findById(Long id);
}
