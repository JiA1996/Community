package com.aji.community.model;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Aji
 * \* Date: 2019/6/19
 * \* Time: 17:43
 * \* Description:
 * \
 */
public class user {
    private Integer id;
    private String userID;
    private String username;
    private String token;
    private String gender;
    private long gmt_joindate;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getGmt_joindate() {
        return gmt_joindate;
    }

    public void setGmt_joindate(long gmt_joindate) {
        this.gmt_joindate = gmt_joindate;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", userID='" + userID + '\'' +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                ", gmt_joindate=" + gmt_joindate +
                '}';
    }
}
