package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterceptorController {
    @RequestMapping("/home")
    public ModelAndView index(){
        return  new ModelAndView("home");
    }

    @RequestMapping("/halo")
    public String Home(){
        return "index";
    }
}
