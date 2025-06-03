package com.data.session16.controller;

import com.data.session16.model.BusTrip;
import com.data.session16.model.Ticket;
import com.data.session16.service.BusTripService;
import com.data.session16.service.TicketService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class TicketController {

    @Autowired
    private BusTripService busTripService;

    @Autowired
    private TicketService ticketService;

    // Hiển thị form đặt vé
    @GetMapping("/ticket")
    public String showTicketForm(@RequestParam("tripId") int tripId, Model model) {
        BusTrip trip = busTripService.findById(tripId);
        model.addAttribute("trip", trip);
        model.addAttribute("today", LocalDate.now());
        return "ticket";  // trả về view ticket.html
    }

    // Xử lý đặt vé (nhận dữ liệu form POST)
    @PostMapping("/tickets/book")
    public String bookTicket(
            @RequestParam("tripId") int tripId,
            @RequestParam("departureDate") String departureDate,
            @RequestParam("seatList") String seatList,
            @RequestParam("totalMoney") double totalMoney,
            HttpSession session,
            Model model
    ) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/login";
        }

        Ticket ticket = new Ticket();
        ticket.setUserId(userId);
        ticket.setTripId(tripId);
        ticket.setDepartureDate(departureDate);
        ticket.setSeatList(seatList);
        ticket.setTotalMoney(totalMoney);

        boolean success = ticketService.insertTicket(ticket);
        if (success) {
            model.addAttribute("message", "Đặt vé thành công!");
            return "redirect:/my-tickets";
        } else {
            model.addAttribute("error", "Đặt vé thất bại, vui lòng thử lại!");
            return "ticket";
        }
    }
}
