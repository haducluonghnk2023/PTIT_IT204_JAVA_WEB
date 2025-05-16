package com.data.session09.service.ex03;

import com.data.session09.model.ex03.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> findAllScheduleByMovie(String movieTitle);
    Schedule findById(Integer scheduleId);
}
