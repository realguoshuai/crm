package com.zhiyou100.servlet.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService service = new RoleServiceImpl();
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/jsp/role/add.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("这里是add 的doPOST");
		//1,取出数据
		String name=request.getParameter("roleName");
		String description=request.getParameter("roleDesc");
		//2,存入数据库
		service.addRole(name, description);
		
		//3,跳转到list.jsp--->重定向发送 role/list到listServlet
		response.sendRedirect(request.getContextPath() + "/role/list");
	}
}
