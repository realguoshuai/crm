package com.zhiyou100.servlet.department;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private DepartmentService service =new DepartmentServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idString =request.getParameter("id");
		long id = Long.parseLong(idString);
		DepartmentDo departmentById = service.getDepartmentById(id);
		//提取放入attribute之中
		request.setAttribute("department", departmentById);
		request.getRequestDispatcher("/WEB-INF/jsp/department/update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("=================进来没");
		String name=request.getParameter("departmentName");
		String description=request.getParameter("departmentDesc");
		System.out.println("----------"+name+description);
		String idString =request.getParameter("id");
		System.out.println("1111111111111"+idString);
		long id = Long.parseLong(idString);
		System.out.println("-----******-----"+id);
		service.updateDepartment(id, name, description);
		
		response.sendRedirect(request.getContextPath()+"/department/list");
	}

}
