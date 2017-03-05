package com.cloud_storage.controller;


import com.cloud_storage.entity.File_share;
import com.cloud_storage.service_inter.file_service_inter;
import com.cloud_storage.service_inter.user_service_inter;
import com.cloud_storage.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.swing.SwingUtilities2;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 1/26/2017.
 */
@Controller
public class upload_page {
    @Autowired
    file_service_inter file_service;
    @Autowired
    user_service_inter user_service;


    @RequestMapping(value = "/fileUpload/{user_id}")
    public String section_upload(@PathVariable("user_id") String user_id, MultipartHttpServletRequest request)
    {
        System.out.println("start processing...");
        List<MultipartFile> up_files = request.getFiles("up_file");
        System.out.println(up_files.size()+" files got...");
        String filename="";
        String save_path="";
        Boolean result;
        try {
            for(int i=0;i<up_files.size();i++)
            {
                save_path=file_service.generate_file_path(user_id,up_files.get(i).getOriginalFilename());
                File file=new File(save_path);
                up_files.get(i).transferTo(file);
                filename=request.getParameter("filename"+i);
                System.out.println("filename: "+filename);
                com.cloud_storage.entity.File f=new com.cloud_storage.entity.File();
                f.setUser_id(Integer.parseInt(user_id));
                f.setFile_path(save_path);
                f.setFilename(filename);
                f.setAuthority(0);
                result=file_service.add_file(f);
                if(result==false){
                    return "error_page";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error_page";
        }
        System.out.println("Files uploaded successfully!");
        return "redirect:/homepage/"+user_id;
    }

    @RequestMapping("/profileUpload/{user_id}")
    String profileUpload(@PathVariable("user_id")String user_id,@RequestParam("profile") CommonsMultipartFile profile) throws IOException {
        Boolean result=false;
        System.out.println("fileName："+profile.getOriginalFilename());
        String path=file_service.generate_profile_path(user_id,profile.getOriginalFilename());
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        profile.transferTo(newFile);
        result=user_service.setPicPath(Integer.parseInt(user_id),path);
        if(result){
            return "redirect:/homepage/"+user_id;
        }
        else {
            return "error_page";
        }
    }
}
