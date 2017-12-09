package com.zhiyou100.servlet.clientstatus;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.ClientClassifyDo;
import com.zhiyou100.entity.ClientStatusDo;
import com.zhiyou100.service.ClientStatusService;
import com.zhiyou100.service.impl.ClientStatusServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientStatusService service = new ClientStatusServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = request.getParameter("id");
		long id = Long.parseLong(ids);
		
		 ClientStatusDo getlistByid = service.getlistByid(id);
		request.setAttribute("list", getlistByid);
		
		request.getRequestDispatcher("/WEB-INF/jsp/client/client_status/update.jsp").forward(request, response);
	
	}

	/**
	 * ++	
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idS = request.getParameter("id");
		System.out.println("-------"+idS);
		long id =Long.parseLong(idS);
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		service.updateClientStatus(name, description, id);
		response.sendRedirect(request.getContextPath() + "/client/status/list");
	}

}
