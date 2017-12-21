package com.zhiyou100.servlet.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService service =new NoticeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iDString = request.getParameter("id");
		long id =Long.parseLong(iDString);
		service.deleteNotice(id);
		response.sendRedirect(request.getContextPath()+"/notice/list");
	}


}
