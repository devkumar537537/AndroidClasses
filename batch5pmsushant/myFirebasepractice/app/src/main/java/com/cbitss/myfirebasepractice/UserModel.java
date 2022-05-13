package com.cbitss.myfirebasepractice;

public class UserModel {
    private String userEmail,userId,userNumber,userName,userPassword;

    public UserModel(String userEmail, String userId, String userNumber, String userName, String userPassword) {
        this.userEmail = userEmail;
        this.userId = userId;
        this.userNumber = userNumber;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public UserModel() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
