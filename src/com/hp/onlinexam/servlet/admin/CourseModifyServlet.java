package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;

@WebServlet("/courseModifyServlet")
public class CourseModifyServlet extends HttpServlet {
    
	private ICourseService cou=new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cId=req.getParameter("id");
		Course c=new Course();
		c=cou.findCourseById(Integer.valueOf(cId));
		req.setAttribute("course",c);
		req.getRequestDispatcher("manager/coursemodify.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cId=req.getParameter("courseid"); 
		String cName=req.getParameter("courname");
		 Course c=new Course();
		 c.setcId(Integer.valueOf(cId));
		 c.setcName(cName);
		 cou.updateCourse(c);
		 resp.sendRedirect(req.getContextPath()+"/courseQueryServlet");
		 
	}

}
