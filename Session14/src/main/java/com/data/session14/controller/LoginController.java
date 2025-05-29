package com.data.session14.controller;

import com.data.session14.model.User;
import com.data.session14.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String showLoginForm(HttpServletRequest request, Model model) {
        User user = new User();
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    user.setUsername(cookie.getValue());
                }
                if ("password".equals(cookie.getName())) {
                    user.setPassword(cookie.getValue());
                }
                if ("remember".equals(cookie.getName()) && "true".equals(cookie.getValue())) {
                    user.setRememberMe(true);
                }
            }
        }

        model.addAttribute("user", user);
        return "login";
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user,
                        HttpSession session,
                        HttpServletRequest request,
                        javax.servlet.http.HttpServletResponse response,
                        Model model) {
        if (authService.authenticate(user)) {
            session.setAttribute("loggedInUser", user.getUsername());

            // Nếu người dùng chọn "Ghi nhớ tôi", lưu vào cookie
            if (user.isRememberMe()) {
                Cookie usernameCookie = new Cookie("username", user.getUsername());
                Cookie passwordCookie = new Cookie("password", user.getPassword());
                Cookie rememberCookie = new Cookie("remember", "true");

                // Đặt thời hạn cookie (VD: 7 ngày)
                int expiry = 7 * 24 * 60 * 60;
                usernameCookie.setMaxAge(expiry);
                passwordCookie.setMaxAge(expiry);
                rememberCookie.setMaxAge(expiry);

                // Đặt path để cookie áp dụng toàn bộ ứng dụng
                usernameCookie.setPath("/");
                passwordCookie.setPath("/");
                rememberCookie.setPath("/");

                // Thêm vào response
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                response.addCookie(rememberCookie);
            } else {
                // Xóa cookie nếu không muốn ghi nhớ
                Cookie usernameCookie = new Cookie("username", null);
                Cookie passwordCookie = new Cookie("password", null);
                Cookie rememberCookie = new Cookie("remember", null);

                usernameCookie.setMaxAge(0);
                passwordCookie.setMaxAge(0);
                rememberCookie.setMaxAge(0);

                usernameCookie.setPath("/");
                passwordCookie.setPath("/");
                rememberCookie.setPath("/");

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);
                response.addCookie(rememberCookie);
            }

            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Sai tên người dùng hoặc mật khẩu!");
            return "login";
        }
    }


    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        String username = (String) session.getAttribute("loggedInUser");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "welcome";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
