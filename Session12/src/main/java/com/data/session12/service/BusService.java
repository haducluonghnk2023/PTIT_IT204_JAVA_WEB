package com.data.session12.service;

import com.data.session12.model.Bus;

import java.util.List;

public interface BusService {
    List<Bus> findAll();
    Bus findById(Integer id);
    boolean save(Bus bus);
    boolean deleteById(Integer id);
    boolean update(Bus bus);
}
