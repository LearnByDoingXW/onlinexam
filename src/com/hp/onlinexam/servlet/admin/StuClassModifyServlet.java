package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Stuclass;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.util.Department;

@WebServlet("/stuClassModifyServlet")
public class StuClassModifyServlet extends HttpServlet {
    /*
     *  获取当前对象，把当前对象送到要跳转的页面
     *  页面跳转
     */
	private IStuClassService scs=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String id =req.getParameter("id");
	   
	   Map<String,Object> stuMap=scs.findStuClassById(Integer.valueOf(id));
	   req.setAttribute("stuClass",stuMap );
	   req.setAttribute("depList", Department.values());
	   req.getRequestDispatcher("/manager/stuclassmodify.jsp").forward(req,resp);
	   
	}
    
	/*
	 * 
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String classId=req.getParameter("classId");
		//System.out.println(classId);f
		String className=req.getParameter("classname");
		String deptName=req.getParameter("depInfo");
		Stuclass sc=new Stuclass();
		sc.setId(Integer.valueOf(classId));
		sc.setClassName(className);
		sc.setDeptName(deptName);
		scs.updateStuClass(sc);
		
		req.getRequestDispatcher("/stuClassQueryServlet").forward(req,resp);
		
	}

}
