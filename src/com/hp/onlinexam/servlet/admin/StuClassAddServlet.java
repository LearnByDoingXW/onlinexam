package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Stuclass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

/**
 * 管理员模块：用于增加班级
 */
@WebServlet("/stuClassAddServlet")
public class StuClassAddServlet extends HttpServlet {

	private IStuClassService stu =new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 通过
		 */
		req.setAttribute("depList", Department.values());
		req.getRequestDispatcher("manager/stuclassadd.jsp").forward(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 获取请求参数
		 */
		
		String className=req.getParameter("classname");
		String depInfo=req.getParameter("depInfo");
		/*
		 * 把请求参数封装成对象
		 * 封装的目的是为了调用业务层的方法
		 */
		Stuclass sc=new Stuclass();
		sc.setClassName(className);
		sc.setDeptName(depInfo);
	    stu.addStuClass(sc);
	    
	    req.getRequestDispatcher("/stuClassQueryServlet").forward(req,resp);
	    
	}
	
   
}
