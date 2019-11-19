package com.shentianyu.common;
/**
 * 
 * @ClassName: MyAssert 
 * @Description: 自定义断言
 * @author:jyj 
 * @date: 2019年11月17日 下午7:19:40
 */
public class MyAssert {

	public static void AssertTrue(boolean flag, String msg) {
		/**
		 * !flag 如果是错的 那么 就是对的 
		 */
		if(!flag) { //如果是对的就抛出异常
			throw new MyException(msg);
		}
		
	}
	
}
