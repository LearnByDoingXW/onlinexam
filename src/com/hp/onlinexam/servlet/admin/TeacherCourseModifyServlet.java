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
import com.hp.onlinexam.vo.TeacherCourseView;

@WebServlet("/teacherCourseModifyServlet")
public class TeacherCourseModifyServlet extends HttpServlet {

	private ICourseService cour = new CourseService();
	private ITeacherService tea = new TeacherService();
	private IStuClassService stuc = new StuClassService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List courseList = cour.findAllCourses("");
		List teaList = tea.findTeachers("");
		List stuclList = stuc.findAll();
		List teacvList = cour.findAll();

		TeacherCourse teac = new TeacherCourse();
		String id = req.getParameter("id");

		teac = cour.findTeacherCourseById(Integer.valueOf(id));

		req.setAttribute("courList", courseList);
		req.setAttribute("teaList", teaList);
		req.setAttribute("stuclList", stuclList);
		req.setAttribute("tc", teac);

		req.getRequestDispatcher("manager/teachercoursemodify.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		String courseId = req.getParameter("course");
		String tId=req.getParameter("teacher");
		String classId=req.getParameter("stuclass");
		TeacherCourse teac1 = new TeacherCourse();
		teac1.setId(Integer.valueOf(id));
		teac1.setClassId(Integer.valueOf(classId));
		teac1.setCourseId(Integer.valueOf(courseId));
		teac1.settId(Integer.valueOf(tId));
		cour.modifyTeacherCourse(teac1);
		
		req.getRequestDispatcher("/teacherCourseQueryServlet").forward(req, resp);
	}

}
