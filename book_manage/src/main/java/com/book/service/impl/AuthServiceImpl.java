package com.book.service.impl;

import com.book.entity.User;
import com.book.mapper.UserMapper;
import com.book.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    UserMapper mapper;
    @Override
    public void register(String auth,String username, String password,  String name,int sex) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            User user = new User(0,username,encoder.encode(password),auth);
            if (mapper.registerUser(user)<=0) throw new RuntimeException("用户基本信息添加失败");
            if (mapper.addStudentInfo(name,sex,"0",user.getId()) <=0) throw new RuntimeException("学生信息添加失败");
    }

    @Override
    public User findUser(HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user == null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = mapper.getPasswordByUsername(authentication.getName());
            session.setAttribute("user",user);
        }
        return user;
    }
}
