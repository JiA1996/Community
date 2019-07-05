package com.aji.community.mapper;

import com.aji.community.model.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/19
 * \* Time: 17:39
 * \* Description:
 * \
 */

@Mapper
public interface userMapper {

    @Insert("INSERT INTO USER(userID, username, token, gender, gmt_joindate) VALUES(#{userID}, #{username}, #{token}, #{gender}, #{gmt_joindate})")
    void insertUser(user u);

    @Select("SELECT id, userID, username, token, gender, gmt_joindate FROM USER WHERE token = #{token}")
    user getUserByToken(@Param("token") String token);
}