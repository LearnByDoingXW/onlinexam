package com.hp.onlinexam.po;

public class Papers {
	private int id;
	private int testId;
	private int courseId;
	private String time;
	private double score;
	private String wrongQueId;
	private String wrongAns;
	private int studentId;
	private String creatDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getWrongQueId() {
		return wrongQueId;
	}

	public void setWrongQueId(String wrongQueId) {
		this.wrongQueId = wrongQueId;
	}

	public String getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

}
