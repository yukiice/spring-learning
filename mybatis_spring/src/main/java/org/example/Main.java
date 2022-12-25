package org.example;

import org.example.config.MainConfiguration;
import org.example.mapper.TestMapper;
import org.example.service.TestService;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);
        TestService service = context.getBean(TestService.class);
        System.out.println(service.getStudent());
        service.addStudent();
    }
}