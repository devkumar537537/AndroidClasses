package com.cbitss.anotherprojectrestapi;

import java.io.Serializable;

public class Item  implements Serializable {
    private String userId,userDate,userName,userNumber;

    public Item(String userId, String userDate, String userName, String userNumber) {
        this.userId = userId;
        this.userDate = userDate;
        this.userName = userName;
        this.userNumber = userNumber;
    }

    public Item() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
