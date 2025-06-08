package com.data.session20.service;

import com.data.session20.entity.Seed;

import java.util.List;

public interface SeedService {
    List<Seed> findAll();
    void save(Seed seed);
    void deleteById(Long id);
    Seed findById(Long id);
    void update(Seed seed);
    List<Seed> searchByKeyword(String keyword);
}
