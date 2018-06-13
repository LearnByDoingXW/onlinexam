package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/testDeleteServlet")
public class TestDeleteServlet extends HttpServlet {
    
	private ITestService ts=new TestService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String id=req.getParameter("id");
	   ts.deleteTest(Integer.valueOf(id));
	   resp.sendRedirect(req.getContextPath()+"/testQueryServlet");
	}

}
