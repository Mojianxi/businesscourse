package com.jjcw.course.utils;

/**
 * 
 * <p>Title:BaseBean </p>
 * <p>Description:所有实体类的父类</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public class BaseBean {

	//起始记录
	private int start;
	
	//每次查询的条数
	private int length;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
	
}
