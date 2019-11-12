package com.shentianyu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "admin")
public class AdminController {

	@RequestMapping("test")
	public String testAdmin(HttpServletRequest request) {
		
		return "show/index2";
	}
}
