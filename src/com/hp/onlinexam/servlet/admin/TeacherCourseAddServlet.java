package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.TeacherCourse;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherCourseAddServlet")
public class TeacherCourseAddServlet extends HttpServlet{
    private ICourseService cour=new CourseService();
    private ITeacherService tea=new TeacherService();
    private IStuClassService stuc=new StuClassService(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List courseList=cour.findAllCourses("");
		List teaList=tea.findTeachers("");
		List stuclList=stuc.findAll();
		req.setAttribute("courseList", courseList);
		req.setAttribute("teaList", teaList);
		req.setAttribute("stuclList", stuclList);
		req.getRequestDispatcher("manager/teachercourseadd.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String courseId=req.getParameter("course");
		String tId=req.getParameter("teacher");
		String classId=req.getParameter("stuclass");
		
		TeacherCourse teac = new TeacherCourse();
		teac.setClassId(Integer.valueOf(classId));
		teac.setCourseId(Integer.valueOf(courseId));
		teac.settId(Integer.valueOf(tId));
		
		cour.addSchedule(teac);
		req.getRequestDispatcher("/teacherCourseQueryServlet").forward(req,resp);
	}

}
