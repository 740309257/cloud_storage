package com.cloud_storage.util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * Created by dell on 3/5/2017.
 */

@Component
public class Properties{

    public static String file_path;

    public static String user_pic_path;

    public static String default_pic_path;

    public static int file_id;

    public String getFile_path() {
        return file_path;
    }

    @Value("#{configProperties['file_path']}")
    public void setFile_path(String file_path) {
        Properties.file_path = file_path;
    }

    public String getUser_pic_path() {
        return user_pic_path;
    }

    @Value("#{configProperties['user_pic_path']}")
    public void setUser_pic_path(String user_pic_path) {
        Properties.user_pic_path = user_pic_path;
    }

    public String getDefault_pic_path() {
        return default_pic_path;
    }

    @Value("#{configProperties['default_pic_path']}")
    public void setDefault_pic_path(String default_pic_path) {
        Properties.default_pic_path = default_pic_path;
    }

    public int getFile_id() {
        return file_id;
    }

    @Value("#{configProperties['file_id']}")
    public void setFile_id(int file_id) {
        Properties.file_id = file_id;
        //System.out.println("File_id="+file_id);
    }
}

