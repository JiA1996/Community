package com.aji.community.model;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/19
 * \* Time: 17:43
 * \* Description: model for user
 * \
 */

@Data
public class user {
    private Integer id;
    private String userID;
    private String username;
    private String token;
    private String gender;
    private long gmt_joindate;
    private String avatarUrl;
}
