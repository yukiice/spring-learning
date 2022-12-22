package org.example.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class AopActive  implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("方法名称为"+method.getName());
        System.out.println("方法参数为"+ Arrays.toString(args));
        System.out.println("方法执行的对象是"+target);
    }
}
