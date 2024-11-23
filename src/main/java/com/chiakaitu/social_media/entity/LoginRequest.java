package com.chiakaitu.social_media.entity;

public class LoginRequest {
    private String phoneNum;
    private String password;

    // Getter 和 Setter
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
