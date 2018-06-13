package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.util.DBUtil;

public class StudentDao implements IStudentDao {
   
	DBUtil db=new DBUtil();
	@Override
	public void addStudent(Student s) {
		String sql="insert into student(stuName,pwd,school,stuDeptName,sex,born,classId) values(?,?,?,?,?,?,?)";
		try {
			db.execute(sql, new Object[]{s.getStuName(),s.getPwd(),s.getSchool(),s.getStuDeptName(),s.getSex(),s.getBorn(),s.getClassId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStudent(Student s) {
		String sql="update student set stuName=?,pwd=?,school=?,stuDeptName=?,sex=?,born=?,classId=? where stuId=?";
		try {
			db.execute(sql, new Object[]{s.getStuName(),s.getPwd(),s.getSchool(),s.getStuDeptName(),s.getSex(),s.getBorn(),s.getClassId(),s.getStuId()});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	
	@Override
	public void deleteStudentById(int id) {
		String sql="delete from student where stuId=?";
		try {
			db.execute(sql, new Object[]{id});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Student findStudentById(int id) {
		String sql="select * from student where stuId=?";
		Student student=new Student(); 
		try {
			student=(Student)db.getObject(Student.class, sql, new Object[]{id});
		} catch (Exception e) {
			student=new Student(); 
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Map<String, Object>> findAll(String name) {
		String sql="select s.*,sc.className,sc.deptName from student s,stuclass sc WHERE  sc.id=s.classId";
		if(!"".equals(name)){
			sql+= " and s.stuName like '%"+ name +"%'";
		}
		List stuList=new ArrayList();
		try {
			stuList=db.getQueryList(sql);
		} catch (Exception e) {
			stuList=new ArrayList();
			e.printStackTrace();
		}
		return stuList;
	}

}
