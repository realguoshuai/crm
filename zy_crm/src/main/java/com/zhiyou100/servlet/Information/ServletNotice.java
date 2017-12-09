package com.zhiyou100.servlet.Information;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.NoticeDo;
import com.zhiyou100.service.NoticeService;
import com.zhiyou100.service.impl.NoticeServiceImpl;
import com.zhiyou100.util.NoticeSearchTypeName;

/**
 * Servlet implementation class ServletNotice
 */
public class ServletNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService service = new NoticeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long pageIndex = 1L;
		String pageIndexString = request.getParameter("pageIndex");
		if (pageIndexString != null) {
			//获取到pageIndex或者使用默认的
			pageIndex = Long.parseLong(pageIndexString);
		}
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");

		if (keyword != null && type != null) {
			// 继续拧下一步
			NoticeSearchTypeName typeEnum = null;
			switch (type) {
			case "1": {

				typeEnum = NoticeSearchTypeName.NOTICE_TITLE;
			}
				break;
			case "2": {

				typeEnum = NoticeSearchTypeName.NOTICE_CONTENT;
			}
				break;
			case "3": {

				typeEnum = NoticeSearchTypeName.USER_NAME;
			}
				break;
			case "4": {

				typeEnum = NoticeSearchTypeName.DEPARTMENT_NAME;
			}
				break;
			default:
				break;

			}
			//查出pageCount
			long pageCount = service.countNotice(keyword, typeEnum);
			if (pageIndex > pageCount) {

				pageIndex = pageCount;
			}
			if (pageCount!=0) {
				List<NoticeDo> list =service.listNotice(keyword, typeEnum, pageIndex);
				request.setAttribute("list", list);
				
				request.setAttribute("pageIndex", pageIndex);
				request.setAttribute("pageCount", pageCount);
			}
			
			
			request.setAttribute("keyword", keyword);
			request.setAttribute("type", type);
		}else{
			//如果没有关键字,表示没有查询
			Long pageCount = service.countNotice();
			if (pageIndex > pageCount) {
				pageIndex = pageCount;
			}
			if(pageCount != 0){
				List<NoticeDo> list = service.listNotice(pageIndex);
				request.setAttribute("list", list);
				request.setAttribute("pageIndex", pageIndex);
				request.setAttribute("pageCount", pageCount);
			}
			
		}
		request.getRequestDispatcher("/WEB-INF/jsp/inside_info/note_list.jsp").forward(request, response);

	}

}
