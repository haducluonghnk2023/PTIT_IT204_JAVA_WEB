package com.data.session16.repo;

import com.data.session16.model.Ticket;
import com.data.session16.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class TicketRepoImpl implements TicketRepo {

    @Override
    public boolean insertTicket(Ticket ticket) {
        Connection conn = null;
        CallableStatement stmt = null;

        try {
            conn = com.data.session16.utils.ConnectionDB.openConnection();
            stmt = conn.prepareCall("{CALL insert_ticket_proc(?, ?, ?, ?, ?)}");

            stmt.setInt(1, ticket.getUserId());
            stmt.setInt(2, ticket.getTripId());
            stmt.setString(3, ticket.getSeatList());
            stmt.setDouble(4, ticket.getTotalMoney());
            stmt.setString(5, ticket.getDepartureDate());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }
        return true;
    }

    @Override
    public List<String> getBookedSeats(int tripId, Date departureDate) {
        Connection conn = null;
        CallableStatement stmt = null;
        ResultSet rs = null;
        List<String> bookedSeats = new ArrayList<>();

        try {
            conn = ConnectionDB.openConnection();
            stmt = conn.prepareCall("{CALL get_booked_seats_proc(?, ?)}");

            stmt.setInt(1, tripId);
            stmt.setDate(2, new java.sql.Date(departureDate.getTime()));

            rs = stmt.executeQuery();

            while (rs.next()) {
                bookedSeats.add(rs.getString("seat_list"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, stmt);
        }

        return bookedSeats;
    }
}
