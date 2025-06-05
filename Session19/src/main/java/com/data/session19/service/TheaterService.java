package com.data.session19.service;

import com.data.session19.entity.Theater;

import java.util.List;

public interface TheaterService {
    List<Theater> findAll(int pageNumber, int pageSize);
    Theater findById(Long id);
    Theater save(Theater theater);
    void deleteById(Long id);
    void update(Theater theater);
    long countTheaters();
}
