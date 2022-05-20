package com.activemq.activemqproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class IndexController {
    @GetMapping
    public ModelAndView layout() {
        ModelAndView view = new ModelAndView("index");
        return view;
    }
}
