package com.example.typesofadapters.model;

import com.example.typesofadapters.R;

public class MyItem {
    private String number;
    private int imageUrl;

    public MyItem(String number, int imageUrl) {
        this.number = number;
        this.imageUrl = imageUrl;
    }

    public MyItem() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
