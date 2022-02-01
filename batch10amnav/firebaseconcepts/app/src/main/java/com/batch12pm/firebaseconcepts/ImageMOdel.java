package com.batch12pm.firebaseconcepts;

public class ImageMOdel {
    private String imageUrl;
    private String userId;

    public ImageMOdel(String imageUrl, String userId) {
        this.imageUrl = imageUrl;
        this.userId = userId;
    }

    public ImageMOdel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
