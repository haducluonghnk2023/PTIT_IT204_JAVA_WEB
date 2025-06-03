package com.data.session16.repo;

import com.data.session16.model.Trip;
import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class TripRepoImpl implements  TripRepo {
    @Override
    public List<Trip> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Trip> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call FindAllBuses()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setDeparture(rs.getString("departure"));
                trip.setDestination(rs.getString("destination"));
                trip.setDepartureTime(rs.getString("departure_time"));
                trip.setPrice(rs.getDouble("price"));
                list.add(trip);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Trip> searchTrips(String departure, String destination, int page, int size) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<Trip> list = new ArrayList<>();

        int offset = (page - 1) * size;

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call search_trips(?, ?, ?, ?)}");
            stmt.setString(1, departure);
            stmt.setString(2, destination);
            stmt.setInt(3, offset);
            stmt.setInt(4, size);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Trip trip = new Trip();
                trip.setId(rs.getInt("id"));
                trip.setDeparture(rs.getString("departure"));
                trip.setDestination(rs.getString("destination"));
                trip.setDepartureTime(rs.getString("departure_time"));
                trip.setPrice(rs.getDouble("price"));
                list.add(trip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int countTrips(String departure, String destination) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        int total = 0;

        try {
            conn = ConnectionDB.openConnection();
            String sql = "SELECT COUNT(*) FROM trip WHERE departure LIKE ? AND destination LIKE ?";
            stmt = conn.prepareCall(sql);
            stmt.setString(1, "%" + departure + "%");
            stmt.setString(2, "%" + destination + "%");
            rs = stmt.executeQuery();

            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
