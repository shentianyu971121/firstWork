package com.shentianyu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shentianyu.common.ConstantClass;
import com.shentianyu.common.MsgResult;
import com.shentianyu.common.MyAssert;
import com.shentianyu.entity.User;
import com.shentianyu.service.LoginOrRegisterService;
/**
 * 
 * @ClassName: LoginOrRegisterController 
 * @Description: 登录或者注册所用到的控制层
 * @author:jyj 
 * @date: 2019年11月17日 下午7:03:39
 */
@RequestMapping("loginOrRegister")
@Controller
public class LoginOrRegisterController {

	@Autowired
	private LoginOrRegisterService loginOrRegisterService;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Autowired
	RedisTemplate redisTemplate;
	/**
	 * 
	 * @Title: login 
	 * @Description: 第一次访问登录界面   就是去登录的界面
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("第一次login");
		return "LoginOrRegister/Login";
	}
	/**
	 * 
	 * @Title: login 
	 * @Description: 这个就是点击登录时 进入的方法
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, User user) {
		System.out.println("第二次进入login");
		//进入这个方法  就是让直接 登陆
		User user1 = loginOrRegisterService.login(user);
		System.out.println("你是时空裂缝很骄傲沙发上 ++++++++++++++++++++++++++++++++++++" + user1);
		//查看是否查询成功
		if(user1 != null && user1.getRole() == 0) { //普通用户登录
			//将其存放在session作用于 中
			HttpSession ss = request.getSession();
			redisTemplate.delete("hotList");
			//将其存放在session中
			ss.setAttribute(ConstantClass.USER_SESSION_KEY, user1);
			return "redirect:/user/userMain";
		} else if(user1 != null && user1.getRole() == 1) { //管理员账号登录
			//将其存放在session作用于 中
			HttpSession ss = request.getSession();
			//将其存放在session中
			ss.setAttribute(ConstantClass.USER_SESSION_KEY, user1);
			return "redirect:/admin/admin";
		}
		return "LoginOrRegister/Login";
	}
	
	/**
	 * 
	 * @Title: register 
	 * @Description: 通过这个方法进入注册界面
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String register() {
		System.out.println("第一次进入注册");
		return "LoginOrRegister/register";
	}
	/**
	 * 
	 * @Title: register 
	 * @Description: 将注册的信息 就直接提交到 这里面来了
	 * @param request
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, User user) {
		System.out.println("注册信息的方法");
		//这个就是直接 进入注册方法
		int result = loginOrRegisterService.register(user);
		System.out.println(result);
		MyAssert.AssertTrue(result > 0, "用户注册失败,请稍后重试");
		return "redirect:/loginOrRegister/login";
	}
	/**
	 * 
	 * @Title: getUsername 
	 * @Description: 根据指定的username来查询是否已经注册
	 * @param request
	 * @param username
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@RequestMapping("getUsername")
	public boolean getUsername(HttpServletRequest request, String username) {
		System.out.println(username);
		//去后台进行查询看看是否有值  如果有值的话就不让注册
		User user = loginOrRegisterService.getUserByUsername(username);
		return user==null;
	}
	/**
	 * 
	 * @Title: getUsername 
	 * @Description: 点击退出登录
	 * @param request
	 * @param username
	 * @return
	 * @return: boolean
	 */
	@RequestMapping("exit")
	public String exit(HttpServletRequest request) {
		System.out.println("进入了session对象");
		//退出登录  就是清楚session缓存 让后调往主界面
		HttpSession ss = request.getSession();
		ss.removeAttribute(ConstantClass.USER_SESSION_KEY);
		return "redirect:/loginOrRegister/login";
	}
}
