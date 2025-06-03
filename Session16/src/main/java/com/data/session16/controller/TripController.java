package com.data.session16.controller;

import com.data.session16.service.TripService;
import com.data.session16.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping("/trips")
    public String getTrips(@RequestParam(defaultValue = "") String departure,
                           @RequestParam(defaultValue = "") String destination,
                           @RequestParam(defaultValue = "1") int page,
                           Model model) {
        int pageSize = 5;

        List<Trip> trips = tripService.searchTrips(departure, destination, page, pageSize);
        int totalTrips = tripService.countTrips(departure, destination);
        int totalPages = (int) Math.ceil((double) totalTrips / pageSize);

        model.addAttribute("listTrips", trips);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("departure", departure);
        model.addAttribute("destination", destination);

        return "home";
    }
}
