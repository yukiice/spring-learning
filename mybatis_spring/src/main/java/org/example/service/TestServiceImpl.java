package org.example.service;

import org.example.bean.Student;
import org.example.mapper.TestMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class TestServiceImpl implements  TestService{

//    @Resource
//    SqlSessionTemplate template;
//
//    @Override
//    public Student getStudent() {
//        TestMapper mapper = template.getMapper(TestMapper.class);
//        return mapper.getStudent();
//    }

    @Resource
    TestMapper mapper;

    @Override
    public Student getStudent(){
        return  mapper.getStudent();
    }

    @Transactional
    @Override
    public void  addStudent(){
        mapper.insertStudent();
        mapper.insertStudent();
    }
}
