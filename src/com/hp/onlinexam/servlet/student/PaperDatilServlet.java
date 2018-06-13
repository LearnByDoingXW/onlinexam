package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;

@WebServlet("/paperDatilServlet")
public class PaperDatilServlet extends HttpServlet{
    
	private ITestService ts=new TestService();
	private IQuestionService qs=new QuestionService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tId=req.getParameter("id");
		
		Map testMap=ts.findTestBytId(Integer.valueOf(tId));
		String ids=(String)testMap.get("questions");
		List qList=qs.findQuestionByIds(ids);
		
		req.setAttribute("test", testMap);
		req.setAttribute("quesList", qList);
		req.getRequestDispatcher("/student/viewpaper.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
