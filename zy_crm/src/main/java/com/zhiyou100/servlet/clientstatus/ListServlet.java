package com.zhiyou100.servlet.clientstatus;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.ClientStatusDo;
import com.zhiyou100.service.ClientStatusService;
import com.zhiyou100.service.impl.ClientStatusServiceImpl;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientStatusService service = new ClientStatusServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ClientStatusDo> listClientStatus = service.listClientStatus();
		request.setAttribute("list", listClientStatus);
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_status/list.jsp").forward(request, response);
	
	}



}
