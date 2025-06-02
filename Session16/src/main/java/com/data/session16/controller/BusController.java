package com.data.session16.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session16.model.Bus;
import com.data.session16.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/admin/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private Cloudinary cloudinary;

    // Kiểm tra quyền truy cập
    @ModelAttribute
    public void checkAdmin(HttpSession session, HttpServletResponse response) throws IOException {
        String role = (String) session.getAttribute("role");
        if (!"admin".equals(role)) {
            response.sendRedirect("/login");
        }
    }

    @GetMapping
    public String listBuses(Model model) {
        model.addAttribute("busList", busService.findAll());
        return "bus_management";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("bus", new Bus());
        model.addAttribute("formAction", "/admin/bus/save");
        return "form";
    }

    @PostMapping("/save")
    public String saveBus(@ModelAttribute Bus bus, Model model) {
        MultipartFile image = bus.getImage();

        try {
            if (image != null && !image.isEmpty()) {
                Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
                String imageUrl = (String) uploadResult.get("url");

                if (imageUrl == null || imageUrl.isEmpty()) {
                    throw new RuntimeException("Image upload failed");
                }

                bus.setImageUrl(imageUrl);
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Image upload failed: " + e.getMessage());
            return "form";
        }

        busService.save(bus);
        return "redirect:/admin/bus";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("bus", busService.findById(id));
        model.addAttribute("formAction", "/admin/bus/update");
        return "form";
    }

    @PostMapping("/update")
    public String updateBus(@ModelAttribute Bus bus, Model model) {
        try {
            MultipartFile image = bus.getImage();
            if (image != null && !image.isEmpty()) {
                Map uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
                String imageUrl = (String) uploadResult.get("url");

                if (imageUrl == null || imageUrl.isEmpty()) {
                    throw new RuntimeException("Image upload failed");
                }

                bus.setImageUrl(imageUrl);
            } else {
                // Giữ nguyên ảnh cũ, cần lấy bus cũ từ DB để giữ imageUrl
                Bus existingBus = busService.findById(bus.getId());
                if (existingBus != null) {
                    bus.setImageUrl(existingBus.getImageUrl());
                }
            }
            busService.update(bus);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Image upload failed: " + e.getMessage());
            return "form";
        }
        return "redirect:/admin/bus";
    }


    @GetMapping("/delete/{id}")
    public String deleteBus(@PathVariable int id) {
        busService.delete(id);
        return "redirect:/admin/bus";
    }

}
