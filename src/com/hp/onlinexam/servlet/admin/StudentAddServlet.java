package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.IStudentService;
import com.hp.onlinexam.service.admin.StuClassService;
import com.hp.onlinexam.service.admin.StudentService;
import com.hp.onlinexam.util.Department;

@WebServlet("/studentAddServlet")
public class StudentAddServlet  extends HttpServlet{
    private IStuClassService stu=new StuClassService();
    private IStudentService stud=new StudentService();
    private Student sd=new Student();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    List classList=stu.findAll();
		req.setAttribute("deptList",Department.values() );
		req.setAttribute("classList", classList);
		req.getRequestDispatcher("manager/studentadd.jsp").forward(req, resp);;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sId=req.getParameter("id");
		String stuName=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		String sex=req.getParameter("sex");
		String born=req.getParameter("born");
		String school=req.getParameter("school");
		String stuDeptName=req.getParameter("deptName");
		String classId=req.getParameter("classId");
		sd.setStuId(Integer.valueOf(sId));
		sd.setStuName(stuName);
		sd.setBorn(born);
		sd.setPwd(pwd);
		sd.setSex(sex);
		sd.setSchool(school);
		sd.setStuDeptName(stuDeptName);
		sd.setClassId(Integer.valueOf(classId));
		stud.addStudent(sd);
		resp.sendRedirect(req.getContextPath()+"/studentQueryServlet");
	}

}
