package com.example.restapiexamples;

public class CommentModel {
    private String postId,id,email,name,body;

    public CommentModel(String postId, String id, String email, String name, String body) {
        this.postId = postId;
        this.id = id;
        this.email = email;
        this.name = name;
        this.body = body;
    }

    public CommentModel() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
