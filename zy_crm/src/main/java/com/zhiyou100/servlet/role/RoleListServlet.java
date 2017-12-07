package com.zhiyou100.servlet.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.RoleDo;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.impl.RoleServiceImpl;

public class RoleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoleService service = new RoleServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("------------");
		// 1,调用service获取数据
		List<RoleDo> list = service.listRole();

		// 把数据转发到jsp展示
		// 追加
		request.setAttribute("list", list);
		// 2,转发到list.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/role/list.jsp").forward(request, response);
	}

}
