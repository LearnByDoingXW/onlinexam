package com.hp.onlinexam.dao.login;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.util.DBUtil;

public class LoginDao implements ILoginDao {
    
	private DBUtil db=new DBUtil();
	@Override
	public Teacher canLogin(Teacher t) {
		String sql="select * from teacher where tName=? and pwd=?";
		Teacher tea=new Teacher();
		try {
			tea=(Teacher)db.getObject(Teacher.class,sql, new Object[]{t.gettName(),t.getPwd()});
		} catch (Exception e) {
			tea=null;
			e.printStackTrace();
		}
		return tea;
	}

	@Override
	public Student canLogin(Student s) {
		String sql="select * from student where stuName=? and pwd=?";
		Student stu=new Student();
		try {
			stu=(Student) db.getObject(Student.class, sql, new Object[]{s.getStuName(),s.getPwd()});
		} catch (Exception e) {
			stu=null;
			e.printStackTrace();
		}
		return stu;
	}

}
