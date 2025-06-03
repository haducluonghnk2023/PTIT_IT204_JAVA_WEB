package com.data.session09.service.ex04;

import com.data.session09.model.ex04.Seat;
import com.data.session09.model.ex04.Ticket;
import com.data.session09.model.ex04.TicketRequest;
import com.data.session09.repository.ex04.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    public Double saveTicket(TicketRequest request) {
        // Tạo ticket từ ticketRequest
        Ticket ticket = new Ticket();
        ticket.setCustomerId(request.getCustomerId());
        ticket.setScheduleId(request.getScheduleId());

        // Tính tổng tiền (ví dụ giá mỗi ghế 100k)
        double seatPrice = 100000.0;
        double totalMoney = seatPrice * request.getSeatIds().size();
        ticket.setTotalMoney(totalMoney);

        // Chuyển list seatId sang list Seat object
        List<Seat> seats = new ArrayList<>();
        for (Long seatId : request.getSeatIds()) {
            Seat seat = new Seat();
            seat.setId(seatId);
            seats.add(seat);
        }
        ticket.setListSeat(seats);

        // Gọi repo lưu vé và ghế
        ticketRepo.saveTicket(ticket);

        return totalMoney;
    }
}
