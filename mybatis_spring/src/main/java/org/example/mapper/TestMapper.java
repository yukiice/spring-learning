package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.bean.Student;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("select * from testnow where id = 1")
    Student getStudent();

    @Insert("insert into testnow(name,age) values('diana','18')")
    void  insertStudent();
}
