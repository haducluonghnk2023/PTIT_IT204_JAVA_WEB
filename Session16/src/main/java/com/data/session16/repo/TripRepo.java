package com.data.session16.repo;

import com.data.session16.model.Trip;

import java.util.List;

public interface TripRepo {
    List<Trip> findAll();
    List<Trip> searchTrips(String departure, String destination, int page, int size);
    int countTrips(String departure, String destination);
}
