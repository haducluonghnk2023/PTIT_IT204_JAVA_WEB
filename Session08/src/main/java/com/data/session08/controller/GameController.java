package com.data.session08.controller;

import com.data.session08.model.ex08.Seeds;
import com.data.session08.model.ex08.User08;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("/game")
public class GameController {
    private List<User08> userList = new ArrayList<>();
    private List<Seeds> seedList = new ArrayList<>();

    public GameController() {
        seedList.add(new Seeds() {{
            setId(1); setSeedsName("Hạt giống cà chua"); setPrice(5000); setImageUrl("https://phudienseed.com.vn/wp-content/uploads/2022/10/IMG_4385.jpg");
        }});
        seedList.add(new Seeds() {{
            setId(2); setSeedsName("Hạt giống khoai tây"); setPrice(7000); setImageUrl("https://down-vn.img.susercontent.com/file/fd8d50084824639a7fe8fda43c116747");
        }});
        seedList.add(new Seeds() {{
            setId(3); setSeedsName("Hạt giống dưa hấu"); setPrice(10000); setImageUrl("https://phudienseed.com.vn/wp-content/uploads/2022/09/z4998487298803_9a1ae080b00926389b68b3430b696c62.jpg");
        }});
    }

    // Hiển thị trang đăng ký
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User08());
        return "register";
    }

    // Xử lý đăng ký
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User08 user, HttpSession session) {
        user.setId(userList.size() + 1);
        userList.add(user);
        session.setAttribute("loggedInUser", user);
        return "redirect:login";
    }

    // Hiển thị trang đăng nhập
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User08());
        return "login";
    }

    // Xử lý đăng nhập
    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User08 formUser, HttpSession session, Model model) {
        for (User08 u : userList) {
            if (u.getUsername().equals(formUser.getUsername()) &&
                    u.getPassword().equals(formUser.getPassword())) {
                session.setAttribute("loggedInUser", u);
                return "redirect:home";
            }
        }
        model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu.");
        return "home";
    }

    @GetMapping("/home")
    public String showHome() {
        return "home";
    }

    @GetMapping("/shop")
    public String showShop(Model model) {

        model.addAttribute("seeds", seedList);
        return "shop";
    }
}
