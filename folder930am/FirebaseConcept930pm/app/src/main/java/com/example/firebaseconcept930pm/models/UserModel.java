package com.example.firebaseconcept930pm.models;

public class UserModel {
    private String email;
    private String image;
    private String name;
    private String number;
    private String password;
    private String userid;

    public UserModel(String email, String image, String name, String number, String password, String userid) {
        this.email = email;
        this.image = image;
        this.name = name;
        this.number = number;
        this.password = password;
        this.userid = userid;
    }

    public UserModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
