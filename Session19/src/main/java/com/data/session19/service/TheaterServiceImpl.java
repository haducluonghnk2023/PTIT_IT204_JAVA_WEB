package com.data.session19.service;

import com.data.session19.entity.Theater;
import com.data.session19.repo.TheaterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private TheaterRepo theaterRepo;
    @Override
    public List<Theater> findAll(int pageNumber, int pageSize) {
        return theaterRepo.findAll(pageNumber, pageSize);
    }

    @Override
    public Theater findById(Long id) {
        return theaterRepo.findById(id);
    }

    @Override
    public Theater save(Theater theater) {
        return theaterRepo.save(theater);
    }

    @Override
    public void deleteById(Long id) {
        theaterRepo.deleteById(id);
    }

    @Override
    public void update(Theater theater) {
        theaterRepo.update(theater);
    }

    @Override
    public long countTheaters() {
        return theaterRepo.countTheaters();
    }
}
