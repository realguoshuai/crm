package com.zhiyou100.servlet.clientstatus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.ClientClassifyService;
import com.zhiyou100.service.ClientStatusService;
import com.zhiyou100.service.impl.ClientClassifyServiceImpl;
import com.zhiyou100.service.impl.ClientStatusServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientStatusService service = new ClientStatusServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_from/add.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		System.out.println("name"+name+description);
		
		service.addClientStatus(name, description);
		response.sendRedirect(request.getContextPath() + "/client/status/list");
	}

}
