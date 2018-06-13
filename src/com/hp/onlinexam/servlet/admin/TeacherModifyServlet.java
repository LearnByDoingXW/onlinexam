package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;
import com.hp.onlinexam.util.Department;

@WebServlet("/teacherModifyServlet")
public class TeacherModifyServlet extends HttpServlet {
    
	ITeacherService tea=new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tId=req.getParameter("id");
		Map<String,Object> teaMap= tea.findTeacherInfo(Integer.valueOf(tId));
		req.setAttribute("teacher", teaMap);
		req.setAttribute("depList", Department.values());
		req.getRequestDispatcher("manager/teachermodify.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tId=req.getParameter("teaid");
		String tPwd=req.getParameter("tpwd");
		String tName=req.getParameter("tname");
		String deptName=req.getParameter("depInfo");
		Teacher t=new Teacher();
		t.settId(Integer.valueOf(tId));
		t.setPwd(tPwd);
		t.settName(tName);
		t.settDeptName(deptName);
		tea.updateTeacher(t,Integer.valueOf(tId));
		resp.sendRedirect(req.getContextPath()+"/teacherQueryServlet");
	}


}
