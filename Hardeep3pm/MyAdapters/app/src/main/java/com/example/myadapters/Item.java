package com.example.myadapters;

public class Item {
    String name;
    int imageurl;

    public Item(String name, int imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public Item() {
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
