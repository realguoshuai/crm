package com.zhiyou100.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.RoleDo;
import com.zhiyou100.entity.UserDo;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.UserServlceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServlceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("==================跳转啦");
		String idString =request.getParameter("id");
		long id = Long.parseLong(idString);
		System.out.println("-----------------"+id);
		UserDo userById = service.getUserById(id);
		request.setAttribute("list", userById);
		request.getRequestDispatcher("/WEB-INF/jsp/user/update.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入到了dopost");
		String idString = request.getParameter("id");
		long id =Long.parseLong(idString);
		String name =request.getParameter("name");
		String password =request.getParameter("password");
		String departmentString =request.getParameter("departmentId");
		int departmentId =Integer.parseInt(departmentString);
		String roleString =request.getParameter("roleId");
		int roleId = Integer.parseInt(roleString);
		String gender =request.getParameter("gender");
		String phone =request.getParameter("phone");
		String email =request.getParameter("email");
		String description =request.getParameter("description");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&"+id+email+description);
		service.updateUser(id, name, password, gender, phone, email, departmentId, roleId, description);
		response.sendRedirect(request.getContextPath()+"/user/list");
	}

}
