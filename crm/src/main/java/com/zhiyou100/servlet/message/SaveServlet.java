package com.zhiyou100.servlet.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.EmailDO;
import com.zhiyou100.entity.UserDo;
import com.zhiyou100.service.EmailService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.EmailServiceImpl;
import com.zhiyou100.service.impl.UserServlceImpl;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmailService service = new EmailServiceImpl();
	private UserService serviceUser = new UserServlceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserDo> listUser = serviceUser.ListUser();
		request.setAttribute("users", listUser);
	request.getRequestDispatcher("/WEB-INF/jsp/message/save.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long  sendUserName =1;
		//指定了一个默认的登录用户
		
		
		String receiveName = request.getParameter("receiver");
		long receive=Long.parseLong(receiveName);
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		EmailDO email = new EmailDO();
		email.setSendUserId(sendUserName);
		email.setReceiveUserId(receive);
		email.setTitle(subject);
		email.setContent(content);
		service.saveEmail(email);
		String name =request.getParameter("name");
		String save = request.getParameter("save");
		
		if (name!=null) {
			//点击发送,跳转到收件箱
			request.getRequestDispatcher("/WEB-INF/jsp/massage/save.jsp").forward(request, response);
		}
		//点击保存草稿,进入到草稿箱
		//request.getRequestDispatcher("/WEB-INF/jsp/massage/save.jsp").forward(request, response);
		
		response.sendRedirect(request.getContextPath()+"/user/list");
	}
}
