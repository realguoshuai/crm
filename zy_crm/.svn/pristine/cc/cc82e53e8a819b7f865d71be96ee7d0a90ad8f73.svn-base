package com.zhiyou100.servlet.role;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService service = new RoleServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ids = request.getParameter("id");
		long id =Long.parseLong(ids);
		System.out.println("进DELETE来了"+id);
		service.deleteRole(id);
		response.sendRedirect(request.getContextPath()+"/role/list");
	}

}
