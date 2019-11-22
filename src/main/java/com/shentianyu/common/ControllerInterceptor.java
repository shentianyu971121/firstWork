package com.shentianyu.common;

import java.io.Serializable;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice   //ControllerAdvice就是将指定的异常抛出之后进行捕获
public class ControllerInterceptor implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 8864556517249810508L;

	
	@ExceptionHandler(MyException.class)  //这个就是捕获异常类
	@ResponseBody
	public MsgResult interceptorException(MyException exception) {
		System.out.println("不好意思 有错误了:" + exception);    //exception里面有个方法  就是输出异常信息
		return new MsgResult(100, exception.getMessage(), null);
	}
	
}
