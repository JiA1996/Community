package com.aji.community.dataTransferObject;

import com.aji.community.model.user;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/15
 * \* Time: 21:03
 * \* Description: DTO for user replies in post page
 * \
 */

@Data
public class replyDTO {
    private Integer replyID;
    private Integer postID;
    private Integer reply_type;//first level or second level reply
    private String userID;
    private Long gmtCreate;
    private Long num_upvote;
    private Long num_downvote;
    private Integer num_reply;
    private String content;
    private user userObject;
}
