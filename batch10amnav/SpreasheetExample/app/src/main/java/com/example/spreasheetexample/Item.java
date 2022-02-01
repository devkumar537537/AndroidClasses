package com.example.spreasheetexample;

import java.io.Serializable;

public class Item implements Serializable {
    private String userdate;
    private String userId;
    private String username;
    private String userpassword;

    public Item(String userdate, String userId, String username, String userpassword) {
        this.userdate = userdate;
        this.userId = userId;
        this.username = username;
        this.userpassword = userpassword;
    }

    public Item() {
    }

    public String getUserdate() {
        return userdate;
    }

    public void setUserdate(String userdate) {
        this.userdate = userdate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }
}
