package com.cloud_storage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class Comment {
    private int comment_id;
    private int message_id;
    private int user_id;
    private String text;
    private String username;

    public Comment(int message_id, int user_id, String text,String username) {
        this.username=username;
        this.message_id = message_id;
        this.user_id = user_id;
        this.text = text;
    }

    public Comment() {
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
