package com.cloud_storage.controller;

import com.cloud_storage.entity.User;
import com.cloud_storage.service.file_service;
import com.cloud_storage.service_inter.TPA_service_inter;
import com.cloud_storage.service_inter.file_service_inter;
import com.cloud_storage.service_inter.user_service_inter;
import com.cloud_storage.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static oracle.net.aso.C01.i;

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
        List<com.cloud_storage.entity.User_File> files=new ArrayList<>();
        int user_id;
        User u=new User();

        System.out.println("N:"+login_username);
        System.out.println("P:"+login_password);
        System.out.println("T:"+token);

        PrintWriter out=response.getWriter();
        if (user_service.verify_password(login_username,login_password)&&tpa_service.validate_token(token)) {
            user_id=user_service.get_user_id_by_name(login_username);
            u.setUser_id(user_id);
            files=file_service.getAllFilesByUser(u);
            String res_data=util.files_to_json(files);
            out.write(user_id+"\r\n");
            out.write(res_data);
        }
        else {
            out.print("error");
        }
        out.flush();
        out.close();
    }


/*
    @RequestMapping(value = "/tpa_upload",method = RequestMethod.POST)
    public void Tpa_upload(String user_id, String token, String filename, @RequestParam("up_file") CommonsMultipartFile up_file, HttpServletResponse response) throws IOException {
        System.out.println("id:"+user_id+"\n"+"token:"+token+"\n"+"filename:"+filename+"\n"+"ori_name:"+up_file.getOriginalFilename());
        PrintWriter writer=response.getWriter();
        String save_path="";
        Boolean result;
        save_path= file_service.generate_file_path(user_id,up_file.getOriginalFilename());
        File file=new File(save_path);
        up_file.transferTo(file);
        System.out.println("filename: "+filename);
        com.cloud_storage.entity.File f=new com.cloud_storage.entity.File();
        f.setUser_id(Integer.parseInt(user_id));
        f.setFile_path(save_path);
        f.setFilename(filename);
        f.setAuthority(0);
        result=file_service.add_file(f);
        if(result==true){
            writer.print("success");
        }
        else {
            writer.print("error");
        }
        writer.flush();
        writer.close();
    }
    */
}
