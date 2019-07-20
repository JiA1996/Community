package com.aji.community.model;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/18
 * \* Time: 16:37
 * \* Description:
 * \
 */
@Data
public class reply {
    private Integer replyID;
    private Integer postID;
    private Integer reply_type;//first level or second level reply
    private String userID;
    private Long gmt_create;
    private Integer num_upvote;
    private Integer num_downvote;
    private String content;
}
