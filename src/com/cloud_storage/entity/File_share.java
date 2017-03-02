package com.cloud_storage.entity;

import java.util.Date;

/**
 * Created by dell on 1/23/2017.
 */
public class File_share {
    private int user_id;
    private int target_id;
    private int file_id;
    private int is_valid;//0:not valid;1:valid
    private String date;

    public File_share(int user_id, int target_id, int file_id, int is_valid,String date) {
        this.user_id = user_id;
        this.target_id = target_id;
        this.file_id = file_id;
        this.is_valid = is_valid;
        this.date=date;
    }

    public File_share() {
        is_valid=1;
        date=new Date().toString();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public int getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(int is_valid) {
        this.is_valid = is_valid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
