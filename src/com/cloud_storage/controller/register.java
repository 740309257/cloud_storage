package com.cloud_storage.controller;

import com.cloud_storage.entity.User;
import com.cloud_storage.service_inter.user_service_inter;
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
        Boolean save_result=user_service.save_user(u);
        PrintWriter out=response.getWriter();

        if(session.getAttribute("VERIFY_CODE")==null||!session.getAttribute("VERIFY_CODE").equals(verify_code)){
            out.print("error");
            return;
        }

        if(save_result){
            int user_id = user_service.get_user_id_by_name(u.getUsername());
            System.out.println(user_id + "\n" + u.getUsername());

            session.setAttribute("USERID", user_id);
            session.setAttribute("USERNAME", u.getUsername());
            out.println(user_id);
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
