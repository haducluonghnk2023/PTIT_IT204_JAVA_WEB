package com.data.session07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
    @RequestMapping("/about")
    public String showAbout() {
        return "about";
    }
}