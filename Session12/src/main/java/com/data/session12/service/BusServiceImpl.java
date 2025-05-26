package com.data.session12.service;

import com.data.session12.model.Bus;
import com.data.session12.repo.BusRepo;
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
    public Bus findById(Integer id) {
        return busRepo.findById(id);
    }

    @Override
    public boolean save(Bus bus) {
        return busRepo.save(bus);
    }

    @Override
    public boolean deleteById(Integer id) {
        return busRepo.deleteById(id);
    }

    @Override
    public boolean update(Bus bus) {
        return busRepo.update(bus);
    }
}
