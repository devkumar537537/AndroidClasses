package com.example.spreasheetexample;

import java.util.ArrayList;

public class RootClass {
    public ArrayList<Item> items;

    public RootClass(ArrayList<Item> items) {
        this.items = items;
    }

    public RootClass() {
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
