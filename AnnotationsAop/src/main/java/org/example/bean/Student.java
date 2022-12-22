package org.example.bean;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@ToString
@Component
public class Student {
    String name;
    int age;
    Card card;
//    public Student(){
//        System.out.println("我是构造方法");
//    }
//@Autowired
//public void setCard(Card card){
//    System.out.println("我是通过set方法注入的");
//    this.card = card;
//}
    public String say(String text){
        System.out.println("这是打印的"+text);
        return  text;
    }

//    @PostConstruct
//    public void init(){
//        System.out.println("我是初始化方法！1");
//    }
}
