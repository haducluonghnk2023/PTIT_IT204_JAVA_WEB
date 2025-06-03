package com.data.session16.service;

import com.data.session16.model.BusTrip;
import com.data.session16.repo.BusTripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusTripServiceImpl implements  BusTripService {
    @Autowired
    private BusTripRepo busTripRepo;


    @Override
    public List<BusTrip> findAll() {
        return busTripRepo.findAll();
    }

    @Override
    public BusTrip findById(int id) {
        return busTripRepo.findById(id);
    }

    @Override
    public void save(BusTrip trip) {
        busTripRepo.save(trip);
    }

    @Override
    public void update(BusTrip trip) {
        busTripRepo.update(trip);
    }

    @Override
    public void delete(int id) {
        busTripRepo.delete(id);
    }
}
