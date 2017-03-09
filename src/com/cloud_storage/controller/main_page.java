package com.cloud_storage.controller;

import com.cloud_storage.entity.File;
import com.cloud_storage.entity.User;
import com.cloud_storage.service_inter.user_service_inter;
import com.cloud_storage.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by dell on 1/23/2017.
 */
@Controller
public class main_page {

    @Autowired
    private user_service_inter user_service;

    //访问主页
    @RequestMapping(value = "/main_page", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        return "index";
    }


    //验证用户名密码，正确后重定向至个人主页
    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public void verify_result(String login_username, String login_password,String verify_code,HttpSession session, HttpServletResponse response) throws IOException {

        System.out.println(login_username);
        PrintWriter out=response.getWriter();

        if(session.getAttribute("VERIFY_CODE")==null||!session.getAttribute("VERIFY_CODE").equals(verify_code)){
            out.print("error");
            return;
        }

        if (user_service.verify_password(login_username,login_password)) {
            int user_id = user_service.get_user_id_by_name(login_username);
            System.out.println(user_id + "\n" + login_username);

            session.setAttribute("USERID", user_id);
            session.setAttribute("USERNAME", login_username);
            out.print(user_id);
        }
       else {
            out.print("error");
        }
        out.flush();
        out.close();
    }


    //点击注册按钮后跳转至注册页面
    @RequestMapping(value = "/register")
    public String register(){
        return "register";
    }


    //搜索用户
    @RequestMapping(value = "/search_user",method = RequestMethod.POST)
    public ModelAndView search_user(String search_user){
        System.out.println(search_user);
        List<User> l_user=user_service.search_users(search_user);
        System.out.println(l_user.size());
        ModelAndView mav=new ModelAndView("search_user");
        //搜索信息
        mav.addObject("l_user",l_user);
        return mav;
    }

    //搜索文件
    @RequestMapping(value = "/search_file",method = RequestMethod.POST)
    public ModelAndView search_file(String search_file){
        System.out.println(search_file);
        List<File> l_file=user_service.search_files(search_file);
        System.out.println(l_file.size());
        ModelAndView mav=new ModelAndView("search_file");
        //搜索信息
        mav.addObject("l_file",l_file);
        return mav;
    }

    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void captcha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CaptchaUtil.outputCaptcha(request, response);
    }
}
