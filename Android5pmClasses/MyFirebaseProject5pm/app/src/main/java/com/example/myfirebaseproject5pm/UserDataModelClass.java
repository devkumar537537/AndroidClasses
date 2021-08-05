package com.example.myfirebaseproject5pm;

public class UserDataModelClass {
    private String email;
    private String name;
    private String number;
    private String password;
    private String userId;

    public UserDataModelClass(String email, String name, String number, String password, String userId) {
        this.email = email;
        this.name = name;
        this.number = number;
        this.password = password;
        this.userId = userId;
    }

    public UserDataModelClass() {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
