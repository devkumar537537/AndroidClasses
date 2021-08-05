package com.example.restapiexampl850;

public class Comments {
    private String postId,id,email,body,name;

    public Comments(String postId, String id, String email, String body, String name) {
        this.postId = postId;
        this.id = id;
        this.email = email;
        this.body = body;
        this.name = name;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Comments() {
    }
}
