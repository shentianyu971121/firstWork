package com.shentianyu.common;

import java.io.Serializable;

public class MsgResult implements Serializable {

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1188515353050347902L;

	int result;
	String errorMsg;
	Object data;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public MsgResult(int result, String errorMsg, Object data) {
		super();
		this.result = result;
		this.errorMsg = errorMsg;
		this.data = data;
	}
	@Override
	public String toString() {
		return "MsgResult [result=" + result + ", errorMsg=" + errorMsg + ", data=" + data + "]";
	}
	public MsgResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
