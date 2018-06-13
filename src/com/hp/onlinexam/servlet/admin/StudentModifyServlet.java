package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

@WebServlet("/studentModifyServlet")
public class StudentModifyServlet extends HttpServlet {
    private IStudentService stud=new StudentService();
    private IStuClassService stuc=new StuClassService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studId=req.getParameter("id");
		Student stu1=new Student();
		stu1=stud.findStudentById(Integer.valueOf(studId));
		
		List classList=stuc.findAll();
		req.setAttribute("student", stu1);
		req.setAttribute("classList", classList);
		req.setAttribute("deptList",Department.values());
		req.getRequestDispatcher("manager/studentmodify.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stuId=req.getParameter("id");
		String stuName=req.getParameter("name");
		String stuPwd=req.getParameter("pwd");
		String sex=req.getParameter("sex");
		String born=req.getParameter("born");
		String school=req.getParameter("school");
		String classId=req.getParameter("classId");
		String stuDeptName=req.getParameter("deptName");
		
		Student stu2=new Student();
		stu2.setStuId(Integer.valueOf(stuId));
		stu2.setStuName(stuName);
		stu2.setPwd(stuPwd);
		stu2.setSex(sex);
		stu2.setBorn(born);
		stu2.setSchool(school);
		stu2.setClassId(Integer.valueOf(classId));
		stu2.setStuDeptName(stuDeptName);
		
		stud.updateStudent(stu2);
		resp.sendRedirect(req.getContextPath()+"/studentQueryServlet");
	}

}
