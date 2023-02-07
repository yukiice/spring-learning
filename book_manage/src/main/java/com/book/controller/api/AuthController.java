package com.book.controller.api;

import com.book.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Resource
    AuthService service;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam("auth") String auth,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("name") String name,@RequestParam("sex") int sex){
        service.register(auth,username,password,name,sex);
        return  "redirect:/page/auth/login";
    }
}
