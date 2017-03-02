package com.cloud_storage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class File {
    private int file_id;
    private String filename;
    private int user_id;
    private String file_path;
    private int authority;//0:private;1:public

    public File() {
        //public
        authority=1;
    }

    public File(String filename, int user_id, String file_path, int authority) {
        this.filename = filename;
        this.user_id = user_id;
        this.file_path = file_path;
        this.authority = authority;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }
}
