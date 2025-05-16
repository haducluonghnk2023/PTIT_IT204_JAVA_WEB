package com.data.session09.service.ex03;

import com.data.session09.model.ex03.Schedule;
import com.data.session09.repository.ex03.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements  ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;
    @Override
    public List<Schedule> findAllScheduleByMovie(String movieTitle) {
        return scheduleRepo.findAllScheduleByMovie(movieTitle);
    }

    @Override
    public Schedule findById(Integer scheduleId) {
        return scheduleRepo.findById(scheduleId);
    }
}
