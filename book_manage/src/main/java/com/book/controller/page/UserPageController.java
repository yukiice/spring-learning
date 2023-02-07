package com.book.controller.page;

import com.book.entity.User;
import com.book.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/page/user")
public class UserPageController {

    @Resource
    AuthService service;

    @RequestMapping(value = "/index")
    public String index(HttpSession session, Model model){
        User user =  service.findUser(session);
        model.addAttribute("user",user);
        return  "/user/index";
    }

    @RequestMapping(value = "/book")
    public String book(HttpSession session,Model model){
        User user =  service.findUser(session);
        model.addAttribute("user",user);
        return  "/user/book";
    }
}
