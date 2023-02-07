package com.book.mapper;

import com.book.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from users where username = #{username}")
    User getPasswordByUsername(String username);

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("insert into users(username, password, auth)  values (#{username}, #{password}, #{auth})")
    int registerUser(User user);

    @Insert("insert into  student(uid, name, sex, grade) VALUES (#{uid}, #{name}, #{sex}, #{grade})")
    int addStudentInfo(@Param("name") String name,@Param("sex") int sex,@Param("grade") String grade,@Param("uid") int uid);
}
