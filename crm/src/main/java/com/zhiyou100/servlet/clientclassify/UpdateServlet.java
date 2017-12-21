package com.zhiyou100.servlet.clientclassify;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.service.ClientClassifyService;
import com.zhiyou100.service.impl.ClientClassifyServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientClassifyService service = new ClientClassifyServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		long id = Long.parseLong(ids);
		
		ClientClassifyDo getlistByid = service.getlistByid(id);
		request.setAttribute("list", getlistByid);
		
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_classify/update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进了-----------");
		String idS = request.getParameter("id");
		System.out.println("-------"+idS);
		long id =Long.parseLong(idS);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		service.updateClientClassfify(name, description, id);
		response.sendRedirect(request.getContextPath() + "/client/classify/list");
	}

}
