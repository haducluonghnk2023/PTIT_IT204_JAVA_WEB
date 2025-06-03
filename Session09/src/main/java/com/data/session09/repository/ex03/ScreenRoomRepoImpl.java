package com.data.session09.repository.ex03;

import com.data.session09.model.ex03.ScreenRoom;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ScreenRoomRepoImpl implements  ScreenRoomRepo {
    @Override
    public List<ScreenRoom> findAll() {
        List<ScreenRoom> screenRooms = new ArrayList<>();
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        try {
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call find_all_screenrooms()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {
                ScreenRoom screenRoom = new ScreenRoom();
                screenRoom.setId(rs.getLong("id"));
                screenRoom.setScreenRoomName(rs.getString("screenRoomName"));
                screenRoom.setTotalSeat(rs.getInt("totalSeat"));
                screenRooms.add(screenRoom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return screenRooms;
    }

    @Override
    public ScreenRoom findById(Long id) {
        Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet rs = null;
        ScreenRoom screenRoom = null;
        try{
            connection = ConnectionDB.openConnection();
            callableStatement = connection.prepareCall("{call find_screen_room_by_id(?)}");
            callableStatement.setLong(1, id);
            rs = callableStatement.executeQuery();
            if (rs.next()) {
                screenRoom = new ScreenRoom();
                screenRoom.setId(rs.getLong("id"));
                screenRoom.setScreenRoomName(rs.getString("screenRoomName"));
                screenRoom.setTotalSeat(rs.getInt("totalSeat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(connection, callableStatement);
        }
        return screenRoom;
    }
}
