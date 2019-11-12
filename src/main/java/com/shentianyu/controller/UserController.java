package com.shentianyu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "user")
public class UserController {

	@RequestMapping(value = "hellow", method = RequestMethod.GET)
	public String userTest(HttpServletRequest request) {
		request.setAttribute("info", "Hellow");
		return "test/hellow";
	}
}
