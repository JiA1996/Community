package com.aji.community.mapper;

import com.aji.community.model.user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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

    @Insert("INSERT INTO USER(id, userID, username, token, gender, gmt_joindate)" +
            "VALUES(#{userID}, #{username}, #{token}, #{gender}, #{gmt_joindate})")
    void insertUser(user user);

}
