package com.cloudstorage.controller;


import com.cloudstorage.entity.UserFile;
import com.cloudstorage.service_inter.file_service_inter;
import com.cloudstorage.service_inter.user_service_inter;
import com.cloudstorage.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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


    @RequestMapping(value = "/fileUpload/{id}")
    public String section_upload(@PathVariable("id") String id, MultipartHttpServletRequest request)
    {
        System.out.println("start processing...");
        List<MultipartFile> up_files = request.getFiles("up_file");
        System.out.println(up_files.size()+" files got...");
        String filename="";
        String save_path="";
        int file_id;
        com.cloudstorage.entity.File f=new com.cloudstorage.entity.File();
        UserFile user_file=new UserFile();
        try {
            for(int i=0;i<up_files.size();i++)
            {
                file_id=util.generate_file_id();
                save_path= util.generate_file_path(file_id,up_files.get(i).getOriginalFilename());
                File file=new File(save_path);
                up_files.get(i).transferTo(file);
                filename=up_files.get(i).getOriginalFilename();
                System.out.println("filename: "+filename);

                f.setFile_path(save_path);
                f.setFilename(filename);
                f.setNums(1);
                f.setProvider_id(Integer.parseInt(id));
                f.setFile_id(file_id);
                f.setSize(util.cal_file_size(up_files.get(i).getSize()));
                f.setType(util.get_file_type(filename));


                if(file_service.add_file(f)){
                    user_file.setFile_id(f.getFile_id());
                    user_file.setSize(f.getSize());
                    user_file.setDate(new Date().toString());
                    user_file.setAuthority(1);
                    user_file.setUser_id(Integer.parseInt(id));
                    user_file.setFilename(request.getParameter("filename"+i));

                    if(file_service.add_user_file(user_file)){
                        System.out.println("Files uploaded successfully!");
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error_page";
        }
        return "redirect:/homepage/"+id;

    }

    @RequestMapping("/profileUpload/{id}")
    String profileUpload(@PathVariable("id")String id,@RequestParam("profile") CommonsMultipartFile profile) throws IOException {
        Boolean result=false;
        System.out.println("fileName："+profile.getOriginalFilename());
        String path=util.generate_profile_path(id,profile.getOriginalFilename());
        File newFile=new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        profile.transferTo(newFile);
        result=user_service.setPicPath(Integer.parseInt(id),path);
        if(result){
            return "redirect:/homepage/"+id;
        }
        else {
            return "error_page";
        }
    }
}
