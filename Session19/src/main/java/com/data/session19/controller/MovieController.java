package com.data.session19.controller;

import com.data.session19.service.MovieServicce;
import org.springframework.stereotype.Controller;

import com.data.session19.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieServicce movieService;

    // Hiển thị danh sách phim
    @GetMapping
    public String listMovies(Model model,
                             @RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "10") int size) {

        List<Movie> movies = movieService.findAll(page, size);
        long totalMovies = movieService.countMovies();
        int totalPages = (int) Math.ceil((double) totalMovies / size);

        model.addAttribute("movies", movies);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "movie-list"; // Thymeleaf view
    }

    // Hiển thị form thêm phim
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie-form";
    }

    // Xử lý lưu phim mới
    @PostMapping("/add")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie movie,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "movie-form";
        }
        movieService.save(movie);
        return "redirect:/movies";
    }

    // Hiển thị form cập nhật
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return "redirect:/movies";
        }
        model.addAttribute("movie", movie);
        return "movie-form";
    }

    // Xử lý cập nhật phim
    @PostMapping("/edit/{id}")
    public String updateMovie(@PathVariable Long id,
                              @Valid @ModelAttribute("movie") Movie movie,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "movie-form";
        }
        movie.setId(id);
        movieService.update(movie);
        return "redirect:/movies";
    }

    // Xoá phim
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return "redirect:/movies";
    }


}
