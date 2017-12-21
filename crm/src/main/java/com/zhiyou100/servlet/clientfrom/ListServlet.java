package com.zhiyou100.servlet.clientfrom;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.ClientFromDo;
import com.zhiyou100.service.ClientFromService;
import com.zhiyou100.service.impl.ClientFromServiceImpl;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientFromService service =new ClientFromServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ClientFromDo> listClientFrom = service.listClientFrom();
		request.setAttribute("list", listClientFrom);
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_from/list.jsp").forward(request, response);

		
	}
	}

