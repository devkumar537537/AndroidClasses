package com.example.retrofitle2pm;

public class DataModel {
    public String id;
    public String title;
    public String body;
    public String created;

    public DataModel(String id, String title, String body, String created) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created = created;
    }

    public DataModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
