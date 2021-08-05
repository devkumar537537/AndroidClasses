package com.example.recyclerproject;

public class ItemModel {
    String name;
    int imageurl;

    public ItemModel(String name, int imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public ItemModel() {
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
