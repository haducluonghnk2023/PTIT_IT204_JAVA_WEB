package com.data.session16.service;

import com.data.session16.model.Bus;
import com.data.session16.repo.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusServiceImpl implements  BusService {
    @Autowired
    private BusRepo busRepo;
    @Override
    public List<Bus> findAll() {
        return busRepo.findAll();
    }

    @Override
    public boolean save(Bus bus) {
        return busRepo.save(bus);
    }

    @Override
    public boolean update(Bus bus) {
        return busRepo.update(bus);
    }

    @Override
    public boolean delete(int id) {
        return busRepo.delete(id);
    }

    @Override
    public Bus findById(int id) {
        return busRepo.findById(id);
    }
}
