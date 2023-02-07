package com.book.service;

import com.book.entity.User;

import javax.servlet.http.HttpSession;

public interface AuthService {
    void register(String auth,String username, String password,  String name,int sex);

    User findUser(HttpSession session);
}
