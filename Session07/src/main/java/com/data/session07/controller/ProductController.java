package com.data.session07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("product")
public class ProductController {

//    @RequestMapping(value = "product",method = RequestMethod.GET)
    @GetMapping("findAll")
    public ModelAndView product(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("data","KS23B");
        return modelAndView;
    }
}
