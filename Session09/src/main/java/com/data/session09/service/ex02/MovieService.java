package com.data.session09.service.ex02;

import com.data.session09.model.ex02.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(Long id);
}
