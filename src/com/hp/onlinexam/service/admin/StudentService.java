package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.IStudentDao;
import com.hp.onlinexam.dao.admin.StudentDao;
import com.hp.onlinexam.po.Student;

public class StudentService  implements IStudentService{

	IStudentDao stud=new StudentDao();
	@Override
	public void addStudent(Student s) {
		stud.addStudent(s);
		
	}

	@Override
	public void updateStudent(Student s) {
		  stud.updateStudent(s);
		
	}
     
	@Override
	public void deleteStudent(int id) {
		stud.deleteStudentById(id);
		
	}

	@Override
	public Student findStudentById(int id) {
		
		return stud.findStudentById(id);
	}

	@Override
	public List<Map<String, Object>> findAll(String name) {
		// TODO Auto-generated method stub
		return stud.findAll(name);
	}

}
