package com.aji.community.mapper;
import com.aji.community.model.reply;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface replyMapper {

    @Insert("INSERT INTO reply(replyID, postID, userID, reply_type, content, num_upvote, num_downvote, gmt_create) VALUES(#{replyID}, #{postID}, #{userID}, #{reply_type}, #{content}, #{num_upvote}, #{num_downvote}, #{gmt_create})")
    void insertReply(reply r);

    @Select("SELECT * FROM reply WHERE postID = #{postID}")
    List<reply> selectReplyListByPostId(@Param("postID") Integer postID);
}
