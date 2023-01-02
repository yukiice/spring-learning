package com.example.controller;

import com.example.entity.TestBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class  MainController {

    @Resource
    TestBean bean;

    @RequestMapping( value = "/index/?",method = RequestMethod.GET)
    public ModelAndView index(){
        System.out.println(bean);
        return  new ModelAndView("index");
    }
}
