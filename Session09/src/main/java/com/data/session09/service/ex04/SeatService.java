package com.data.session09.service.ex04;

import com.data.session09.model.ex04.Seat;

import java.util.List;

public interface SeatService {
    List<Seat> findByScheduleId(Integer scheduleId);
}
