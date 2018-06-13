package com.hp.onlinexam.dao.admin;

import java.util.ArrayList;
import java.util.List;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.util.DBUtil;
import com.hp.onlinexam.vo.TeacherCourseView;

public class CourseDao implements ICourseDao {

	DBUtil db = new DBUtil();

	@Override
	public List<TeacherCourseView> findAllTeaCourInfo() {
		String sql = "SELECT tc.id tcId,tc.courseId tcCourseId,tc.tId tcTeaId,tc.classId tcClassId, t.tId teacherId,t.tName teacherName,stu.id stuclassId, stu.className stuclassName,stu.deptName departmentName,c.cId courseId ,c.cName courseName from teachercourse tc,teacher t,course c,stuclass stu WHERE t.tId=tc.tId and c.cId=tc.courseId and stu.id=tc.classId";
		List teacList = new ArrayList();
		try {
			teacList = db.getQueryList(TeacherCourseView.class, sql, new Object[] {});
		} catch (Exception e) {
			teacList = new ArrayList();
			e.printStackTrace();
		}
		return teacList;
	}

	@Override
	public Course findCourseByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeacherCourse findTeacherCourseById(int id) {
		String sql = "Select * from teachercourse where id=?";
		TeacherCourse teac = new TeacherCourse();
		try {
			teac = (TeacherCourse) db.getObject(TeacherCourse.class, sql, new Object[] { id });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teac;
	}

	@Override
	public void addCourse(String name) {
		String sql = "insert into course(cName) values(?)";
		try {
			db.execute(sql, new Object[] { name });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateCourse(Course course) {
		String sql = "update course set cName=? where cId=?";
		try {
			db.execute(sql, new Object[] { course.getcName(), course.getcId() });
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteCourseById(int id) {
		String sql = "delete from course where cId=?";
		try {
			db.execute(sql, new Object[] { id });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Course findCourseById(int id) {
		String sql = "select * from course where cId=?";
		Course cou = new Course();
		try {
			cou = (Course) db.getObject(Course.class, sql, new Object[] { id });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cou;
	}

	@Override
	public void addTeacherCourse(TeacherCourse tc) {

		String sql = "insert into teachercourse(courseId,tId,classId) values(?,?,?)";
		try {
			db.execute(sql, new Object[] { tc.getCourseId(), tc.gettId(), tc.getClassId() });
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public TeacherCourseView findTeaCourInfoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAllCourses(String name) {
		String sql = "select * from course";
		if (!"".equals(name)) {
			sql += " where cName like '%" + name + "%'";
		}
		List cList = new ArrayList();
		try {
			cList = db.getQueryList(sql);
		} catch (Exception e) {
			cList = new ArrayList();
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<Course> findAllCoursesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExitByAllIds(TeacherCourse tc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateTeacherCourse(TeacherCourse tc) {

		String sql = "update teachercourse set courseId=?,tId=?,classId=? where id=?";
		try {
			db.execute(sql, new Object[] { tc.getCourseId(), tc.gettId(), tc.getClassId(), tc.getId() });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TeacherCourseView> findTeaCourInfoByCourseKey(String courseKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTourse(int tcId) {
		String sql = "delete from teachercourse where id=?";
		try {
			db.execute(sql, new Object[] { tcId });
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Course> findCoursesByTeacherId(int teaId) {
		String sql = "SELECT * from course where cId in (select courseId from teachercourse where tId = ?)";
		List courseList = new ArrayList();
		try {
			courseList = db.getQueryList(Course.class, sql, new Object[] { teaId });
		} catch (Exception e) {
			courseList = new ArrayList();
			e.printStackTrace();
		}
		return courseList;
	}

}
