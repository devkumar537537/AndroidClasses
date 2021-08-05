package com.example.androidspreadsheetexample;

public class EamilModels {
private String userdate,userNumber,userId,username;

    public EamilModels(String userdate, String userNumber, String userId, String username) {
        this.userdate = userdate;
        this.userNumber = userNumber;
        this.userId = userId;
        this.username = username;
    }

    public EamilModels() {
    }

    public String getUserdate() {
        return userdate;
    }

    public void setUserdate(String userdate) {
        this.userdate = userdate;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
