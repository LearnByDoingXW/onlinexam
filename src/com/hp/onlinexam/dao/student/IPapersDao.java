package com.hp.onlinexam.dao.student;

import java.util.List;

import com.hp.onlinexam.po.Papers;

public interface IPapersDao {
	
	public int save(Papers  paper);
	
	public List getPaperByStudentId(int studentId,int testId);
	
	public List getPaperByStudentId(int studentId,String cName);
	
	//所有的班级平级成绩。
	public List getPaperCompare(int teaId);
}
