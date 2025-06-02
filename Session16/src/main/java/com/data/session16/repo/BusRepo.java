package com.data.session16.repo;

import com.data.session16.model.Bus;

import java.util.List;

public interface BusRepo {
    List<Bus> findAll();
    boolean save(Bus bus);
    boolean update(Bus bus);
    boolean delete(int id);
    Bus findById(int id);
}
