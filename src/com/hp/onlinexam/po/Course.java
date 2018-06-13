package com.hp.onlinexam.po;

/*
 * 课程类 描述课程实体
 * 
 */
public class Course {

	/*
	 * java的数据类型 基本数据类型和引用数据类型
	 * 基本数据类型：byte,short,int,long,float,double,char,boolean 引用数据类型： 类，接口，数据
	 */
	private int cId;
	/*
	 * java 访问权限： public,private,protected,默认访问权限
	 */
	private String cName;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

}
