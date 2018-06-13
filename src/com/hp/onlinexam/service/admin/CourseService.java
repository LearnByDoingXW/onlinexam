package com.hp.onlinexam.service.admin;

import java.util.List;

import com.hp.onlinexam.dao.admin.CourseDao;
import com.hp.onlinexam.dao.admin.ICourseDao;
import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseService implements ICourseService{

	private ICourseDao cour=new CourseDao();
	@Override
	public List<TeacherCourseView> findAll() {
		
		return cour.findAllTeaCourInfo();
	}


	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		// TODO Auto-generated method stub
		return cour.findTeacherCourseById(id);
	}



	@Override
	public Course findCourseById(int id) {
		
		return cour.findCourseById(id);
	}

	@Override
	public List<Course> findAllCourses(String name) {
		
		return cour.findAllCourses(name);
	}

	@Override
	public void modifyTeacherCourse(TeacherCourse tc) {
		cour.updateTeacherCourse(tc);
		
	}

	@Override
	public List<TeacherCourseView> findTeacherCourseByKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTeacherCourse(int tcId) {
		cour.deleteTourse(tcId);
		
	}

	@Override
	public void addCourse(String courseName) {
		
		cour.addCourse(courseName);
	}

	@Override
	public void updateCourse(Course course) {
		cour.updateCourse(course);
		
	}
    
	
	@Override
	public void deleteCourse(int cId) {
		cour.deleteCourseById(cId);
		
	}

	@Override
	public void addSchedule(TeacherCourse tc) {
		cour.addTeacherCourse(tc);
		
	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		
		return cour.findCoursesByTeacherId(teaId);
	}

}
