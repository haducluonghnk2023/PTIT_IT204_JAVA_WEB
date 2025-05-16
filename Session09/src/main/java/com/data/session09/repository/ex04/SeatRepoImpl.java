package com.data.session09.repository.ex04;

import com.data.session09.model.ex04.Seat;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class SeatRepoImpl implements  SeatRepo {
    @Override
    public List<Seat> findByScheduleId(Integer scheduleId) {
        List<Seat> seatList = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.openConnection();

            callableStatement = connection.prepareCall("{call findByScheduleId(?)}");
            callableStatement.setLong(1, scheduleId);

            boolean hasResultSet = callableStatement.execute();

            if (hasResultSet) {
                rs = callableStatement.getResultSet();

                while (rs.next()) {
                    Seat seat = new Seat();
                    seat.setId(rs.getLong("id"));
                    seat.setSeatNumber(rs.getString("seatNumber"));
                    seat.setPrice(rs.getDouble("price"));
                    seat.setStatus(rs.getString("status"));
                    seatList.add(seat);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           ConnectionDB.closeConnection(connection, callableStatement);
        }

        System.out.println("Số ghế lấy được: " + seatList.size());
        return seatList;
    }
}
