package com.hp.onlinexam.servlet.student;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Papers;
import com.hp.onlinexam.po.Questions;
import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.student.IPaperService;
import com.hp.onlinexam.service.student.PaperService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.ITestService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.service.teacher.TestService;
import com.hp.onlinexam.util.ToolUtil;

@WebServlet("/studentTest")
public class StudentTest extends HttpServlet {

	private ITestService ts = new TestService();
	private IQuestionService qs = new QuestionService();
	private IPaperService ps=new PaperService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String testId = req.getParameter("testId");
		Student s = (Student) req.getSession().getAttribute("user");
		Map testMap = ts.findStudentTestsById(s.getStuId(), Integer.valueOf(testId));
		String ids = (String) testMap.get("questions");
		List qList = qs.findQuestionByIds(ids);
		req.getSession().setAttribute("test", testMap);
		req.getSession().setAttribute("quesList", qList);

		/**
		 * 1.testMap.get("scores")取出来是一个object类型的对象，需要强制转换成String (String)
		 * (testMap.get("scores")) 2.需要把String类型的转换成int类型的，所以使用Integer.parseInt
		 * 3.因为试题的总分和试题数量不一定能整除，因此可能会有小数出现。 在java里面，/是取整
		 */

		req.setAttribute("scoreperques", 1.0 * Integer.parseInt((String) (testMap.get("scores"))) / qList.size());

		req.getRequestDispatcher("student/exam.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String time = req.getParameter("hidden1");
		Map testMap = (Map) req.getSession().getAttribute("test");
		List qList = (List) req.getSession().getAttribute("quesList");
		Student s = (Student) req.getSession().getAttribute("user");
		Papers p = new Papers();

		if (null == qList || qList.size() < 1)
			return;

		StringBuffer wrongQueId = new StringBuffer();
		StringBuffer wrongAns = new StringBuffer();

		// 目的是遍历试卷中的试题的集合
		int wrongQueNum = 0;
		for (int i = 0; i < qList.size(); i++) {
			Questions q = (Questions) qList.get(i);
			// 页面接收的答案
			String ans = req.getParameter("ques_" + q.getId()).toUpperCase();
			// 如果和标准答案不匹配，则记录错误的题号和错误答案
			if (!q.getAns().equals(ans)) {
				wrongQueId.append(q.getId()).append(",");
				wrongAns.append(ans).append(",");
				wrongQueNum++;
			}
		}
       
		// 获得试题的总分和错误试题的数量
		if (qList.size() > wrongQueNum)
			p.setScore(1.0 * Integer.parseInt((String) (testMap.get("scores"))) / qList.size()* (qList.size() - wrongQueNum));
		else
			p.setScore(0);
		/**
		 * 如果做的全对，那么wrongQueId和wrongAns，都是空 如果有错题，那么多带了一个逗号
		 */
		
		String wrongQueIdString = wrongQueId.toString();
		String wrongAnsString = wrongAns.toString();
		
		if (wrongQueIdString.endsWith(",")) {
			wrongQueIdString = wrongQueIdString.substring(0, wrongQueIdString.length() - 1);
			wrongAnsString = wrongAnsString.substring(0, wrongAnsString.length() - 1);
		}
      
		
		String creatDate = ToolUtil.getCurrentTime();
		p.setTime(time);
		p.setTestId((int) testMap.get("id"));
		p.setCourseId((int) testMap.get("cId"));
		p.setStudentId(s.getStuId());
		p.setCreatDate(creatDate);
		p.setWrongQueId(wrongQueIdString);
		p.setWrongAns(wrongAnsString);
		
		ps.save(p);
		
		resp.sendRedirect(req.getContextPath()+"/student/index.jsp");
		
	}

}
