package com.zhiyou100.servlet.notice;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.entity.NoticeDo;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;
import com.zhiyou100.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService = new NoticeServiceImpl();
	private DepartmentService departmentService = new DepartmentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//引入这个部门是为了在add.jsp的下拉菜单中显示出来
		List<DepartmentDo> departmentList = departmentService.listDepartment();
		request.setAttribute("departmentList", departmentList);
		request.getRequestDispatcher("/WEB-INF/jsp/notice/add.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bagenTimeString =request.getParameter("beginTime");
		String endTimeString = request.getParameter("endTime");
		String title = request.getParameter("title");
		String departmentId = request.getParameter("departmentId");
		String content = request.getParameter("content");
		Long userId =1L;
		NoticeDo notice =new NoticeDo();
		
		notice.setBeginTime(Date.valueOf(bagenTimeString));
		notice.setEndTime(Date.valueOf(endTimeString));
		notice.setTitle(title);
		notice.setDepartmentId(Long.parseLong(departmentId));
		notice.setContent(content);
		notice.setUserId(userId);
		noticeService.addNotice(notice);
		response.sendRedirect(request.getContextPath()+"/notice/list");
	}

}
