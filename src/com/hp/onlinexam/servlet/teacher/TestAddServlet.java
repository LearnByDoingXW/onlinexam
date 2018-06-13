package com.hp.onlinexam.servlet.teacher;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Course;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.po.Test;
import com.hp.onlinexam.service.admin.CourseService;
import com.hp.onlinexam.service.admin.ICourseService;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.teacher.IQuestionService;
import com.hp.onlinexam.service.teacher.QuestionService;
import com.hp.onlinexam.util.ToolUtil;

@WebServlet("/testAddServlet")

public class TestAddServlet extends HttpServlet {
	
	private ICourseService cs = new CourseService();
	private IStuClassService stus=new StuClassService();
	private IQuestionService qs=new QuestionService();
    private IStuClassService ss=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * 登录过程中用session保存登录对象
		 * req.getSession().setAttribute("user",tea );
		 * 
		 *servlet 用req.getSession().getAttribute("user")获取
		 */
		Teacher t=(Teacher) req.getSession().getAttribute("user");
		
		List csList = cs.findCoursesByTeacherId(t.gettId());
		List classList = stus.findStuClassesByTeacherId(t.gettId());
		req.setAttribute("courseList", csList);
		req.setAttribute("classesList", classList);
		req.getRequestDispatcher("teacher/testadd.jsp").forward(req, resp);
	}
	/*
	 *组卷
	 *1.从试卷上获取基本信息，把基本信息送到下个页面
	 *2.获取试卷题目相关信息，随机抽题组卷，把试题传到下一个页面
	 *3.页面跳转
	 *
	 */

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId=req.getParameter("courseid");
        String testName = req.getParameter("testname");
        String testTime=req.getParameter("testtime");
        String endDate=req.getParameter("enddate");
        String scores=req.getParameter("sinscores");
        
        String sinNum=req.getParameter("sinnum");
        /*
         * 页面是复选框 通过getParameterValues来获取值  
         * 获取的值是数组类型
         * 
         */
        String[] classCheck=req.getParameterValues("classCheck");
        
        Teacher t2=(Teacher) req.getSession().getAttribute("user");
        int  teacherId=t2.gettId();
        
        /*
         * 目的是为了封装test对象，然后输入页面
         * 1.日期格式转换  String 类型转换出成Timestamp
         * 2.班级id需要格式转换 String数组转换成String
         * 3.根据试卷基本信息提供的试题数量随机出题（集合），并拿到题号组成的数据
         */
        
//        SimpleDateFormat sdf=new SimpleDateFormat();
//        Date date=new Date();
//        try{
//        	date=sdf.parse(endDate);
//        } catch (ParseException e) {
//        	 date=new Date();
//        	e.printStackTrace();
//        }
        
        String classIds=ToolUtil.arraytoString(classCheck);
        
        List<Map<String,Object>> queList=qs.collectQuestions(Integer.valueOf(courseId), Integer.valueOf(sinNum));
        
        String questionIds=qs.testQuestionIds(queList);
        
        String classNames=ss.findClassNamesByIds(classIds);
        
        Test t= new Test(testName,Integer.valueOf(courseId),Timestamp.valueOf(endDate),Integer.valueOf(testTime),questionIds,classIds,scores);
        
       Course c= cs.findCourseById(Integer.valueOf(courseId));
        req.setAttribute("c", c);
        req.setAttribute("classNames",classNames );
        req.setAttribute("test", t);
        req.setAttribute("quesList", queList);
        req.getSession().setAttribute("test", t);
        req.getRequestDispatcher("teacher/test.jsp").forward(req, resp);
	}

}
