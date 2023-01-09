package com.example.service;

import com.example.mapper.UserMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthService implements UserDetailsService {
    @Resource
    UserMapper mapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        com.example.entity.User user = mapper.getPasswordByUsername(s);
        if (user == null){
            throw  new UsernameNotFoundException("用户名或者密码错误！");
        }else{
            return User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getAuth())
                    .build();
        }
    }
}
