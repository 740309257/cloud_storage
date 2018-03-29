package com.cloudstorage.controller;

import com.cloudstorage.entity.Comment;
import com.cloudstorage.entity.Post;
import com.cloudstorage.service_inter.message_service_inter;
import com.cloudstorage.service_inter.user_service_inter;
import com.cloudstorage.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by dell on 1/25/2017.
 */
@Controller
public class message_page {
    @Autowired
    private message_service_inter message_service;
    @Autowired
    private user_service_inter user_service;

    @RequestMapping(value = "/publish_message/{id}",method = RequestMethod.POST)
    public String publish_message(@PathVariable("id")String publisher_id, String text, HttpSession session){
        Post post =new Post();
        post.setPublisher_id(Integer.parseInt(publisher_id));
        post.setText(text);
        post.setTime(new Date());
        post.setPublisher_name(user_service.getUserByID(Integer.parseInt(publisher_id)).getUsername());
        if(message_service.save_message(post)){
            return "";
        }
        else {
            return "error_page";
        }
    }

    @RequestMapping(value = "/comment/{messageId}")
    public String comment(@PathVariable("messageId")String message_id, ModelMap m){
        List<Comment> comments=message_service.getComment(Integer.parseInt(message_id));
        m.addAttribute("message_id",message_id);
        m.addAttribute("l_comment",comments);
        return "comment";
    }

    @RequestMapping(value = "/publish_comment/{id}",method = RequestMethod.POST)
    public void publish_comment(@PathVariable("id")String id, String message_id, String text,HttpSession session, HttpServletResponse response) throws IOException {
        PrintWriter writer=response.getWriter();
        if(!util.is_login(session,Integer.parseInt(id))){
            writer.print("error");
        }
        else {
            Comment comment = new Comment();
            comment.setText(text);
            comment.setMessage_id(Integer.parseInt(message_id));
            comment.setUserId(Integer.parseInt(id));
            comment.setUsername(user_service.getUserByID(Integer.parseInt(id)).getUsername());
            if (message_service.save_comment(comment)) {
                if (message_service.Comment_num_plus(Integer.parseInt(message_id))) {
                    writer.print("true");
                } else {
                    writer.print("error");
                }
            } else {
                writer.print("error");
            }
        }
        writer.flush();
        writer.close();
    }

}
