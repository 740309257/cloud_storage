package com.cloud_storage.entity;

import java.util.Date;

/**
 * Created by dell on 1/23/2017.
 */
public class Message {
    private int publisher_id;
    private String text;
    private String publisher_name;
    private Date time;
    private int message_id;
    private int comment_num;

    public Message(int publisher_id,String publisher_name, String text, Date time,int comment_num) {
        this.publisher_id = publisher_id;
        this.publisher_name=publisher_name;
        this.text = text;
        this.time = time;
        this.comment_num=comment_num;
    }

    public Message() {
        time=new Date();
        comment_num=0;

    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }
}
