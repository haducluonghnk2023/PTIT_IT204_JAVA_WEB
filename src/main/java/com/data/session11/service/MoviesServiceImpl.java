package com.data.session11.service;

import com.data.session11.dto.MoviesDTO;
import com.data.session11.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MoviesServiceImpl implements  MoviesService {

    @Autowired
    private MovieRepo movieRepo;
    @Override
    public void addMovie(MoviesDTO movie) {
        movieRepo.addMovie(movie);
    }

    @Override
    public List<MoviesDTO> getAllMovies() {
        return movieRepo.getAllMovies();
    }

    @Override
    public void update(MoviesDTO movie) {
        movieRepo.update(movie);
    }

    @Override
    public MoviesDTO findById(int id) {
        return movieRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        movieRepo.deleteById(id);
    }
}
