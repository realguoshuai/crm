package com.zhiyou100.servlet.clientclassify;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.ClientClassifyService;
import com.zhiyou100.service.impl.ClientClassifyServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientClassifyService service = new ClientClassifyServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		long id =Long.parseLong(ids);
		
		service.deleteClientClassify(id);
//		request.getRequestDispatcher("/WEB-INF/jsp/client/client_classify/list.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/client/classify/list");
	}



}
