package com.data.session10.controller;

import com.data.session10.model.Seat;
import com.data.session10.model.Ticket;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {
    @GetMapping("/bookTicket")
    public String showBookingForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "bookingForm";
    }

    @PostMapping("/bookTicket")
    public String bookTicket(@ModelAttribute("ticket") Ticket ticket,
                             @RequestParam("seatNumbers") String seatNumbers,
                             Model model) {

        // Parse danh sách ghế từ input text
        List<Seat> seats = new ArrayList<>();
        for (String seat : seatNumbers.split(",")) {
            seats.add(new Seat(seat.trim()));
        }
        ticket.setSeats(seats);

        // Tính tổng tiền (ví dụ: 50k/vé)
        double pricePerSeat = 50000;
        ticket.setTotalAmount(pricePerSeat * seats.size());

        // Hiển thị lại thông tin đặt vé
        model.addAttribute("ticket", ticket);
        return "ticketInfo"; // Trang hiển thị thông tin vé
    }
}
