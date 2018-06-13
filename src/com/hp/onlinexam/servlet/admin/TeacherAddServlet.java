package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/teacherAddServlet")
public class TeacherAddServlet extends HttpServlet{
    
	private ITeacherService teac=new TeacherService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("depList", Department.values());
		req.getRequestDispatcher("manager/teacheradd.jsp").forward(req, resp);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tName=req.getParameter("teaname");
		String tPwd=req.getParameter("tpwd");
		String deptName=req.getParameter("depInfo");
		Teacher tea=new Teacher();
		tea.setPwd(tPwd);
		tea.settName(tName);
		tea.settDeptName(deptName);
		
		teac.addTeacher(tea);
		
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
	}

}
