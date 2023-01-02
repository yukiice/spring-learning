package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CookieController {
//    @RequestMapping("/cookie")
//    public ModelAndView index(HttpServletResponse response, @CookieValue(value = "test",required = false) String test){
//        System.out.println("cookie的值为"+test);
//        response.addCookie(new Cookie("test","halo"));
//        return  new ModelAndView("cookie");
//    }
    
    @RequestMapping("/cookie")
    public ModelAndView index(@SessionAttribute(value = "test",required = false)String test, HttpSession session){
        System.out.println("session为"+test);
        session.setAttribute("test","halo");
        return  new ModelAndView("cookie");
    }
}
