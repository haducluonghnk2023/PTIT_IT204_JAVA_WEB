package com.data.session11.validation;

import com.data.session11.model.Movie;
import com.data.session11.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckMovieExistByTitleImpl implements
        ConstraintValidator<CheckMovieExistByTitle, String> {

    @Autowired
    private MovieService movieService;

    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        Movie movie = movieService.findByTitle(title);
        // movie: null => thêm movie vào db
        // movie: not null => gửi message ra ngoài title
        if (movie == null) {
            return true;
        }
        return false;
    }
}