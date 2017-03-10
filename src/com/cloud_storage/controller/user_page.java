package com.cloud_storage.controller;

import com.cloud_storage.entity.*;
import com.cloud_storage.service_inter.file_service_inter;
import com.cloud_storage.service_inter.friend_service_inter;
import com.cloud_storage.service_inter.message_service_inter;
import com.cloud_storage.service_inter.user_service_inter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Controller
public class user_page {
    @Autowired
    private user_service_inter user_service;
    @Autowired
    private friend_service_inter friend_service;
    @Autowired
    private message_service_inter message_service;
    @Autowired
    private file_service_inter file_service;

    //返回用户主页，传递user对象，动态，好友，**文件还没有实现
    @RequestMapping(value = "/userpage/{id}",method = RequestMethod.GET)
    public String userpage(@PathVariable("id")String id, ModelMap m){
        User u;
        List<User> friends;
        List<Message> messages;
        List<File> files;

        u=user_service.getUserByID(Integer.parseInt(id));
        if(u==null){
            return "error_page";
        }
        friends=friend_service.getFriendsByUser(u);
        messages=message_service.getMessageByUser(u);
        files=file_service.getPublicFilesByUser(u);

        m.addAttribute("user",u);
        m.addAttribute("l_friend",friends);
        m.addAttribute("l_message",messages);
        m.addAttribute("l_file",files);

        return "userpage";
    }

    //添加好友
    @RequestMapping(value = "/apply_friend",method = RequestMethod.POST)
    public void add_friend(String id, HttpSession session, HttpServletResponse response) throws IOException {
        PrintWriter writer=response.getWriter();
        int applier_id;
        int target_id;
        Boolean result;
        if(session.getAttribute("USERID")!=null){
            applier_id=(int)session.getAttribute("USERID");
            System.out.println("applier_id: "+applier_id);
            target_id=Integer.parseInt(id);
            result=friend_service.apply_friend(new Friend_apply(applier_id,target_id,1,new Date().toString()));
            if(result){
                writer.print("true");
            }
            else {
                writer.print("error");
            }
        }
        else {
            writer.print("error");
        }
        writer.flush();
        writer.close();
    }


    @RequestMapping(value = "/fork_file",method = RequestMethod.POST)
    public void add_file(String id, HttpSession session,HttpServletResponse response) throws IOException {
        PrintWriter writer=response.getWriter();
        int user_id;
        if(session.getAttribute("USERID")!=null){
                user_id=(int)session.getAttribute("USERID");
                File file=file_service.getFileById(Integer.parseInt(id));
                file.setUser_id(user_id);
                if(file_service.add_file(file)){
                    writer.print("true");
                }
                else {
                    writer.print("error");
                }
        }
        else {
            writer.print("error");
        }
        writer.flush();
        writer.close();
    }

}
