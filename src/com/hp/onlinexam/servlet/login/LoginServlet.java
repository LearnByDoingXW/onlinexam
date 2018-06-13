package com.hp.onlinexam.servlet.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.po.Student;
import com.hp.onlinexam.po.Teacher;
import com.hp.onlinexam.service.login.ILoginService;
import com.hp.onlinexam.service.login.LoginService;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private ILoginService los=new LoginService();
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userName=req.getParameter("username");
		String passWord=req.getParameter("password");
		String role=req.getParameter("role");
		
		if("xu".equals(userName)&&"123".equals(passWord)&&"admin".equals(role)){
       
			req.getSession().setAttribute("user", "xu");
			req.getRequestDispatcher("/manager/mindex.jsp").forward(req, res);
			
		}
		else if("teacher".equals(role)){
			Teacher tea=new Teacher();
			tea.settName(userName);
			tea.setPwd(passWord);
			tea=los.canLogin(tea);
			if(null!=tea){
				req.getSession().setAttribute("user",tea );
				req.getRequestDispatcher("/teacher/tindex.jsp").forward(req, res);
			}
		}
		else if("student".equals(role)){
			Student s=new Student();
			s.setStuName(userName);
		    s.setPwd(passWord);
		    s=los.canLogin(s);
		    if(null!=s){
		    	req.getSession().setAttribute("user", s);
		    	req.getRequestDispatcher("/student/index.jsp").forward(req, res);
		    }
		}
		
	}

}
