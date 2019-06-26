package com.aji.community.model;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/26
 * \* Time: 20:23
 * \* Description:
 * \
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getNum_comment() {
        return num_comment;
    }

    public void setNum_comment(Integer num_comment) {
        this.num_comment = num_comment;
    }

    public Integer getNum_view() {
        return num_view;
    }

    public void setNum_view(Integer num_view) {
        this.num_view = num_view;
    }

    public Integer getNum_like() {
        return num_like;
    }

    public void setNum_like(Integer num_like) {
        this.num_like = num_like;
    }

    public long getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(long gmt_create) {
        this.gmt_create = gmt_create;
    }

    public long getGmt_lastmodified() {
        return gmt_lastmodified;
    }

    public void setGmt_lastmodified(long gmt_lastmodified) {
        this.gmt_lastmodified = gmt_lastmodified;
    }
}
