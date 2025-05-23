package com.data.session11.repository;

import com.data.session11.dto.MoviesDTO;

import java.util.List;

public interface MovieRepo {
    void addMovie(MoviesDTO movie);
    List<MoviesDTO> getAllMovies();
    void update(MoviesDTO movie);
    MoviesDTO findById(int id);
    void deleteById(int id);
}
