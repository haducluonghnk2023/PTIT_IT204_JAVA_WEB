package com.data.session09.service.ex04;

import com.data.session09.model.ex04.Seat;
import com.data.session09.repository.ex04.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements  SeatService {
    @Autowired
    private SeatRepo seatRepo;
    @Override
    public List<Seat> findByScheduleId(Integer scheduleId) {
        return seatRepo.findByScheduleId(scheduleId);
    }
}
