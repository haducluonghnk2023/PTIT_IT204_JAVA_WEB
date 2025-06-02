package com.data.session16.service;

import com.data.session16.model.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {
    boolean insertTicket(Ticket ticket);
    List<String> getBookedSeats(int tripId, Date departureDate);
}
