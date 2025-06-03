package com.data.session11.controller;

import com.data.session11.dto.MovieDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MovieController {

    @GetMapping("movie")
    public String movieForm(@ModelAttribute("movieDTO") MovieDTO movieDTO) {
        return "movieForm";
    }

    @PostMapping("/movie-save")
    public String movieSave(@Valid @ModelAttribute("movieDTO") MovieDTO movieDTO,
                            BindingResult result) {
        System.out.println(movieDTO);
        System.out.println(result.getFieldErrors());
        System.out.println(result.hasErrors());
        if (result.hasErrors()) {
            return "movieForm";
        }
        return "movieResult";
    }

}
