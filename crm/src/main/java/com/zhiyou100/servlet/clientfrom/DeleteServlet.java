package com.zhiyou100.servlet.clientfrom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.ClientFromService;
import com.zhiyou100.service.impl.ClientFromServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientFromService service =new ClientFromServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		long id =Long.parseLong(ids);
		service.deleteClientFrom(id);
		response.sendRedirect(request.getContextPath() + "/client/from/list");
	}


}
