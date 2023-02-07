package com.book.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/page/auth")
@Controller
public class AuthPageController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
