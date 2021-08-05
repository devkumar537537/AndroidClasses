package com.example.typesofadapters.models;

public class ItemModel {
    private int imageurl;
    private String name;

    public ItemModel(int imageurl, String name) {
        this.imageurl = imageurl;
        this.name = name;
    }

    public ItemModel() {
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
