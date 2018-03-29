package com.cloudstorage.controller;

import com.cloudstorage.entity.File;
import com.cloudstorage.entity.User;
import com.cloudstorage.service_inter.user_service_inter;
import com.cloudstorage.util.CaptchaUtil;
import com.cloudstorage.util.CloudContants;
import com.cloudstorage.util.util;
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
import java.util.Arrays;
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
	public String MainPage(ModelMap model){
		return "index";
	}


	//验证用户名密码，正确后重定向至个人主页
	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public void verify_result(String login_username, String login_password, String verify_code, HttpSession session, HttpServletResponse response) throws IOException{

		System.out.println(login_username);
		PrintWriter out = response.getWriter();

		if(util.validate_code(session, verify_code) == false){
			out.print("error");
			return;
		}

		if(user_service.verify_password(login_username, login_password)){
			int id = user_service.get_id_by_name(login_username);
			User user = user_service.getUserByID(id);
			System.out.println(id + "\n" + login_username);

			session.setAttribute(CloudContants.SESSION_USER_KEY, user);
			session.setAttribute(CloudContants.SESSION_ROLE_KEY, Arrays.asList("ROLE_USER"));
			out.print(id);
		} else {
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
	@RequestMapping(value = "/search_user", method = RequestMethod.POST)
	public ModelAndView search_user(String search_user){
		System.out.println(search_user);
		List<User> l_user = user_service.search_users(search_user);
		System.out.println(l_user.size());
		ModelAndView mav = new ModelAndView("search_user");
		//搜索信息
		mav.addObject("l_user", l_user);
		return mav;
	}

	//搜索文件
	@RequestMapping(value = "/search_file", method = RequestMethod.POST)
	public ModelAndView search_file(String search_file){
		System.out.println(search_file);
		List<File> l_file = user_service.search_files(search_file);
		System.out.println(l_file.size());
		ModelAndView mav = new ModelAndView("search_file");
		//搜索信息
		mav.addObject("l_file", l_file);
		return mav;
	}

	@RequestMapping(value = "/captcha", method = RequestMethod.GET)
	public void captcha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		CaptchaUtil.outputCaptcha(request, response);
	}
}
