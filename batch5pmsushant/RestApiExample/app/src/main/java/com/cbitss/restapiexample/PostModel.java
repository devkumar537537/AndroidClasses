package com.cbitss.restapiexample;

public class PostModel {

    private String title,body,userID,id;

    public PostModel(String title, String body, String userID, String id) {
        this.title = title;
        this.body = body;
        this.userID = userID;
        this.id = id;
    }

    public PostModel() {
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
