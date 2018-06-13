package com.hp.onlinexam.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;

@WebServlet("/stuClassDeleteServlet")
public class StuClassDeleteServlet extends HttpServlet {
    
	private IStuClassService stu=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		stu.deleteStuClass(Integer.valueOf(id));
		
		 req.getRequestDispatcher("/stuClassQueryServlet").forward(req,resp);
	}

}
