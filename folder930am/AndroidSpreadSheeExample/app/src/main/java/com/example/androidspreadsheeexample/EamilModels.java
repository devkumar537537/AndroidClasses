package com.example.androidspreadsheeexample;

public class EamilModels {
private String date,ID,name,number;

    public EamilModels(String date, String ID, String name, String number) {
        this.date = date;
        this.ID = ID;
        this.name = name;
        this.number = number;
    }

    public EamilModels() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
}
