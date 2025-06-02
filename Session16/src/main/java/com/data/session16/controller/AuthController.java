package com.data.session16.controller;

import com.data.session16.dto.UserDTO;
import com.data.session16.model.User;
import com.data.session16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showFromRegister(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute @Valid UserDTO userDTO,
                           BindingResult bindingResult,
                           Model model,
                           HttpSession session) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userDTO);
            return "register";
        }

        if (userService.findByUsername(userDTO.getUsername()) != null) {
            model.addAttribute("error", "Tên đăng nhập đã tồn tại");
            model.addAttribute("user", userDTO);
            return "register";
        }


        // ✅ Tạo đối tượng user từ DTO
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRole("USER");
        user.setStatus("ACTIVE");

        // ✅ Lưu user vào DB
        userService.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        User user = userService.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            model.addAttribute("error", "Tài khoản hoặc mật khẩu không đúng");
            return "login";
        }

        session.setAttribute("loggedInUser", user);
        session.setAttribute("userId", user.getId());
        session.setAttribute("role", user.getRole());

        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            return "redirect:/admin/bus";
        } else {
            return "redirect:/trips";
        }
    }
}
