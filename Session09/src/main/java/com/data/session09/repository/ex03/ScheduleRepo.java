package com.data.session09.repository.ex03;

import com.data.session09.model.ex03.Schedule;

import java.util.List;

public interface ScheduleRepo {
    List<Schedule> findAllScheduleByMovie(String movieTitle);
    Schedule findById(Integer scheduleId);
}
