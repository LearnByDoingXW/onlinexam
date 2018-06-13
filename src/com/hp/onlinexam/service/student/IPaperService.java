package com.hp.onlinexam.service.student;

import java.util.List;

import com.hp.onlinexam.po.Papers;

public interface IPaperService { 
	
	public int save(Papers paper);
	/**
	 * 学生试题
	 * @return
	 */
	public List getPaperByStudentId(int studentId,int testId);
	
	/**
	 * 学生以往答过的试卷
	 * @return
	 */
	public List getPaperByStudentId(int studentId,String cName);
	
	/**
	 * 获得班级评估信息
	 * @return
	 */
	public List getPaperCompare(int teaId);
}
