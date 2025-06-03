package com.data.session09.controller.ex04;

import com.data.session09.model.ex03.Schedule;
import com.data.session09.model.ex03.ScreenRoom;
import com.data.session09.model.ex04.Seat;
import com.data.session09.model.ex04.TicketRequest;
import com.data.session09.service.ex03.ScheduleService;
import com.data.session09.service.ex03.ScreenRoomService;
import com.data.session09.service.ex04.SeatService;
import com.data.session09.service.ex04.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private ScreenRoomService screenRoomService;
    @PostMapping("/book")
    public ResponseEntity<?> bookTicket(@ModelAttribute TicketRequest request) {
        // 1. Kiểm tra dữ liệu đầu vào
        if (request.getCustomerId() == null ||
                request.getScheduleId() == null ||
                request.getSeatIds() == null || request.getSeatIds().isEmpty()) {
            return ResponseEntity.badRequest().body("Thông tin đặt vé không hợp lệ!");
        }

        try {
            // 2. Gọi service để xử lý lưu ticket và ghế, trả về tổng tiền
            Double totalMoney = ticketService.saveTicket(request);

            // 3. Trả kết quả thành công
            return ResponseEntity.ok("Đặt vé thành công! Tổng tiền: " + totalMoney + " VND");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Lỗi khi đặt vé, vui lòng thử lại sau.");
        }
    }

    @GetMapping("/book")
    public String showBookingPage(@RequestParam("scheduleId") Integer scheduleId, Model model) {
        Schedule schedule = scheduleService.findById(scheduleId);
        List<Seat> seatList = seatService.findByScheduleId(scheduleId);
        ScreenRoom screenRoom = screenRoomService.findById(schedule.getScreenRoomId());
        model.addAttribute("schedule", schedule);
        model.addAttribute("seatList", seatList);
        System.out.println("ScreenRoomId: " + schedule.getScreenRoomId());
        System.out.println("Danh sách ghế: " + seatList);
        model.addAttribute("screenRoom", screenRoom);
        model.addAttribute("customerId", 1L);
        return "ex04/booking";
    }
}
