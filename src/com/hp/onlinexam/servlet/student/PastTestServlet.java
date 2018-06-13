package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.student.IPaperService;
import com.hp.onlinexam.service.student.PaperService;

@WebServlet("/pastTestServlet")
public class PastTestServlet extends HttpServlet {

	private IPaperService ps = new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String courseName = req.getParameter("courseSearch");
		
		if(null==courseName){
			
			courseName="";
		}

		Student student = (Student) req.getSession().getAttribute("user");

		List pList = ps.getPaperByStudentId(student.getStuId(), courseName);

		req.setAttribute("paperList", pList);

		req.getRequestDispatcher("student/history.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
