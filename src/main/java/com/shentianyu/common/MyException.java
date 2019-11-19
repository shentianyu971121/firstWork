package com.shentianyu.common;
/**
 * 
 * @ClassName: MyException 
 * @Description: 自定义异常类
 * @author:jyj 
 * @date: 2019年11月17日 下午7:19:19
 */
public class MyException extends RuntimeException{

	public MyException(String str) {
		super(str);
	}
}
