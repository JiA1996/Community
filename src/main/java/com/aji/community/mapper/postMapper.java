package com.aji.community.mapper;

import com.aji.community.model.post;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/19
 * \* Time: 17:39
 * \* Description: This class is the mapper for a new post.
 */

@Mapper
public interface postMapper {

    @Insert("INSERT INTO post(userID, username, title, body, num_comment, num_view, num_like, gmt_create, gmt_lastmodified) VALUES(#{userID}, #{username}, #{title}, #{body}, #{num_comment}, #{num_view}, #{num_like}, #{gmt_create}, #{gmt_lastmodified})")
    void insertPost(post p);

    @Select("SELECT * FROM post")
    List<post> getAllPosts();

}
