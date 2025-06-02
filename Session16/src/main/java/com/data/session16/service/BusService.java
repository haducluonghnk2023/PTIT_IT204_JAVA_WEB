package com.data.session16.service;

import com.data.session16.model.Bus;

import java.util.List;

public interface BusService {
    List<Bus> findAll();
    boolean save(Bus bus);
    boolean update(Bus bus);
    boolean delete(int id);
    Bus findById(int id);
}
