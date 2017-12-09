package com.zhiyou100.servlet.clientfrom;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.entity.ClientFromDo;
import com.zhiyou100.service.ClientFromService;
import com.zhiyou100.service.impl.ClientFromServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientFromService service =new ClientFromServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		long id = Long.parseLong(ids);
		
	ClientFromDo getlistByid = service.getlistByid(id);
		request.setAttribute("list", getlistByid);
		
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_from/update.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		long id =Long.parseLong(idS);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		service.updateClientFrom(name, description, id);
		response.sendRedirect(request.getContextPath() + "/client/from/list");
	}

}
