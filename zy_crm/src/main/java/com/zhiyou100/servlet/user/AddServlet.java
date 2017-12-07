package com.zhiyou100.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.entity.RoleDo;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;
import com.zhiyou100.service.impl.RoleServiceImpl;
import com.zhiyou100.service.impl.UserServlceImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServlceImpl();   
	
	private DepartmentService serviceDeprtment = new DepartmentServiceImpl();
	private RoleService serviceRole = new RoleServiceImpl();
 @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	List<DepartmentDo> listDepartment = serviceDeprtment.listDepartment();
		request.setAttribute("departmentList", listDepartment);

		List<RoleDo> listRole = serviceRole.listRole();
		request.setAttribute("roleList", listRole);
		request.getRequestDispatcher("/WEB-INF/jsp/user/add.jsp").forward(request, response);
		
}
 

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		service.addUser(name, password, gender, phone, email, departmentId, roleId, description);
		response.sendRedirect(request.getContextPath()+"/user/list");
	}

}
