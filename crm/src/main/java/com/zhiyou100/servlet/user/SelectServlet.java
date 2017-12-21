package com.zhiyou100.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.UserDo;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServlceImpl;

/**
 * Servlet implementation class SelectServlet
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServlceImpl();
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("进到搜索 dopost中");
	String keyword = request.getParameter("keyword");
	System.out.println("^^^^^^"+keyword);
	String column =request.getParameter("searchField");
	System.out.println("********"+column);
	List<UserDo> listUser = service.listUser(column,keyword);
	
	 request.setAttribute("list", listUser);
	request.getRequestDispatcher("/WEB-INF/jsp/user/list.jsp").forward(request, response);
	
}
}
