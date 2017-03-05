package com.cloud_storage.util;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

/**
 * Created by dell on 3/5/2017.
 */
public class util {

    public  Boolean getProfile(String path, HttpServletResponse response)  {
        String real_path;
        if(path==null||path.length()==0){
            real_path=Properties.default_pic_path;
        }
        else {
            real_path=path;
        }
        try {
            java.io.File pic =new java.io.File(real_path);
            FileInputStream inputStream = new FileInputStream(pic);
            byte[] data = new byte[(int) pic.length()];
            int length = inputStream.read(data);
            inputStream.close();

            response.setContentType("img/jpeg");
            response.setCharacterEncoding("utf-8");
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
