package com.example.typesofadapter;

public class RecylerModel{
    private String name;
    private int imageurl;

    public RecylerModel(String name, int imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public RecylerModel() {
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
