package com.cloud_storage.entity;

/**
 * Created by dell on 3/24/2017.
 */
public class User_File {
    private int user_id;
    private int file_id;
    private String filename;
    private String size;
    private  int authority;//0:private,1:public
    private String date;

    public User_File(int user_id, int file_id, String filename,String size, int authority, String date) {
        this.user_id = user_id;
        this.file_id = file_id;
        this.filename = filename;
        this.size=size;
        this.authority = authority;
        this.date = date;
    }

    public User_File() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFile_id() {
        return file_id;
    }

    public void setFile_id(int file_id) {
        this.file_id = file_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
