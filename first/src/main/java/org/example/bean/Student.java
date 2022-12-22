package org.example.bean;

import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
public class Student {
//    public void init(){
//        System.out.println("初始化");
//    }
    public Student(){
        System.out.println("我是student");
    }
//    public void destroy(){
//        System.out.println("销毁了");
//    }
    String name;
    int age;
    Card card;
    List<String> list;
    Map<String,Integer> map;

    public Student(String name, int age,Card card) {
        this.name = name;
        this.age = age;
        this.card = card;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCard(Card card){
        this.card = card;
    }
    public void setList(List<String> list){
        this.list = list;
    }
    public void setMap(Map<String,Integer> map){
        this.map = map;
    }
}
