package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/testCreateServlet")
public class TestCreateServlet extends HttpServlet {
    
	private ITestService ts=new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Teacher t=(Teacher)req.getSession().getAttribute("user");
		Test test=(Test)req.getSession().getAttribute("test");
		test.setTeacherId(t.gettId());
		ts.createTest(test);
		req.getSession().removeAttribute("test");
		req.getRequestDispatcher("/testQueryServlet").forward(req, resp);
	}
   
}
