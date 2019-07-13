package com.aji.community.mapper;

import com.aji.community.model.post;
import java.util.List;

import org.apache.ibatis.annotations.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/19
 * \* Time: 17:39
 * \* Description: This class is the mapper for a new post.
 */

@Mapper
public interface postMapper {

    @Insert("INSERT INTO post(userID, username, title, body, gmt_create, gmt_lastmodified) VALUES(#{userID}, #{username}, #{title}, #{body}, #{gmt_create}, #{gmt_lastmodified})")
    void insertPost(post p);

    @Select("SELECT * FROM post")
    List<post> getAllPosts();

    @Select("SELECT * FROM post WHERE id = #{id}")
    post getPostByID(@Param("id") Integer id);

    @Update("UPDATE POST SET NUM_VIEW = #{num_view} WHERE id = #{id}")
    void updateViews(post p);

    @Update("UPDATE POST SET title = #{title}, body = #{body} WHERE id = #{id}")
    void updatePost(post p);
}
