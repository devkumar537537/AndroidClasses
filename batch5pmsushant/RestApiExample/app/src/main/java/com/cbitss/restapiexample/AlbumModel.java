package com.cbitss.restapiexample;

public class AlbumModel {
    private String userId,id,title;

    public AlbumModel(String userId, String id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public AlbumModel() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
