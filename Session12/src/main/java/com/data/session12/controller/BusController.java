package com.data.session12.controller;

import com.data.session12.model.Bus;
import com.data.session12.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BusController {
    @Autowired
    private BusService busService;

    @GetMapping("/bus")
    public String bus(Model model) {
        model.addAttribute("bus",busService.findAll());
        return "busList";
    }

    @GetMapping("/bus/add")
    public String addBus(Model model) {
        model.addAttribute("bus", new Bus());
        return "formAddBus";
    }

    @PostMapping("/bus/save")
    public String saveBus(@ModelAttribute("bus")  Bus bus) {
        if (bus.getId() == null || bus.getId() == 0) {
            busService.save(bus);
        } else {
            busService.update(bus);
        }
        return "redirect:/bus";
    }

    @GetMapping("/bus/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Bus bus = busService.findById(id);
        if (bus == null) {
            return "redirect:/bus";
        }
        model.addAttribute("bus", bus);
        return "formAddBus";
    }


    @GetMapping("/bus/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        busService.deleteById(id);
        return "redirect:/bus";
    }

    @GetMapping("/bus/detail/{id}")
    public String detailProduct(@PathVariable("id") int id, Model model) {
        Bus bus = busService.findById(id);
        if (bus == null) {
            return "redirect:/bus";
        }
        model.addAttribute("bus", bus);
        return "busDetail";
    }
}
