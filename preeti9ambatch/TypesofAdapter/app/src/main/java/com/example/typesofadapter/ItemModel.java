package com.example.typesofadapter;

public class ItemModel {
    private int imageurl;
    private String number;

    public ItemModel(int imageurl, String number) {
        this.imageurl = imageurl;
        this.number = number;
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ItemModel() {
    }
}
