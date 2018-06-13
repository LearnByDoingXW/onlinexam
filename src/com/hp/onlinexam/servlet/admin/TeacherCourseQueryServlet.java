package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
@WebServlet("/teacherCourseQueryServlet")
public class TeacherCourseQueryServlet extends HttpServlet {
    ICourseService cour= new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List teacviewList=cour.findAll();
		req.setAttribute("teacList", teacviewList);
		req.getRequestDispatcher("manager/teachercoursemanage.jsp").forward(req, resp);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
