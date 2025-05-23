package com.data.session11.service;

import com.data.session11.model.Movie;

public interface MovieService {
    Movie findByTitle(String title);
}