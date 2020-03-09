package com.zjut.travels.vo;

public class User {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String userName;
    private String password;
    private String gender;
    private String email;
    public User(int userId,String userName,String password,String gender,String email){
        this.userId = userId;
        this.password = password;
        this.gender = gender;
        this.userName = userName;
        this.email = email;
    }
}
