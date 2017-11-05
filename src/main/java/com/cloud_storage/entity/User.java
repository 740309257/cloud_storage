package com.cloud_storage.entity;

import java.util.ArrayList;

/**
 * Created by dell on 1/23/2017.
 */
public class User {
    private int user_id;
    private String username;
    private String password;
    private String introduction;
    private String pic_path;

    public User(String username, String password, String introduction, String pic_path) {
        this.username = username;
        this.password = password;
        this.introduction = introduction;
        this.pic_path = pic_path;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPic_path() {
        return pic_path;
    }

    public void setPic_path(String pic_path) {
        this.pic_path = pic_path;
    }
}
