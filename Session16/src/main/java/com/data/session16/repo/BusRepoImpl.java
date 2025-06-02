package com.data.session16.repo;

import com.data.session16.model.Bus;
import com.data.session16.model.BusType;
import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class BusRepoImpl implements  BusRepo {
    @Override
    public List<Bus> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Bus> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call FindAllBuses()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(BusType.fromString(rs.getString("bus_type")));
                bus.setRowSeats(rs.getInt("row_seat"));
                bus.setColumnSeats(rs.getInt("col_seat"));
                bus.setTotalSeats(rs.getInt("total_seat"));
                bus.setImageUrl(rs.getString("image"));
                list.add(bus);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Bus bus) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call AddBus(?,?,?,?,?)}");
            stmt.setString(1, bus.getLicensePlate());
            stmt.setString(2, bus.getBusType() != null ? bus.getBusType().toString() : "NORMAL");
            stmt.setInt(3, bus.getRowSeats());
            stmt.setInt(4, bus.getColumnSeats());
            stmt.setString(5, bus.getImageUrl());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return false;
    }

    @Override
    public boolean update(Bus bus) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call UpdateBus(?, ?, ?, ?, ?, ?)}");
            stmt.setInt(1, bus.getId());
            stmt.setString(2, bus.getLicensePlate());
            stmt.setString(3, bus.getBusType() != null ? bus.getBusType().toString() : "NORMAL");
            stmt.setInt(4, bus.getRowSeats());
            stmt.setInt(5, bus.getColumnSeats());
            stmt.setString(6, bus.getImageUrl());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return false;
    }


    @Override
    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call DeleteBus(?)}");
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public Bus findById(int id) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call FindSeatsByBusId(?)}");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(BusType.fromString(rs.getString("bus_type")));
                bus.setRowSeats(rs.getInt("row_seat"));
                bus.setColumnSeats(rs.getInt("col_seat"));
                bus.setTotalSeats(rs.getInt("total_seat"));
                bus.setImageUrl(rs.getString("image"));
                return bus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return null;
    }
}
