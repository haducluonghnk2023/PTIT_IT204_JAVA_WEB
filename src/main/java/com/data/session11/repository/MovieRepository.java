package com.data.session11.repository;

import com.data.session11.model.Movie;

public interface MovieRepository {
    Movie findByTitle(String title);
}