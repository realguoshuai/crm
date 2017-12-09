package com.zhiyou100.servlet.clientstatus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.ClientStatusService;
import com.zhiyou100.service.impl.ClientStatusServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientStatusService service = new ClientStatusServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		long id =Long.parseLong(ids);
		service.deleteClientStatus(id);
		response.sendRedirect(request.getContextPath() + "/client/status/list");
	}

	

}
