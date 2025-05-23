package com.data.session11.service;

import com.data.session11.model.Movie;
import com.data.session11.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements  MovieService {
    @Autowired
    private MovieRepository movieRepo;

    @Override
    public Movie findByTitle(String title) {
        return movieRepo.findByTitle(title);
    }
}
