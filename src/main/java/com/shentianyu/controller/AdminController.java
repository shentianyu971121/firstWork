package com.shentianyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shentianyu.common.ConstantClass;
import com.shentianyu.common.MsgResult;
import com.shentianyu.common.MyAssert;
import com.shentianyu.entity.User;
import com.shentianyu.service.UserService;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	
	@RequestMapping("admin")
	public String testAdmin(HttpServletRequest request) {
		//判断是否是管理员
		User user = (User) request.getSession().getAttribute(ConstantClass.USER_SESSION_KEY);
		System.out.println("进入admin界面 ++++++ ++++++ ++ + + +  ++ ++  + " + user);
		//然后进行判断
		MyAssert.AssertTrue(user.getRole() == 1, "您不是管理员 没有权限进入此界面");
		return "show/index";
	}

	
	@Autowired
	private UserService service;
	
	
	@RequestMapping("users")
	public String getUserList(HttpServletRequest request, @RequestParam(defaultValue = "1")int pageNum, String mohu) {
		PageInfo info = service.getUserList(pageNum, mohu);
		request.setAttribute("info", info);
		request.setAttribute("mohu", mohu);
		request.setAttribute("pageNum", pageNum);
		return "admin/adminList";
	}
	
	
	@ResponseBody
	@RequestMapping("updateStatus")
	public Object lockUpdate(int userId, int status) {
		if(status != 1 && status != 0) {
			return new MsgResult(2, "参数无效", null);
		}
		//然后去后台进行查询信息 如果为空则用户不存在
		User user = service.getUserById(userId);
		if(user == null) {
			return new MsgResult(2, "该用户不存在", null);
		}
		if(user.getLocked() == status) {
			return new MsgResult(2, "无需做此操作", null);
		}
		//然后进行添加
		int result = service.updateStatus(userId, status);
		if(result > 0) {
			return new MsgResult(1, "处理成功", null);
		} else {
			return new MsgResult(2, "处理失败,请与管理员联系", null);
		}
	}
	
}
