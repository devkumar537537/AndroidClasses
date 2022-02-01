package com.example.typesofadapterssecond;

public class MyModel {
    private String name;
    private int imageurl;

    public MyModel(String name, int imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public MyModel() {
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
