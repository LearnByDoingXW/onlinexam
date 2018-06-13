package com.hp.onlinexam.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.onlinexam.service.admin.IStuClassService;
import com.hp.onlinexam.service.admin.StuClassService;


@WebServlet("/stuClassQueryServlet")
/*
 * 用于查询班级信息
 * @author xu
 */
public class StuClassQueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IStuClassService scs=new StuClassService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * servlet职能
		 * 1，接受用户请求
		 * 2.从业务层获取结果
		 * 3.把结果封装并传递到页面
		 * 4.页面跳转
		 */
		List stuClassList=scs.findAll();
		/*
		 * 使用req.setAttribute 把结果放入页面
		 * 第一个参数是key 第二个参数是value
		 */
		req.setAttribute("scList", stuClassList);
		req.getRequestDispatcher("manager/stuclassmanage.jsp").forward(req,resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	doGet(req,resp);
	}

}
