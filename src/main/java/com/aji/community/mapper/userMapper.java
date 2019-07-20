package com.aji.community.mapper;

import com.aji.community.model.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    @Select("SELECT * FROM USER WHERE token = #{token}")
    user getUserByToken(@Param("token") String token);

    @Select("SELECT * FROM USER WHERE userID = #{userID}")
    user getUserByID(@Param("userID") String userID);

    @Update("UPDATE USER SET username = #{username}, token = #{token}, avatarUrl = #{avatarUrl} WHERE userID = #{userID}")
    void updateByID(user oneUser);

    @Select({
            "<script>",
            "select",
            "*",
            "from user",
            "where userID in",
            "<foreach collection='userIDs' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    List<user> selectUserListByUserIDList(@Param("userIDs") List<String> userIDs);
}
