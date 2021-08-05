package com.example.typesadapters.models;

public class ItemModel {
    private int imageUrl;
    private String name;
    private String number;

    public ItemModel(int imageUrl, String name, String number) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.number = number;
    }

    public ItemModel() {
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
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
