package com.example.typesofadapters;

public class ModelClass {
String name;
int imageurl;


    public ModelClass(String name, int imageurl) {
        this.name = name;
        this.imageurl = imageurl;
    }

    public ModelClass() {
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
