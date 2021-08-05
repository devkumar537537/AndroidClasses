package com.example.firebaseconcepts11amsm;

public class MyModel {
    private String uderId,imageurl,userName,userEamil,userPassword,userNumber;

    public MyModel(String uderId, String imageurl, String userName, String userEamil, String userPassword, String userNumber) {
        this.uderId = uderId;
        this.imageurl = imageurl;
        this.userName = userName;
        this.userEamil = userEamil;
        this.userPassword = userPassword;
        this.userNumber = userNumber;
    }

    public MyModel() {
    }

    public String getUderId() {
        return uderId;
    }

    public void setUderId(String uderId) {
        this.uderId = uderId;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEamil() {
        return userEamil;
    }

    public void setUserEamil(String userEamil) {
        this.userEamil = userEamil;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
