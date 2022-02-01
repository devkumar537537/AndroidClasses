package com.example.typesofadapters.models;

public class RecyclerModle {
    private String email;
    private int imageurl;

    public RecyclerModle(String email, int imageurl) {
        this.email = email;
        this.imageurl = imageurl;
    }

    public RecyclerModle() {
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
