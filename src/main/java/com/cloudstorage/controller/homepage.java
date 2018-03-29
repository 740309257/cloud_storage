package com.cloudstorage.controller;

import com.cloudstorage.conf.UserLoginUtil;
import com.cloudstorage.entity.*;
import com.cloudstorage.service_inter.file_service_inter;
import com.cloudstorage.service_inter.friend_service_inter;
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
	@RequestMapping(value = "/homepage/{userId}")
	public String home(@PathVariable("userId") String id, HttpSession session, ModelMap m){
//        if(!util.is_login(session,Integer.parseInt(id))){
//            return "redirect:/main_page";
//        }
		User u;
		List<User> friends;
		List<UserFile> files;
		List<HashMap> l_file_share;
		List<HashMap> l_friend_applier;

		u = UserLoginUtil.getLoginUserInfo();
		if(u == null){
			return "error_page";
		}
		System.out.println(util.toJson(u));
		friends = friend_service.getFriendsByUser(u);
		files = file_service.getAllFilesByUser(u);
		l_file_share = file_service.get_share_info(Integer.parseInt(id));
		l_friend_applier = friend_service.get_apply_info(Integer.parseInt(id));

		m.addAttribute("user", u);
		m.addAttribute("l_friend", friends);
		m.addAttribute("l_file", files);
		m.addAttribute("l_file_share", l_file_share);
		m.addAttribute("l_friend_applier", l_friend_applier);
		return "homepage";
	}


	@RequestMapping(value = "/grant_friend", method = RequestMethod.POST)
	public void grant_friend(String id, String date, HttpSession session, HttpServletResponse response) throws IOException{
		int idx;
		PrintWriter out = response.getWriter();
		if(session.getAttribute("USERID") != null){
			System.out.println(id);
			System.out.println(date);
			idx = (int) session.getAttribute("USERID");
			if(friend_service.change_apply_states_0(new FriendApply(Integer.parseInt(id), idx, 1, date))){
				if(friend_service.add_friend(idx, Integer.parseInt(id))){
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

	@RequestMapping(value = "/deny_friend", method = RequestMethod.POST)
	public void deny_friend(String id, String date, HttpSession session, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		int idx;
		if(session.getAttribute("USERID") != null){
			idx = (int) session.getAttribute("USERID");
			if(friend_service.change_apply_states_0(new FriendApply(Integer.parseInt(id), idx, 1, date))){
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


	@RequestMapping(value = "/grant_file", method = RequestMethod.POST)
	public void grant_file(String id, String date, HttpSession session, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		int idx;
		if(session.getAttribute("USERID") != null){
			idx = (int) session.getAttribute("USERID");
			System.out.println("USID:" + id);
			FileShare file_share = new FileShare();
			file_share.setFile_id(Integer.parseInt(id));
			file_share.setTarget_id(idx);
			file_share.setIs_valid(1);
			file_share.setDate(date);

			if(file_service.change_share_states_0(file_share)){
				if(file_service.save_file(file_share.getFile_id(), idx)){
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


	@RequestMapping(value = "/deny_file", method = RequestMethod.POST)
	public void deny_file(String id, String date, HttpSession session, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		int idx;
		if(session.getAttribute("USERID") != null){
			idx = (int) session.getAttribute("USERID");
			FileShare file_share = new FileShare();
			file_share.setFile_id(Integer.parseInt(id));
			file_share.setTarget_id(idx);
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
	public String zone(@PathVariable("id") String id, ModelMap m){
		List<Post> posts = message_service.getZoneMessageById(Integer.parseInt(id));
		m.addAttribute("id", id);
		m.addAttribute("l_message", posts);
		return "zone";
	}

	@RequestMapping(value = "/my_message/{id}")
	public String my_message(@PathVariable("id") String id, ModelMap m){
		User u = user_service.getUserByID(Integer.parseInt(id));
		List<Post> posts = message_service.getMessageByUser(u);
		m.addAttribute("id", id);
		m.addAttribute("l_message", posts);
		return "my_message";
	}

	@RequestMapping(value = "/file_upload_page/{id}")
	public String file_upload(@PathVariable("id") String id, ModelMap m){
		m.addAttribute("id", id);
		return "fileUpload";
	}

	@RequestMapping(value = "/profile_upload_page/{id}")
	public String profile_upload(@PathVariable("id") String id, ModelMap m){
		m.addAttribute("id", id);
		return "profileUpload";
	}

	@RequestMapping(value = "/get_profile/{id}")
	public void get_profile(@PathVariable("id") String id, HttpServletResponse response) throws IOException{
		User u = user_service.getUserByID(Integer.parseInt(id));
		String path = u.getPic_path();
		util.getProfile(path, response);
	}


	@RequestMapping(value = "/file_detail/{file_id}")
	public String file_detail(@PathVariable("file_id") String file_id, HttpSession session, ModelMap m){
		HashMap f;
		List<User> friends = new ArrayList<>();
		int id;
		if(session.getAttribute("USERID") != null){
			id = (int) session.getAttribute("USERID");
			f = file_service.getFileDetailById(Integer.parseInt(file_id), id);
			friends = friend_service.getFriendsByUser(user_service.getUserByID(id));
			m.addAttribute("id", id);
			m.addAttribute("m_file", f);
			m.addAttribute("l_friend", friends);
			return "file_detail";
		}
		return "error_page";

	}
}
