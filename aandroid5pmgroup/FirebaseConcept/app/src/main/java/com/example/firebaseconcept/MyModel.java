package com.example.firebaseconcept;

public class MyModel {
    private String email,name,image,number,password,userid;

    public MyModel(String email, String name, String image, String number, String password, String userid) {
        this.email = email;
        this.name = name;
        this.image = image;
        this.number = number;
        this.password = password;
        this.userid = userid;
    }

    public MyModel() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
