package org.example.bean;

import lombok.Data;
import lombok.experimental.Accessors;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component
public class Student {
    int id;
    String name;
    int age;

    @Resource
    SqlSessionTemplate template;
    public void  test(){

    }
}
