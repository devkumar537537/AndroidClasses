package com.example.typesofadapters.models;

public class ArrayModel {
    private int imageurl;
    private String name,number;

    public ArrayModel(int imageurl, String name, String number) {
        this.imageurl = imageurl;
        this.name = name;
        this.number = number;
    }

    public ArrayModel() {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
