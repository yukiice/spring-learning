package com.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class JsonController {
//    @RequestMapping("/json")
//    public ModelAndView index(){
//        JSONObject object = new JSONObject();
//        JSONObject inner = new JSONObject();
//        inner.put("halo","halo");
//        object.put("inner",inner);
//        object.put("name","yukiice");
//        object.put("age",19);
//        System.out.println(object.toJSONString());
//        JSONArray array = new JSONArray();
//        array.add(object);
//        System.out.println(array.toJSONString());
//        return  new ModelAndView("json");
//    }

//    @RequestMapping(value = "/json",produces = "application/json")
//    @ResponseBody
//    public User json(){
//        User user = new User();
//        user.setUsername("yukiice");
//        user.setPassword("123456");
//        return  user;
//    }

    @RequestMapping("/json")
    public ModelAndView index(){
        return new ModelAndView("json");
    }

    @RequestMapping("/submit")
    @ResponseBody
    public String submit(@RequestBody User user){
        System.out.println(user);
        return  "ok";
    }
}
