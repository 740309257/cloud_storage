package com.cloudstorage.controller;

import com.cloudstorage.entity.User;
import com.cloudstorage.service_inter.user_service_inter;
import com.cloudstorage.util.util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by dell on 1/23/2017.
 */
@Controller
public class register {
    @Autowired
    private user_service_inter user_service;

    //接收提交的注册信息，重定向至个人主页
    @RequestMapping(value = "submit",method = RequestMethod.POST)
    public void submit_inf(User u,String verify_code, HttpSession session,HttpServletResponse response) throws IOException {
        Boolean save_result;
        PrintWriter out=response.getWriter();

        if(util.validate_code(session,verify_code)==false){
            out.print("error");
            return;
        }

        save_result=user_service.save_user(u);

        if(save_result){
            int id = user_service.get_id_by_name(u.getUsername());
            System.out.println(id + "\n" + u.getUsername());

            session.setAttribute("USERID", id);
            session.setAttribute("USERNAME", u.getUsername());
            out.println(id);
            out.flush();
        }
        else {
            out.print("error");
            out.flush();
        }
        out.close();
    }



    @RequestMapping(value = "is_exist",method = RequestMethod.POST)
    public void is_exist(String username, HttpServletResponse response){
        System.out.println(username +"got!");
        PrintWriter out= null;
        try {
            out = response.getWriter();

        if(user_service.username_exist(username)){
            out.print("true");
            out.flush();
            System.out.println("exist!");
        }
        else {
            System.out.println("Not exist!");
            out.print("false");
            out.print("true");
        }

        out.close();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
