package com.cloudstorage.controller;

import com.cloudstorage.entity.User;
import com.cloudstorage.entity.UserFile;
import com.cloudstorage.service_inter.TPA_service_inter;
import com.cloudstorage.service_inter.file_service_inter;
import com.cloudstorage.service_inter.user_service_inter;
import com.cloudstorage.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 3/9/2017.
 */
@Controller
public class TPA_controller {
    @Autowired
    private file_service_inter file_service;
    @Autowired
    private user_service_inter user_service;
    @Autowired
    private TPA_service_inter tpa_service;

    @RequestMapping(value = "/tpa_login",method = RequestMethod.POST)
    public void Tpa_login(String login_username,String login_password,String token,HttpServletResponse response) throws IOException {
        List<UserFile> files=new ArrayList<>();
        int id;
        User u=new User();

        System.out.println("N:"+login_username);
        System.out.println("P:"+login_password);
        System.out.println("T:"+token);

        PrintWriter out=response.getWriter();
        if (user_service.verify_password(login_username,login_password)&&tpa_service.validate_token(token)) {
            id=user_service.get_id_by_name(login_username);
            u.setId(id);
            files=file_service.getAllFilesByUser(u);
            String res_data=util.files_to_json(files);
            out.write(id+"\r\n");
            out.write(res_data);
        }
        else {
            out.print("error");
        }
        out.flush();
        out.close();
    }



    @RequestMapping(value = "/tpa_upload",method = RequestMethod.POST)
    public void Tpa_upload(String id, String token, String filename, @RequestParam("up_file") CommonsMultipartFile up_file, HttpServletResponse response) throws IOException {
        System.out.println("id:"+id+"\n"+"token:"+token+"\n"+"filename:"+filename+"\n"+"ori_name:"+up_file.getOriginalFilename());
        PrintWriter writer=response.getWriter();
        String save_path="";
        int file_id=util.generate_file_id();
        UserFile user_file=new UserFile();
        save_path= util.generate_file_path(file_id,up_file.getOriginalFilename());
        try {
            File file = new File(save_path);
            up_file.transferTo(file);
            System.out.println("filename: " + filename);
            com.cloudstorage.entity.File f = new com.cloudstorage.entity.File();
            f.setFile_path(save_path);
            f.setFilename(up_file.getOriginalFilename());
            f.setNums(1);
            f.setProvider_id(Integer.parseInt(id));
            f.setFile_id(file_id);
            f.setSize(util.cal_file_size(up_file.getSize()));
            f.setType(util.get_file_type(up_file.getOriginalFilename()));

            if (file_service.add_file(f)) {
                user_file.setFile_id(f.getFile_id());
                user_file.setSize(f.getSize());
                user_file.setDate(new Date().toString());
                user_file.setAuthority(1);
                user_file.setUser_id(Integer.parseInt(id));
                user_file.setFilename(filename);

                if (file_service.add_user_file(user_file)) {
                    System.out.println("Files were uploaded successfully!");
                    writer.write("true");
                    writer.flush();
                    writer.close();
                    return;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        writer.write("error");
        writer.flush();
        writer.close();
    }
}
