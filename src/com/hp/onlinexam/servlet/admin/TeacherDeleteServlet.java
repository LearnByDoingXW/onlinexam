package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.ITeacherService;
import com.hp.onlinexam.service.admin.TeacherService;

@WebServlet("/teacherDeleteServlet")
public class TeacherDeleteServlet extends HttpServlet{
    private ITeacherService tea=new TeacherService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tId=req.getParameter("id");
		tea.deleteTeacher(Integer.valueOf(tId));
		req.getRequestDispatcher("/teacherQueryServlet").forward(req,resp);
	}

}
