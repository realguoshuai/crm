package com.zhiyou100.servlet.department;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;

public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service = new DepartmentServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DepartmentDo> listDepartment = service.listDepartment();
		request.setAttribute("listDepartment",listDepartment);
		request.getRequestDispatcher("/WEB-INF/jsp/department/list.jsp").forward(request, response);
	}


}
