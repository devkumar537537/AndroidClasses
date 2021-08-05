package com.dailydose.lifehackes;

public class HomeItems {

    private String title;
    private int thumbnail;

    public HomeItems(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public HomeItems() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumnbail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
