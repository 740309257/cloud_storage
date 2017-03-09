package com.cloud_storage.util;

import com.cloud_storage.entity.File;
import com.google.gson.Gson;
import com.google.gson.JsonNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 3/5/2017.
 */
public class util {

    public  static Boolean getProfile(String path, HttpServletResponse response)  {
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

           /**
 08.     * @MethodName : toJson
 09.     * @Description : 将对象转为JSON串，此方法能够满足大部分需求
 10.     * @param src
 11.     *            :将要被转化的对象
 12.     * @return :转化后的JSON串
 13.     */
            public static String toJson(Object src) {
                Gson gson=new Gson();
               if (src == null) {
                       return gson.toJson(JsonNull.INSTANCE);
                    }
               return gson.toJson(src);
            }

            public static String files_to_json(List<File> files){
                List<HashMap> hashMapList=new ArrayList<>();
                HashMap<String,String> hashMap=new HashMap<>();
                hashMapList.add(hashMap);
                for(int i=0;i<files.size();i++){
                    hashMap=new HashMap<>();
                    hashMap.put("file_id",files.get(i).getFile_id()+"");
                    hashMap.put("filename",files.get(i).getFilename());
                    hashMap.put("authority",files.get(i).getAuthority()+"");
                    hashMapList.add(hashMap);
                }
                return toJson(hashMapList);
            }

}
