package com.data.session14.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;

@Controller
public class HomeController {
    private static final String COOKIE_NAME = "lang";

    @GetMapping("/home")
    public String home(HttpServletRequest request,
                       HttpServletResponse response,
                       @RequestParam(value = "lang", required = false) String lang,
                       Model model) {

        if (lang != null) {
            Cookie cookie = new Cookie(COOKIE_NAME, lang);
            cookie.setPath("/");
            cookie.setMaxAge(7 * 24 * 60 * 60);
            response.addCookie(cookie);
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (COOKIE_NAME.equals(c.getName())) {
                        lang = c.getValue();
                        break;
                    }
                }
            }
        }

        if (lang == null || !(lang.equals("en") || lang.equals("vi"))) {
            lang = "en";
        }

        Locale locale = new Locale(lang);

        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        model.addAttribute("title", bundle.getString("title"));
        model.addAttribute("greeting", bundle.getString("greeting"));
        model.addAttribute("instruction", bundle.getString("instruction"));

        model.addAttribute("currentLang", lang);

        return "home";
    }
}
