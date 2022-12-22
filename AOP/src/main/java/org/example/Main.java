package org.example;

import org.example.beans.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
        Student student = context.getBean(Student.class);
        student.say("halo");
//        student.sayBefore();
    }
}