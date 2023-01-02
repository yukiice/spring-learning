package com.example.interceptor;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("before");
//        这里只有返回true  之后的两个才会进行  否则会中止
        return  true;
    }

    public void  postHandle(HttpServletRequest request, HttpServletResponse response, Object handled, @Nullable ModelAndView modelAndView) throws Exception{
        System.out.println("after");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        System.out.println("over after");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
