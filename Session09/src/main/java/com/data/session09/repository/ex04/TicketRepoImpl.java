package com.data.session09.repository.ex04;

import com.data.session09.model.ex04.Seat;
import com.data.session09.model.ex04.Ticket;
import com.data.session09.utils.ConnectionDB;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;

@Repository
public class TicketRepoImpl implements TicketRepo {

    @Override
    public void saveTicket(Ticket ticket) {
        Connection connection = null;
        CallableStatement saveTicketStmt = null;
        CallableStatement saveSeatStmt = null;

        try {
            // Mở kết nối và bắt đầu transaction
            connection = ConnectionDB.openConnection();
            connection.setAutoCommit(false);

            // 1. Gọi procedure để lưu ticket
            saveTicketStmt = connection.prepareCall("{call save_ticket(?, ?, ?, ?)}");
            saveTicketStmt.setLong(1, ticket.getCustomerId());
            saveTicketStmt.setLong(2, ticket.getScheduleId());
            saveTicketStmt.setDouble(3, ticket.getTotalMoney());
            saveTicketStmt.registerOutParameter(4, java.sql.Types.BIGINT); // trả về ticketId
            saveTicketStmt.execute();

            Long ticketId = saveTicketStmt.getLong(4); // Lấy id vé vừa tạo

            // 2. Duyệt qua danh sách ghế để lưu vào bảng ticket_seat
            for (Seat seat : ticket.getListSeat()) {
                saveSeatStmt = connection.prepareCall("{call save_ticket_seat(?, ?)}");
                saveSeatStmt.setLong(1, ticketId);
                saveSeatStmt.setLong(2, seat.getId());
                saveSeatStmt.execute();
                saveSeatStmt.close(); // đóng từng callable cho từng seat
            }

            connection.commit(); // Commit nếu không lỗi

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (connection != null) connection.rollback(); // rollback nếu lỗi
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } finally {
            // Đóng kết nối và statement
            ConnectionDB.closeConnection(connection, saveTicketStmt);
            ConnectionDB.closeConnection(null, saveSeatStmt);
        }
    }
}
