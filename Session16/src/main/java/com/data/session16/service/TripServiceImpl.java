package com.data.session16.service;

import com.data.session16.model.Trip;
import com.data.session16.repo.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TripServiceImpl implements  TripService {

    @Autowired
    private TripRepo tripRepo;

    @Override
    public List<Trip> findAll() {
        return tripRepo.findAll();
    }

    @Override
    public List<Trip> searchTrips(String departure, String destination, int page, int size) {
        return tripRepo.searchTrips(departure, destination, page, size);
    }

    @Override
    public int countTrips(String departure, String destination) {
        return tripRepo.countTrips(departure, destination);
    }
}
