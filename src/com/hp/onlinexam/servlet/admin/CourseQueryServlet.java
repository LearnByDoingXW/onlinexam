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


@WebServlet("/courseQueryServlet")
public class CourseQueryServlet  extends HttpServlet{
    
	private ICourseService cou =new CourseService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cName=req.getParameter("coursename");
		if(null==cName){
			cName="";
		}
		//stuName=new String(stuName.getBytes("ISO-8859-1"),"utf-8");
		cName=new String(cName.getBytes("ISO-8859-1"),"utf-8");
		List cList= cou.findAllCourses(cName);
		req.setAttribute("cList", cList);
		req.getRequestDispatcher("manager/coursemanage.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
   
}
