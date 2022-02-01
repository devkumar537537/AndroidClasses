package com.batch12pm.basicadvancecomponent;

import java.io.Serializable;

public class SecondModel implements Serializable {
    private String email,number;

    public SecondModel(String email, String number) {
        this.email = email;
        this.number = number;
    }

    public SecondModel() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
