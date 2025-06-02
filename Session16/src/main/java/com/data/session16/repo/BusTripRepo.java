package com.data.session16.repo;

import com.data.session16.model.BusTrip;

import java.util.List;

public interface BusTripRepo {
    List<BusTrip> findAll();
    BusTrip findById(int id);
    void save(BusTrip trip);
    void update(BusTrip trip);
    void delete(int id);
}
