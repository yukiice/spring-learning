package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {

    @RequestMapping("/redirect")
    public ModelAndView index(){
        return  new ModelAndView("redirect:index/2");
    }

}
