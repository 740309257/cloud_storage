package com.cloud_storage.entity;

/**
 * Created by dell on 1/23/2017.
 */
public class File {
    private int file_id;
    private String filename;
    private String file_path;
    private int nums;
    private String size;
    private String type;
    private int provider_id;

    public File(int file_id, String filename, String file_path, int nums, String size, String type, int provider_id) {
        this.file_id = file_id;
        this.filename = filename;
        this.file_path = file_path;
        this.nums = nums;
        this.size = size;
        this.type = type;
        this.provider_id = provider_id;
    }

    public File() {
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

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }
}
