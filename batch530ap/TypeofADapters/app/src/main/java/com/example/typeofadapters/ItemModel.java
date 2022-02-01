package com.example.typeofadapters;

public class ItemModel {
    private String number;
    private int imageurl;

    public ItemModel(String number, int imageurl) {
        this.number = number;
        this.imageurl = imageurl;
    }

    public ItemModel() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}
