package com.zhiyou100.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.UserDo;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServlceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService service =new UserServlceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println("name = "+name +"password="+password);
		UserDo user = service.getUser(name);
		if (name.equals(user.getName())&&password.equals(user.getPassword())) {
			request.setAttribute("name",name);
			//localhost:8080/zycrm/index.jsp
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}else{
			System.out.println("++++++++++++++++++++");
			response.sendRedirect("http://localhost:8080/zycrm/login.jsp"); 
			return ;
		}
	}

}
