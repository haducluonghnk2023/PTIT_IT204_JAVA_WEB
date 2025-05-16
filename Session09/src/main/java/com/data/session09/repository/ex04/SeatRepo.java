package com.data.session09.repository.ex04;

import com.data.session09.model.ex04.Seat;

import java.util.List;

public interface SeatRepo {
    List<Seat> findByScheduleId(Integer scheduleId);
}
