package com.hp.onlinexam.service.admin;

import java.util.List;
import java.util.Map;

import com.hp.onlinexam.dao.admin.ITeacherDao;
import com.hp.onlinexam.dao.admin.TeacherDao;
import com.hp.onlinexam.po.Teacher;

public class TeacherService implements ITeacherService{
	private ITeacherDao tec=new TeacherDao();

	@Override
	public List<Teacher> findTeachers(String name) {
		
		return tec.findAllTeacherByInfo(name);
	}

	@Override
	public void addTeacher(Teacher teacher) {
		tec.addTeacher(teacher);
		
	}

	@Override
	public void updateTeacher(Teacher teacher, int oldid) {
		
		tec.updateTeacher(teacher, oldid);
	}
    
	
	@Override
	public void deleteTeacher(int tId) {
		tec.deleteTeacherById(tId);
		
	}

	@Override
	public Map<String, Object> findTeacherInfo(int id) {
		// TODO Auto-generated method stub
		return tec.findTeacherInfo(id);
	}

	@Override
	public List<Map<String, Object>> findClassesByTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}
   
	
}
