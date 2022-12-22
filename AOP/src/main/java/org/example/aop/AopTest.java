package org.example.aop;

import lombok.extern.java.Log;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

@Log
public class AopTest {
    public void test(JoinPoint joinpoint){
        System.out.println(Arrays.toString(joinpoint.getArgs()));
    log.info("执行日志！");
    }

    public void before(){
        log.info("过时方法之前");
    }

    public Object around(ProceedingJoinPoint joinPoint) throws  Throwable{
        System.out.println("开始之前");
        Object value = joinPoint.proceed();
        System.out.println(value);
        System.out.println("执行结束后为");
        return  value;
    }
}
