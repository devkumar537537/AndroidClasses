package com.cbitss.animationexample;

public class RecyclerModel {
    private int imageurl;
    private String name;

    public RecyclerModel(int imageurl, String name) {
        this.imageurl = imageurl;
        this.name = name;
    }

    public RecyclerModel() {
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
