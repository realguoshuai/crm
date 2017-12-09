package com.zhiyou100.servlet.Information;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;

/**
 * Servlet implementation class ServletDepartment
 */
public class ServletDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DepartmentService service = new DepartmentServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DepartmentDo> listDepartment = service.listDepartment();
		request.setAttribute("listDepartment",listDepartment);
		request.getRequestDispatcher("/WEB-INF/jsp/inside_info/depart_list.jsp").forward(request, response);
	}


}
