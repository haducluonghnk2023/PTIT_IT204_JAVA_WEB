package com.data.session19.controller;

import com.data.session19.entity.Theater;
import com.data.session19.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/theaters")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @GetMapping
    public String listTheaters(Model model,
                               @RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size) {
        List<Theater> theaters = theaterService.findAll(page, size);
        long totalTheaters = theaterService.countTheaters();
        int totalPages = (int) Math.ceil((double) totalTheaters / size);
        model.addAttribute("theaters", theaters);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "theater-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("theater", new Theater());
        return "theater-form";
    }

    @PostMapping("/add")
    public String saveTheater(@ModelAttribute("theater") Theater theater,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "theater-form";
        }
        theaterService.save(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Long id, Model model) {
        Theater theater = theaterService.findById(id);
        if (theater == null) {
            return "redirect:/theaters";
        }
        model.addAttribute("theater", theater);
        return "theater-form";
    }

    @PostMapping("/edit/{id}")
    public String updateTheater(@PathVariable("id") Long id,
                                @ModelAttribute("theater") Theater theater,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "theater-form";
        }
        theater.setId(id);
        theaterService.update(theater);
        return "redirect:/theaters";
    }

    @GetMapping("/delete/{id}")
    public String deleteTheater(@PathVariable("id") Long id) {
        theaterService.deleteById(id);
        return "redirect:/theaters";
    }
}
