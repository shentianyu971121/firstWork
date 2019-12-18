package com.shentianyu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shentianyu.common.ConstantClass;
import com.shentianyu.common.MsgResult;
import com.shentianyu.common.MyAssert;
import com.shentianyu.entity.AdminFavorite;
import com.shentianyu.entity.User;
import com.shentianyu.service.AdminService;
import com.shentianyu.service.UserService;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	
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
	
	/**
	 * 
	 * @Title: addAdminFavorite 
	 * @Description: 这个是跳转到添加页面
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("addAdminFavorite")
	public String addAdminFavorite(HttpServletRequest request) {
		//添加需要使用jsr303验证
		request.setAttribute("adminFavorite", new AdminFavorite());
		
		return "admin/addAdminFavorite";
	}
	/**
	 * 
	 * @Title: addFavorite 
	 * @Description: 进行添加
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping("addFavorite")
	public String addFavorite(HttpServletRequest request, 
			@Valid @ModelAttribute("adminFavorite")AdminFavorite adminFavorite, BindingResult result) {
		//添加需要使用jsr303验证   首先判断是否有错误
		if(result.hasErrors()) {
			//如果有错误就不让进行添加
			return "admin/addAdminFavorite";
		}
		//那么到这里就是没有错误
		//获取session作用域中的id值
		User user = (User) request.getSession().getAttribute(ConstantClass.USER_SESSION_KEY);
		//对数据进行添加
		int num = adminService.addAdminFavorite(adminFavorite, user.getId());
		if(num > 0) {
			return "redirect:/admin/admin";
		}
		return "admin/addAdminFavorite";
	}
	/**
	 * 
	 * @Title: noFavorite 
	 * @Description: 取消收藏的方法
	 * @param request
	 * @param adminFavorite
	 * @param result
	 * @return
	 * @return: String
	 */
	@RequestMapping("noFavorite")
	@ResponseBody
	public Object noFavorite(HttpServletRequest request, Integer id) {
		//首先获取id  判断id的值合不合法
		MyAssert.AssertTrue(id > 0, "id不合法");
		//然后判断数据库里面是不是有值
		AdminFavorite adminFavorite = adminService.findAdminFavoriteById(id);
		MyAssert.AssertTrue(adminFavorite != null, "输入的值有误,请重新输入");
		//然后对数据进行删除
		int result = adminService.deleteAdminFavorite(id);
		if(result > 0) {
			return new MsgResult(1, "已取消", null);
		}
		return new MsgResult(2, "取消失败", null);
	}
}











