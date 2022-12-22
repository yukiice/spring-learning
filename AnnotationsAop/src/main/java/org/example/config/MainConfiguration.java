package org.example.config;

import org.example.bean.Card;
import org.example.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@ComponentScans({
        @ComponentScan("org.example.bean"),
        @ComponentScan("org.example.aop")
})
@Configuration
@EnableAspectJAutoProxy
public class MainConfiguration {
//    @Bean
//    @Scope("prototype")
//    public Card card(){
//        return  new Card();
//    }
//
//    @Bean
//    public Student student(){
//        Student student = new Student();
//        student.setName("小明");
//        return  student;
//    }
//    @Bean
//    public Student student(@Autowired Card card){
//        Student student = new Student();
//        student.setCard(card);
//        return  student;
//    }
}
