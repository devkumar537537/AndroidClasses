package com.example.typesadapters.models;

public class RecyclerModel {
    private int imageurl;
    private String email;
    private int pincode;

    public RecyclerModel(int imageurl, String email, int pincode) {
        this.imageurl = imageurl;
        this.email = email;
        this.pincode = pincode;
    }

    public RecyclerModel() {
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
