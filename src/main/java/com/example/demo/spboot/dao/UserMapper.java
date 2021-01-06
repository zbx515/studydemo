package com.example.demo.spboot.dao;

import com.example.demo.spboot.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
@Mapper
@Component
public interface UserMapper {

    @Insert("insert into user (aac002,aac003) values (#{user.aac002},#{user.aac003})")
    void insert(@Param("user") User user);

    @Select("select  * from user where aac002= #{aac002}")
    List<User> query(@Param("aac002") String aac002);
}
