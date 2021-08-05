package com.example.typesofadapters.model;

public class BaseModel {
    private String email;
    private int imageurl;

    public BaseModel(String email, int imageurl) {
        this.email = email;
        this.imageurl = imageurl;
    }

    public BaseModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}
