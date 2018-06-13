package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/teacherCourseDeleteServlet")
public class TeacherCourseDeleteServlet extends HttpServlet {
    
	private ICourseService cour=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tcId=req.getParameter("id");
		cour.deleteTeacherCourse(Integer.valueOf(tcId));
		
		req.getRequestDispatcher("/teacherCourseQueryServlet").forward(req, resp);
	}
	

}
