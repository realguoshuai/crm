package com.zhiyou100.servlet.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.EmailDO;
import com.zhiyou100.service.EmailService;
import com.zhiyou100.service.impl.EmailServiceImpl;

/**
 * Servlet implementation class ReceiveServlet
 */
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmailService service = new EmailServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--------------进来了");
		long  sendUserName =1;
		
		List<EmailDO> listReceiveBox = service.listReceiveBox(sendUserName);
		request.setAttribute("listReceiveBox", listReceiveBox);
		
		//转发到收件箱
		request.getRequestDispatcher("/WEB-INF/jsp/message/listReceive.jsp").forward(request, response);
		
	}

}
