package com.zhiyou100.servlet.Information;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.entity.DepartmentDo;
import com.zhiyou100.entity.RoleDo;
import com.zhiyou100.entity.UserDo;
import com.zhiyou100.service.DepartmentService;
import com.zhiyou100.service.RoleService;
import com.zhiyou100.service.UserService;
import com.zhiyou100.service.impl.DepartmentServiceImpl;
import com.zhiyou100.service.impl.RoleServiceImpl;
import com.zhiyou100.service.impl.UserServlceImpl;

/**
 * Servlet implementation class ServletUser
 */
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service = new UserServlceImpl();
	private DepartmentService serviceDeprtment = new DepartmentServiceImpl();
	private RoleService serviceRole = new RoleServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DepartmentDo> listDepartment = serviceDeprtment.listDepartment();
		request.setAttribute("departmentList", listDepartment);

		List<RoleDo> listRole = serviceRole.listRole();
		request.setAttribute("roleList", listRole);

	//	int pageIndex=2;
		
		
		
		
		String pageIndexString = request.getParameter("pageIndex");
		int  pageIndex =1;
		if(pageIndexString!=null){
			pageIndex = Integer.parseInt(pageIndexString);
		}
		List<UserDo> listUser = service.pageListUser(pageIndex);
		request.setAttribute("list", listUser);
		/*
		 * 获取总页数 分页 设置总页数
		 * 第几页
		 */
		int countSum = service.countPage();
		int pageSum =(countSum+4)/5;
		request.setAttribute("pageIndex", pageIndex);
		request.setAttribute("count", countSum);
		request.setAttribute("pageSum", pageSum);
		//System.out.println("-----------"+countPage);
		request.getRequestDispatcher("/WEB-INF/jsp/inside_info/list.jsp").forward(request, response);
	}

}
