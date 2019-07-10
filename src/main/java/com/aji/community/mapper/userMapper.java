package com.aji.community.mapper;

import com.aji.community.model.user;
import org.apache.ibatis.annotations.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/19
 * \* Time: 17:39
 * \* Description:mapper for user object
 * \
 */

@Mapper
public interface userMapper {

    @Insert("INSERT INTO USER(userID, username, token, gender, gmt_joindate, avatarUrl) VALUES(#{userID}, #{username}, #{token}, #{gender}, #{gmt_joindate}, #{avatarUrl})")
    void insertUser(user u);

    @Select("SELECT id, userID, username, token, gender, gmt_joindate FROM USER WHERE token = #{token}")
    user getUserByToken(@Param("token") String token);

    @Select("SELECT * FROM USER WHERE userID = #{userID}")
    user getUserByID(@Param("userID") String userID);

    @Update("UPDATE USER SET username = #{username}, token = #{token}, avatarUrl = #{avatarUrl} WHERE userID = #{userID}")
    void updateByID(user oneUser);
}
