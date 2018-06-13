package com.hp.onlinexam.po;

import java.sql.Timestamp;

public class Test {
	private int id;
	private String testName;
	private int courseId;
	private Timestamp endDate;
	private int testTime;
	private String questions;
	private int teacherId;
	private String classIds;
	private String scores;

	public Test(){
		
	}
	public Test(String testName,int courseId,Timestamp endDate,int testTime,String questions,String classIds,String scores){
		this.testName=testName;
		this.courseId=courseId;
		this.endDate=endDate;
		this.testTime=testTime;
		this.questions=questions;
		this.classIds=classIds;
		this.scores=scores;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getTestTime() {
		return testTime;
	}

	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}

	public String getQuestions() {
		return questions;
	}

	public void setQuestions(String questions) {
		this.questions = questions;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getClassIds() {
		return classIds;
	}

	public void setClassIds(String classIds) {
		this.classIds = classIds;
	}

	public String getScores() {
		return scores;
	}

	public void setScores(String scores) {
		this.scores = scores;
	}

}
