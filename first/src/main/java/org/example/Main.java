package org.example;

import org.example.bean.Card;
import org.example.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
        Student student = context.getBean(Student.class);
//        Card card = context.getBean(Card.class);
//        context.close();
        System.out.println(student);
    }
}