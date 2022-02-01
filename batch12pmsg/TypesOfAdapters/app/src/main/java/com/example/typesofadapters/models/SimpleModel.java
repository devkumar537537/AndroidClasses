package com.example.typesofadapters.models;
public class SimpleModel {
    private String name;
    private int imageurl;


    public SimpleModel(int imageurl, String name) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public SimpleModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}
