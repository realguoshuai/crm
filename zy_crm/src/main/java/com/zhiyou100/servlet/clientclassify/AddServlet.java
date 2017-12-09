package com.zhiyou100.servlet.clientclassify;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.ClientClassifyService;
import com.zhiyou100.service.impl.ClientClassifyServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientClassifyService service = new ClientClassifyServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_classify/add.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		System.out.println("name"+name+description);
		//2,存入数据库
		service.addClientClassify(name, description);
		
		//3,跳转到list.jsp--->重定向发送 role/list到listServlet
		response.sendRedirect(request.getContextPath() + "/client/classify/list");
	}

}
