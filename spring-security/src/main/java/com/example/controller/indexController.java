package com.example.controller;

import com.example.entity.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;

@Controller
public class indexController {
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        SecurityContext servletContext = SecurityContextHolder.getContext();
        Authentication authentication = servletContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        System.out.println(user.getAuth());
        return  new ModelAndView("index");
    }

    @PreAuthorize("hasAnyRole('user')")
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
