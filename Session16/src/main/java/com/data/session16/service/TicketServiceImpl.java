package com.data.session16.service;

import com.data.session16.model.Ticket;
import com.data.session16.repo.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TicketServiceImpl implements  TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    @Override
    public boolean insertTicket(Ticket ticket) {
        return ticketRepo.insertTicket(ticket);
    }

    @Override
    public List<String> getBookedSeats(int tripId, Date departureDate) {
        return ticketRepo.getBookedSeats(tripId, departureDate);
    }
}
