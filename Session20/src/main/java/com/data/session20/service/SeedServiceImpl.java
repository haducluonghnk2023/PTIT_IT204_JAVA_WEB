package com.data.session20.service;

import com.data.session20.entity.Seed;
import com.data.session20.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeedServiceImpl implements SeedService {
    @Autowired
    private SeedRepository seedRepository;
    @Override
    public List<Seed> findAll() {
        return seedRepository.findAll();
    }

    @Override
    public void save(Seed seed) {
        seedRepository.save(seed);
    }

    @Override
    public void deleteById(Long id) {
        seedRepository.deleteById(id);
    }

    @Override
    public Seed findById(Long id) {
        return seedRepository.findById(id);
    }

    @Override
    public void update(Seed seed) {
        seedRepository.update(seed);
    }

    @Override
    public List<Seed> searchByKeyword(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return findAll();
        }
        return seedRepository.searchByKeyword(keyword);
    }
}
