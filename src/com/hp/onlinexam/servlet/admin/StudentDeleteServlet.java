package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StudentService;

@WebServlet("/studentDeleteServlet")
public class StudentDeleteServlet  extends HttpServlet{
    private IStudentService stud=new StudentService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sId=req.getParameter("id");
		stud.deleteStudent(Integer.valueOf(sId));
		req.getRequestDispatcher("/studentQueryServlet").forward(req, resp);
	}

}
