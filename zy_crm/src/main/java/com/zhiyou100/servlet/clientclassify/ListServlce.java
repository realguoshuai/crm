package com.zhiyou100.servlet.clientclassify;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.service.ClientClassifyService;
import com.zhiyou100.service.impl.ClientClassifyServiceImpl;

/**
 * Servlet implementation class ListServlce
 */
public class ListServlce extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClientClassifyService service = new ClientClassifyServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ClientClassifyDo> listClientClassify = service.listClientClassify();
		request.setAttribute("list", listClientClassify);
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_classify/list.jsp").forward(request, response);
	}

}
