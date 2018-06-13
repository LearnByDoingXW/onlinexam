package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/testQueryServlet")
public class TestQueryServlet extends HttpServlet {
    private ITestService ts=new TestService(); 
	
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	Teacher t=(Teacher)req.getSession().getAttribute("user");
    	List testList=ts.findTestsByTeaId(t.gettId());
    	req.setAttribute("testList", testList);
		req.getRequestDispatcher("teacher/tmain.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
   
}
