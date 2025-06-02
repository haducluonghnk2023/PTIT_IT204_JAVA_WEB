package com.data.session16.service;

import com.data.session16.model.BusTrip;

import java.util.List;

public interface BusTripService {
    List<BusTrip> findAll();
    BusTrip findById(int id);
    void save(BusTrip trip);
    void update(BusTrip trip);
    void delete(int id);
}
