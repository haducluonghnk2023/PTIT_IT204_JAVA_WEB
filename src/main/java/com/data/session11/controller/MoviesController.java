package com.data.session11.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session11.dto.MoviesDTO;
import com.data.session11.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Controller
public class MoviesController {
    @Autowired
    private MoviesService moviesService;

    @Autowired
    private Cloudinary cloudinary;

    @GetMapping("/movies")
    public String getAllMovies(Model model) {
        model.addAttribute("movies", moviesService.getAllMovies());
        return "movieList";
    }

    @GetMapping("/edit-movie")
    public String showEditForm(@RequestParam("id") int id, Model model) {
        MoviesDTO movie = moviesService.findById(id);
        model.addAttribute("movie", movie);
        return "editMovie";
    }


    @PostMapping("/update-movie")
    public String updateMovie(
            @RequestParam("id") int id,
            @RequestParam("title") String title,
            @RequestParam("director") String director,
            @RequestParam("releaseDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date releaseDate,
            @RequestParam("genre") String genre,
            @RequestParam("poster") MultipartFile posterFile
    ) {
        MoviesDTO movie = moviesService.findById(id);

        movie.setTitle(title);
        movie.setDirector(director);
        movie.setRelease_date(releaseDate);
        movie.setGenre(genre);

        if (!posterFile.isEmpty()) {
            try {
                Map<String, Object> uploadResult = cloudinary.uploader().upload(
                        posterFile.getBytes(),
                        ObjectUtils.asMap("resource_type", "image")
                );
                String posterUrl = (String) uploadResult.get("secure_url");
                movie.setPoster(posterUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        moviesService.update(movie);
        return "redirect:/movies";
    }


    @GetMapping("/delete-movie")
    public String deleteMovie(@RequestParam("id") int id) {
        moviesService.deleteById(id);
        return "redirect:/movies";
    }
}
