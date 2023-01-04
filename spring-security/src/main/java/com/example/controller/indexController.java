package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return  new ModelAndView("index");
    }
}
