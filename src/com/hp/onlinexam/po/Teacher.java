package com.hp.onlinexam.po;

public class Teacher {
	private int tId;
	private String tName;
	private String pwd;
	private String tDeptName;

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String gettDeptName() {
		return tDeptName;
	}

	public void settDeptName(String tDeptName) {
		this.tDeptName = tDeptName;
	}

}
