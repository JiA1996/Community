package com.aji.community.model;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/26
 * \* Time: 20:23
 * \* Description: model for a post
 * \
 */

@Data
public class post {
    private Integer id;
    private String userID;
    private String username;
    private String title;
    private String body;
    private Integer num_comment;
    private Integer num_view;
    private Integer num_like;
    private long gmt_create;
    private long gmt_lastmodified;
}
