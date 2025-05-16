package com.data.session09.repository.ex03;

import com.data.session09.model.ex03.Schedule;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ScheduleRepoImpl implements  ScheduleRepo {
    @Override
    public List<Schedule> findAllScheduleByMovie(String movieTitle) {
        List<Schedule> schedules = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        try {
            connection = ConnectionDB.openConnection();
            // procedure lấy lịch chiếu theo tên phim
            callableStatement = connection.prepareCall("{call find_schedule_by_movie(?)}");
            callableStatement.setString(1, movieTitle);
            rs = callableStatement.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setMovieTitle(rs.getString("movieTitle"));
                schedule.setShowTime(rs.getTimestamp("showTime"));
                schedule.setScreenRoomId(rs.getLong("screenRoomId"));
                schedule.setAvailableSeats(rs.getInt("availableSeats"));
                schedule.setFormat(rs.getString("format"));
                schedules.add(schedule);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return schedules;
    }

    @Override
    public Schedule findById(Integer scheduleId) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        Schedule schedule = null;

        try {
            connection = ConnectionDB.openConnection();

            callableStatement = connection.prepareCall("{call findById(?)}");
            callableStatement.setLong(1, scheduleId);

            boolean hasResultSet = callableStatement.execute();

            if (hasResultSet) {
                rs = callableStatement.getResultSet();

                if (rs.next()) {
                    schedule = new Schedule();
                    schedule.setId(rs.getLong("id"));
                    schedule.setMovieTitle(rs.getString("movieTitle"));
                    schedule.setShowTime(rs.getTimestamp("showTime"));
                    schedule.setScreenRoomId(rs.getLong("screenRoomId"));
                    schedule.setAvailableSeats(rs.getInt("availableSeats"));
                    schedule.setFormat(rs.getString("format"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }

        return schedule;
    }
}
