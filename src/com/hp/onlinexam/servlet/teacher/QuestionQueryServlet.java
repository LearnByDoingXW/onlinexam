package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;

@WebServlet("/questionQueryServlet")
public class QuestionQueryServlet extends HttpServlet{
    private IQuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key=req.getParameter("selectk");
		String value=req.getParameter("searchName");
		if(null!=value){
			value= new String(value.getBytes("ISO-8859-1"),"utf-8");
		}
		List<Map<String,Object>> qList=qs.findAll(key,value);
		
		req.setAttribute("queList", qList);
		req.getRequestDispatcher("teacher/questionmanage.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
