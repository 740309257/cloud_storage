package com.cloud_storage.util;

import com.cloud_storage.entity.File;
import com.cloud_storage.entity.User_File;
import com.google.gson.Gson;
import com.google.gson.JsonNull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 3/5/2017.
 */
public class util {

    public static Boolean validate_code(HttpSession session,String test_code){
        String real_code;
        if(session.getAttribute("VERIFY_CODE")==null||test_code==null){
            return false;
        }

        real_code=(String) session.getAttribute("VERIFY_CODE");

        if(real_code.equals(test_code)||real_code.equals(test_code.toUpperCase())){
            return true;
        }
        else {
            return false;
        }
    }
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

            public static String files_to_json(List<User_File> files){
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


            public static Boolean is_login(HttpSession session,int user_id){
                if(session.getAttribute("USERID")==null){
                    return false;
                }

                int session_id=(int)session.getAttribute("USERID");
                return session_id==user_id;
            }


    public synchronized static int generate_file_id(){
        Properties.file_id++;
        System.out.println("File_id: "+Properties.file_id);
        return Properties.file_id;
    }

    public static String generate_file_path(int file_id,String file_name){
        String base_path=Properties.file_path;
        String path=base_path+file_id+"_"+System.currentTimeMillis()+"_"+file_name;
        return path;
    }

    public static String generate_profile_path(String user_id,String file_name){
        String base_path=Properties.user_pic_path;
        String path=base_path+user_id+"_"+file_name;
        return path;
    }

    public static String cal_file_size(long size){
        DecimalFormat df = new DecimalFormat("#0.00");
        long byte_size=size;
        if(byte_size/1024.0>=1024){
            return df.format(byte_size/1024.0/1024.0)+"MB";
        }
        else {
            return df.format(byte_size/1024.0)+"KB";
        }
    }

    public static String get_file_type(String filename){
        String[] sp=filename.split("\\.");
        String type;
        if(sp.length<2){
            type= "未知格式";
        }
        else {
            String suffix = sp[sp.length-1];
            switch (suffix){
                case "doc":
                case "docx":
                case "txt":
                    type="文本格式";
                    break;
                case "pdf":
                    type="PDF格式";
                    break;
                case "flv":
                case "rmvb":
                case "rm":
                case "avi":
                case "mov":
                case "wmv":
                    type="视频格式";
                    break;
                case "mp3":
                case "wma":
                case "flac":
                case "ape":
                    type="音频格式";
                    break;
                case "zip":
                case "rar":
                    type="压缩包格式";
                    break;
                default:
                    type=suffix+"格式";
            }
        }

        return type;
    }
}
