package org.example.service;

import org.apache.ibatis.annotations.Select;
import org.example.bean.Student;

public interface TestService {
    Student getStudent();

    void  addStudent();
}
