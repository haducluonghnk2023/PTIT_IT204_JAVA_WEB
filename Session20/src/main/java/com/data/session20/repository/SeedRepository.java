package com.data.session20.repository;

import com.data.session20.entity.Seed;

import java.util.List;

public interface SeedRepository {
    List<Seed> findAll();
    void save(Seed seed);
    void deleteById(Long id);
    Seed findById(Long id);
    void update(Seed seed);
    List<Seed> searchByKeyword(String keyword);
}
