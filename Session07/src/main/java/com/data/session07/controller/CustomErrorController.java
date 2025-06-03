package com.data.session07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController{
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        return "error";
    }
}
