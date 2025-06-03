package com.data.session16.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session16.model.BusTrip;
import com.data.session16.service.BusService;
import com.data.session16.service.BusTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin/bustrip")
public class BusTripController {

    @Autowired
    private BusTripService busTripService;

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BusService busService;

    @ModelAttribute
    public void checkAdmin(HttpSession session, HttpServletResponse response) throws IOException {
        String role = (String) session.getAttribute("role");
        if (!"admin".equals(role)) {
            response.sendRedirect("/login");
        }
    }

    @GetMapping
    public String listBusTrips(Model model, @RequestParam(value = "message", required = false) String message) {
        model.addAttribute("tripList", busTripService.findAll());
        model.addAttribute("message", message);
        return "bustrip_management";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        prepareForm(model, new BusTrip(), "/admin/bustrip/save");
        return "bustrip_form";
    }

    @PostMapping("/save")
    public String saveBusTrip(@Valid @ModelAttribute BusTrip busTrip,
                              BindingResult result,
                              Model model,
                              RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            prepareForm(model, busTrip, "/admin/bustrip/save");
            return "bustrip_form";
        }

        try {
            handleImageUpload(busTrip);
            busTripService.save(busTrip);
            redirectAttributes.addAttribute("message", "Thêm chuyến xe thành công!");
            return "redirect:/admin/bustrip";
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi upload ảnh: " + e.getMessage());
            prepareForm(model, busTrip, "/admin/bustrip/save");
            return "bustrip_form";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        BusTrip trip = busTripService.findById(id);
        if (trip == null) {
            redirectAttributes.addAttribute("message", "Không tìm thấy chuyến xe.");
            return "redirect:/admin/bustrip";
        }
        prepareForm(model, trip, "/admin/bustrip/update");
        return "bustrip_form";
    }

    @PostMapping("/update")
    public String updateBusTrip(@Valid @ModelAttribute BusTrip busTrip,
                                BindingResult result,
                                Model model,
                                RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            prepareForm(model, busTrip, "/admin/bustrip/update");
            return "bustrip_form";
        }

        try {
            handleImageUpload(busTrip); // chỉ set lại ảnh nếu người dùng upload ảnh mới
            busTripService.update(busTrip);
            redirectAttributes.addAttribute("message", "Cập nhật chuyến xe thành công!");
            return "redirect:/admin/bustrip";
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi upload ảnh: " + e.getMessage());
            prepareForm(model, busTrip, "/admin/bustrip/update");
            return "bustrip_form";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTrip(@PathVariable int id, RedirectAttributes redirectAttributes) {
        busTripService.delete(id);
        redirectAttributes.addAttribute("message", "Xóa chuyến xe thành công!");
        return "redirect:/admin/bustrip";
    }

    // ========== Helper Methods ==========

    private void handleImageUpload(BusTrip busTrip) throws IOException {
        MultipartFile image = busTrip.getImageFile();
        if (image != null && !image.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
            busTrip.setImage((String) uploadResult.get("url"));
        }
        // nếu không upload mới => giữ nguyên ảnh cũ
    }

    private void prepareForm(Model model, BusTrip busTrip, String actionUrl) {
        model.addAttribute("busTrip", busTrip);
        model.addAttribute("busList", busService.findAll());
        model.addAttribute("formAction", actionUrl);
    }
}
