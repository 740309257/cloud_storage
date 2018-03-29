package com.cloudstorage.util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/**
 * Created by dell on 3/5/2017.
 */

@Configuration
public class Properties{

    @Value("${file_path}")
    public static String file_path;

    @Value("${user_pic_path}")
    public static String user_pic_path;

    @Value("${default_pic_path}")
    public static String default_pic_path;

    @Value("${file_id}")
    public static int file_id;
}
