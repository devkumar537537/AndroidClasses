package com.example.googlespreassheetsagain;

public class EamilModels {
private String userdate,userId,useremail,userNumber;

    public EamilModels(String userdate, String userId, String useremail, String userNumber) {
        this.userdate = userdate;
        this.userId = userId;
        this.useremail = useremail;
        this.userNumber = userNumber;
    }

    public EamilModels() {
    }

    public String getUserdate() {
        return userdate;
    }

    public void setUserdate(String userdate) {
        this.userdate = userdate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }
}
