package com.cloud_storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: ZJW
 * @Description:
 * @Date: Created in 20:58 2017/11/4 0004
 **/
@Controller
public class TestController {
	@RequestMapping(value = "/testhome", method = RequestMethod.GET)
	public String testHome(){
		return "homepage_new";
	}
}
