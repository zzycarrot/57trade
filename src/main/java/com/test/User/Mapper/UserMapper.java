package com.test.User.Mapper;

import com.test.User.POJO.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * from user where username = #{username} and password = #{password} ")
    public User getByUsernameAndPassword(User user) ;

    @Select("SELECT * from user")
    List<User> selectAll();
    @Insert("INSERT into user (username, password, role) " +
            "VALUES (#{username},#{password},#{role})")
    void insert(User user);

    @Delete("DELETE FROM user where username = #{username}")
    Integer delete(String username);

    @Select("SELECT * from user where username = #{username}")
    User select(String username);
}
