package com.data.session16.service;

import com.data.session16.model.Trip;

import java.util.List;

public interface TripService {
    /**
     * Retrieves all trips.
     *
     * @return a list of all trips
     */
    List<Trip> findAll();
    List<Trip> searchTrips(String departure, String destination, int page, int size);
    int countTrips(String departure, String destination);
}
