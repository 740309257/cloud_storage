package com.cloud_storage.controller;

import com.cloud_storage.entity.*;
import com.cloud_storage.entity.File;
import com.cloud_storage.service_inter.file_service_inter;
import com.cloud_storage.service_inter.friend_service_inter;
import com.cloud_storage.service_inter.message_service_inter;
import com.cloud_storage.service_inter.user_service_inter;
import com.cloud_storage.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dell on 1/24/2017.
 */
@Controller
public class homepage {
    @Autowired
    private friend_service_inter friend_service;
    @Autowired
    private user_service_inter user_service;
    @Autowired
    private message_service_inter message_service;
    @Autowired
    private file_service_inter file_service;



    //自己的主页，返回文件，朋友，加好友申请，***分享文件申请
    @RequestMapping(value = "/homepage/{user_id}")
    public String home(@PathVariable("user_id")String user_id, ModelMap m){
        User u;
        List<User> friends;
        List<File> files;
        List<HashMap> l_file_share;
        List<HashMap> l_friend_applier;

        u=user_service.getUserByID(Integer.parseInt(user_id));
        if(u==null){
            return "error_page";
        }
        friends=friend_service.getFriendsByUser(u);
        files=file_service.getAllFilesByUser(u);
        l_file_share=file_service.get_share_info(Integer.parseInt(user_id));
        l_friend_applier=friend_service.get_apply_info(Integer.parseInt(user_id));

        m.addAttribute("user",u);
        m.addAttribute("l_friend",friends);
        m.addAttribute("l_file",files);
        m.addAttribute("l_file_share",l_file_share);
        m.addAttribute("l_friend_applier",l_friend_applier);
        return "homepage";
    }


    @RequestMapping(value = "/grant_friend",method = RequestMethod.POST)
    public void grant_friend(String id, String date,HttpSession session,HttpServletResponse response) throws IOException {
        int user_id;
        PrintWriter out=response.getWriter();
        if(session.getAttribute("USERID")!=null){
            System.out.println(id);
            System.out.println(date);
            user_id=(int)session.getAttribute("USERID");
            if(friend_service.change_apply_states_0(Integer.parseInt(id),user_id,1,date)){
                if(friend_service.add_friend(user_id,Integer.parseInt(id))){
                    out.print("true");
                    out.flush();
                    out.close();
                    return;
                }
            }
        }
        out.print("false");
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/deny_friend",method = RequestMethod.POST)
    public void deny_friend(String id, String date,HttpSession session,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        int user_id;
        if(session.getAttribute("USERID")!=null){
            user_id=(int)session.getAttribute("USERID");
            if(friend_service.change_apply_states_0(Integer.parseInt(id),user_id,1,date)){
                out.print("true");
                out.flush();
                out.close();
                return;
            }
        }
        out.print("false");
        out.flush();
        out.close();
    }



    @RequestMapping(value = "/grant_file",method= RequestMethod.POST)
    public void grant_file(String id, String date, HttpSession session, HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        int user_id;
        if(session.getAttribute("USERID")!=null){
            user_id=(int)session.getAttribute("USERID");
            System.out.println("USID:"+user_id);
            File_share file_share=new File_share();
            file_share.setFile_id(Integer.parseInt(id));
            file_share.setTarget_id(user_id);
            file_share.setIs_valid(1);
            file_share.setDate(date);

            if(file_service.change_share_states_0(file_share)){
                File file=file_service.getFileById(Integer.parseInt(id));
                file.setUser_id(user_id);
                if(file_service.add_file(file)){
                    out.print("true");
                    out.flush();
                    out.close();
                    return;
                }
            }
        }

        out.print("false");
        out.flush();
        out.close();
    }


    @RequestMapping(value = "/deny_file",method = RequestMethod.POST)
    public void deny_file(String id,String date, HttpSession session,HttpServletResponse response) throws IOException {
        PrintWriter out=response.getWriter();
        int user_id;
        if(session.getAttribute("USERID")!=null){
            user_id=(int)session.getAttribute("USERID");
            File_share file_share=new File_share();
            file_share.setFile_id(Integer.parseInt(id));
            file_share.setTarget_id(user_id);
            file_share.setIs_valid(1);
            file_share.setDate(date);

            if(file_service.change_share_states_0(file_share)){
                out.print("true");
                out.flush();
                out.close();
                return;
            }
        }
        out.print("false");
        out.flush();
        out.close();
    }




    @RequestMapping(value = "/zone/{id}")
    public String zone(@PathVariable("id")String user_id,ModelMap m){
        List<Message> messages= message_service.getZoneMessageById(Integer.parseInt(user_id));
        m.addAttribute("user_id",user_id);
        m.addAttribute("l_message",messages);
        return "zone";
    }

    @RequestMapping(value = "/my_message/{id}")
    public String my_message(@PathVariable("id")String user_id,ModelMap m){
        User u=user_service.getUserByID(Integer.parseInt(user_id));
        List<Message> messages= message_service.getMessageByUser(u);
        m.addAttribute("user_id",user_id);
        m.addAttribute("l_message",messages);
        return "my_message";
    }

    @RequestMapping(value = "/file_upload_page/{user_id}")
    public String file_upload(@PathVariable("user_id")String user_id,ModelMap m){
        m.addAttribute("user_id",user_id);
        return "fileUpload";
    }
    @RequestMapping(value = "/profile_upload_page/{user_id}")
    public String profile_upload(@PathVariable("user_id")String user_id,ModelMap m){
        m.addAttribute("user_id",user_id);
        return "profileUpload";
    }

    @RequestMapping(value = "/get_profile/{user_id}")
    public void get_profile(@PathVariable("user_id")String user_id,HttpServletResponse response) throws IOException {
        User u = user_service.getUserByID(Integer.parseInt(user_id));
        String path = u.getPic_path();
        util.getProfile(path,response);
    }



    @RequestMapping(value = "/file_detail/{file_id}")
    public String file_detail(@PathVariable("file_id")String file_id,HttpSession session,ModelMap m){
        File f;
        List<User> friends=new ArrayList<>();
        int user_id;
        if(session.getAttribute("USERID")!=null){
            user_id=(int)session.getAttribute("USERID");
            f=file_service.getFileById(Integer.parseInt(file_id));
            friends=friend_service.getFriendsByUser(user_service.getUserByID(user_id));
            m.addAttribute("user_id",user_id);
            m.addAttribute("file",f);
            m.addAttribute("l_friend",friends);
            return "file_detail";
        }
        return "error_page";

    }
}
