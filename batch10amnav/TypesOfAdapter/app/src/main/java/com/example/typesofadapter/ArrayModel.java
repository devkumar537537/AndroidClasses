package com.example.typesofadapter;

public class ArrayModel {
    private String name;
    private int imageurl;

    public ArrayModel(String name, int imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public ArrayModel() {
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
