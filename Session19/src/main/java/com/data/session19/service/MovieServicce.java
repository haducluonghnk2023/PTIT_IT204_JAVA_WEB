package com.data.session19.service;

import com.data.session19.entity.Movie;

import java.util.List;

public interface MovieServicce {
    List<Movie> findAll(int pageNumber, int pageSize);
    Movie findById(Long id);
    Movie save(Movie movie);
    void deleteById(Long id);
    void update(Movie movie);
    long countMovies();
}
