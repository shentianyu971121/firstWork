package com.shentianyu.entity;

public enum Gender {

	A("男"),
	B("女");
	
	public String displayName;

	//这个方法调用时直接展示的是构造里面的值
	public String getDisplayName() {
		return displayName;
	}

	private Gender(String displayName) {
		this.displayName = displayName;
	}
	//getName也就是获取的枚举项  A、B
	public String getName() {
		return this.name();
	}
	
	//获取int类型的值  存到数据库中  因为数据库中需要用到int类型
	public int getOrdinal() {
		return this.ordinal();
	}
	
	
}
