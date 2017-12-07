package com.zhiyou100.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private DepartmentService service = new DepartmentServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString = request.getParameter("id");
		long id =Long.parseLong(idString);
		System.out.println("哈哈哈哈"+id);
		service.deleteDepartment(id);
	response.sendRedirect(request.getContextPath()+"/department/list");
	}

	

}
