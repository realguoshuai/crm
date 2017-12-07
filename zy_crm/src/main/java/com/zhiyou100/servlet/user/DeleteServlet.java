package com.zhiyou100.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServlceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServlceImpl();
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String idString =request.getParameter("id");
	long id =Long.parseLong(idString);
	service.deleteUser(id);
	response.sendRedirect(request.getContextPath()+"/user/list");
	
	}


}
