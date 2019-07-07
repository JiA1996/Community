package com.aji.community.dataTransferObject;

import com.aji.community.model.user;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/7/5
 * \* Time: 17:53
 * \* Description: post DTO
 *
 */
@Data
public class postDTO {
    private Integer id;
    private String userID;
    private String username;
    private String title;
    private String body;
    private Integer num_comment;
    private Integer num_view;
    private Integer num_like;
    private long gmt_create;
    private long gmt_lastModified;
    private user userObject;

    public void setUserObject(user userObject) {
        this.userObject = userObject;
    }
}
