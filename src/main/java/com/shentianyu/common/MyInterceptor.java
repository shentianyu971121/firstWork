package com.shentianyu.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.shentianyu.entity.User;

/**
 * 
 * @ClassName: MyInterceptor 
 * @Description: 拦截器类s
 * @author:jyj 
 * @date: 2019年11月18日 下午8:19:48
 */
public class MyInterceptor implements HandlerInterceptor {

	/**
	 * 登陆之前走的方法
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//首先获取session作用域的对象
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(ConstantClass.USER_SESSION_KEY);
		System.out.println(user);
		if(user == null) {
			session.setAttribute("error", "请先登陆");
			response.sendRedirect("/loginOrRegister/login");
			return false;
		}
		request.getRequestDispatcher("/user/userMain").forward(request, response);
		return true;
	}
}
