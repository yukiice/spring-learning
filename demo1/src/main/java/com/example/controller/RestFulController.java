package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RestFulController {
    @RequestMapping(value = "/restful/{str}")
    public ModelAndView index(@PathVariable("str") String text){
        System.out.println("接收的参数"+text);
        return  new ModelAndView("/restful");
    }
}
