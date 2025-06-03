package com.data.session16.repo;

import com.data.session16.model.BusTrip;
import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Repository
public class BusTripRepoImpl implements BusTripRepo{

    @Override
    public List<BusTrip> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<BusTrip> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sp_findAllBusTrips()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                BusTrip busTrip = new BusTrip();
                busTrip.setId(rs.getInt("id"));
                busTrip.setDeparturePoint(rs.getString("departure_point"));
                busTrip.setDestination(rs.getString("destination"));
                busTrip.setDepartureTime(rs.getString("departure_time"));
                busTrip.setArrivalTime(rs.getString("arrival_time"));
                busTrip.setBusId(rs.getInt("bus_id"));
                busTrip.setSeatsAvailable(rs.getInt("seats_available"));
                busTrip.setImage(rs.getString("image"));
                list.add(busTrip);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return list;
    }


    @Override
    public BusTrip findById(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sp_findBusTripById(?)}");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                BusTrip trip = new BusTrip();
                trip.setId(rs.getInt("id"));
                trip.setDeparturePoint(rs.getString("departure_point"));
                trip.setDestination(rs.getString("destination"));
                trip.setDepartureTime(rs.getString("departure_time"));
                trip.setArrivalTime(rs.getString("arrival_time"));
                trip.setBusId(rs.getInt("bus_id"));
                trip.setSeatsAvailable(rs.getInt("seats_available"));
                trip.setImage(rs.getString("image"));
                return trip;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return null;
    }

    @Override
    public void save(BusTrip trip) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sp_saveBusTrip(?,?,?,?,?,?,?)}");
            stmt.setString(1, trip.getDeparturePoint());
            stmt.setString(2, trip.getDestination());
            stmt.setString(3, trip.getDepartureTime());
            stmt.setString(4, trip.getArrivalTime());
            stmt.setInt(5, trip.getBusId());
            stmt.setInt(6, trip.getSeatsAvailable());
            stmt.setString(7, trip.getImage());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }


    @Override
    public void update(BusTrip trip) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sp_updateBusTrip(?,?,?,?,?,?,?,?)}");
            stmt.setInt(1, trip.getId());
            stmt.setString(2, trip.getDeparturePoint());
            stmt.setString(3, trip.getDestination());
            stmt.setString(4, trip.getDepartureTime());
            stmt.setString(5, trip.getArrivalTime());
            stmt.setInt(6, trip.getBusId());
            stmt.setInt(7, trip.getSeatsAvailable());
            stmt.setString(8, trip.getImage());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }


    @Override
    public void delete(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call sp_deleteBusTrip(?)}");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
    }

}
