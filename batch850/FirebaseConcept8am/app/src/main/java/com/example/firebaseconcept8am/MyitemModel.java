package com.example.firebaseconcept8am;

public class MyitemModel {
    private String email, name, number, password, userid, imageurl;

    public MyitemModel(String email, String name, String number, String password, String userid, String imageurl) {
        this.email = email;
        this.name = name;
        this.number = number;
        this.password = password;
        this.userid = userid;
        this.imageurl = imageurl;
    }

    public MyitemModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}

