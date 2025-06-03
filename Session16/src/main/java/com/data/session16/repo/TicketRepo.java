package com.data.session16.repo;

import com.data.session16.model.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketRepo {
    boolean insertTicket(Ticket ticket);
    List<String> getBookedSeats(int tripId, Date departureDate);
}
