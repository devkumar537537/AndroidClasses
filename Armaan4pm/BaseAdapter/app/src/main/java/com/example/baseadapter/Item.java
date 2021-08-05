package com.example.baseadapter;

public class Item {
    private String number;
    private int imageurl;

    public Item(String number, int imageurl) {
        this.number = number;
        this.imageurl = imageurl;
    }

    public Item() {
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
