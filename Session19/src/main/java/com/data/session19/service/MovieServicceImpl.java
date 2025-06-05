package com.data.session19.service;

import com.data.session19.entity.Movie;
import com.data.session19.repo.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServicceImpl implements  MovieServicce {
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public List<Movie> findAll(int pageNumber, int pageSize) {
        return movieRepo.findAll(pageNumber, pageSize);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepo.findById(id);
    }

    @Override
    public Movie save(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public void deleteById(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    public void update(Movie movie) {
        movieRepo.update(movie);
    }

    @Override
    public long countMovies() {
        return movieRepo.countMovies();
    }
}
