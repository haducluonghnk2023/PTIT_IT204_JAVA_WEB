package com.data.session09.controller.ex02;

import com.data.session09.model.ex02.Movie;
import com.data.session09.model.ex03.Schedule;
import com.data.session09.model.ex03.ScreenRoom;
import com.data.session09.service.ex02.MovieService;
import com.data.session09.service.ex03.ScheduleService;
import com.data.session09.service.ex03.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping("ex01/home")
    public String showHome(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "ex01/home"; // trả về home.html
    }

    // Hiển thị chi tiết 1 bộ phim
    @GetMapping("ex02/detailMovie")
    public String detailMovie(@RequestParam("id") Long id, Model model) {
        // Lấy thông tin phim
        Movie movie = movieService.findById(id);

        // Lấy danh sách lịch chiếu theo tên phim
        List<Schedule> schedules = scheduleService.findAllScheduleByMovie(movie.getTitle());

        // Lấy danh sách phòng chiếu
        List<ScreenRoom> screenRooms = screenRoomService.findAll();

        // Truyền dữ liệu ra view
        model.addAttribute("movie", movie);
        model.addAttribute("schedules", schedules);
        model.addAttribute("screenRooms", screenRooms);

        return "ex02/detailMovie"; // trả về trang detailMovie.jsp
    }
}
