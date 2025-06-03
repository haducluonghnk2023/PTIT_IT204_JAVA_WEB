package com.data.session12.repo;

import com.data.session12.model.Bus;
import com.data.session12.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BusRepoImpl implements BusRepo {
    @Override
    public List<Bus> findAll() {
        Connection conn = null;
        CallableStatement stmt = null;
        List<Bus> list = new ArrayList<>();
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_all_buses()}");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(rs.getString("bus_type"));
                bus.setRowSeat(rs.getInt("row_seat"));
                bus.setColSeat(rs.getInt("col_seat"));
                bus.setTotalSeat(rs.getInt("total_seat"));
                bus.setImage(rs.getString("image"));
                list.add(bus);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Bus findById(Integer id) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call get_bus_detail(?)}");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                Bus bus = new Bus();
                bus.setId(rs.getInt("id"));
                bus.setLicensePlate(rs.getString("license_plate"));
                bus.setBusType(rs.getString("bus_type"));
                bus.setRowSeat(rs.getInt("row_seat"));
                bus.setColSeat(rs.getInt("col_seat"));
                bus.setTotalSeat(rs.getInt("total_seat"));
                bus.setImage(rs.getString("image"));
                return bus;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return null;
    }

    @Override
    public boolean save(Bus bus) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call add_new_bus(?,?,?,?,?)}");
            stmt.setString(1, bus.getLicensePlate());
            stmt.setString(2, bus.getBusType());
            stmt.setInt(3,bus.getRowSeat());
            stmt.setInt(4, bus.getColSeat());
            stmt.setString(5, bus.getImage());

            return stmt.executeUpdate() > 0;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call delete_bus(?)}");
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
    public boolean update(Bus bus) {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{call update_bus(?,?,?,?,?,?)}");
            stmt.setInt(1,bus.getId());
            stmt.setString(2, bus.getLicensePlate());
            stmt.setString(3, bus.getBusType());
            stmt.setInt(4, bus.getRowSeat());
            stmt.setInt(5, bus.getColSeat());
            stmt.setString(6, bus.getImage());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,stmt);
        }
        return false;
    }
}
