package org.example.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aopTest {
    @Before("execution(* org.example.bean.Student.say(..))")
    public void before(){
        System.out.println("执行之前");
    }

    @AfterReturning(value = "execution(* org.example.bean.Student.say(..))",returning = "val")
    public void after (Object val){
        System.out.println("这是结果"+val);
    }
}
