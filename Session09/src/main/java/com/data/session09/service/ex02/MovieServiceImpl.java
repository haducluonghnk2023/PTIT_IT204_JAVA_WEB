package com.data.session09.service.ex02;

import com.data.session09.model.ex02.Movie;
import com.data.session09.repository.ex02.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements  MovieService {
    @Autowired
    private MovieRepo movieRepo;
    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Movie findById(Long id) {
        return movieRepo.findById(id);
    }
}
