package com.example.controller;

import com.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NewController {
    @RequestMapping( value = "/new",method = RequestMethod.GET,params = {"username","password","password!=2"})
    public ModelAndView index(@RequestParam(value = "username",required = false,defaultValue = "花花") String username, HttpServletRequest request, User user){
        System.out.println(user);
        System.out.println(request.getRequestURI());
        System.out.println(username);
        return  new ModelAndView("new");
    }
}
