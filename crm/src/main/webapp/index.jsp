<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页 - 智游客户关系管理系统</title>
<link rel="stylesheet" href='<c:url value="/css/admin.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
</head>
<body>
	<div class="header">
	    <h1><a href="">智游客户关系管理系统</a></h1>
	    <div class="nav">
	    	<a target="right" href="http://localhost:8080/zycrm/index.jsp?name=${name }">工作台</a>
            <a target="right" href="#">报表</a>
            <a target="right" href="#">客户信息</a>
            <a target="right" href="#">员工信息</a>
            <a target="right" href="#">公告信息</a>
            <a target="right" href="#">发件箱</a>
	    </div>
	    <%String name=request.getParameter("name"); %>
	    <div class="user">
	        <a href="#"><%=name %></a>
	        <a href="http://localhost:8080/zycrm/login.jsp" >退出</a>
	    </div>
    </div>
    <div class="main">
	    <ul class="left-side">
	    	<li class="menu-title">
	    		<a href="#">
	    			<i class=" fa fa-users"></i>&nbsp;&nbsp;客户管理
	    		</a>
	    	</li>
	    	<li class="sub-menu">
			   	<ul>
		            <li>
		            	<a href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户信息
		            	</a>
		            </li>
		            <li>
		            	<a href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户分配
		            	</a>
		            </li>
		            <li>
		            	<a href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户关怀
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/client/classify/list"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户分类
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/client/status/list"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户状态
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/client/from/list"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;客户来源
		            	</a>
		            </li>
		        </ul>
	        </li>
	        <li class="menu-title active">
	        	<a href="#">
	    			<i class=" fa fa-file-text"></i>&nbsp;&nbsp;内部信息
	    		</a>
	    	</li>
	        <li class="sub-menu">
		        <ul>
		        	<li>
		        		<a target="pageBox" href='<c:url value="/list/notice"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;通知公告
		            	</a>
		        	</li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/list/user"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;员工信息
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/list/department"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;部门信息
		            	</a>
		            </li>
		        </ul>
	        </li>
	      <li class="menu-title">
				<a href= "#">
					<i class=" fa fa-envelope"></i>
					&nbsp;&nbsp;站内邮件
				</a>
			</li>
	        <li class="sub-menu">
		        <ul>
		            <li>
		            	<a target="pageBox" href='<c:url value="/message/save"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;写邮件
		            	</a>
		           	</li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/message/receive"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;收件箱
		            	</a>
		           	</li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/message/send"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;发件箱
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/message/draft"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;草稿箱
		            	</a>
		            </li>
		             <li>
		            	<a target="pageBox" href="#">
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;垃圾箱
		            	</a>
		            </li>
		        </ul>
	        </li>
	        <li class="menu-title">
	        	<a href="#">
	    			<i class=" fa fa-sitemap"></i>&nbsp;&nbsp;管理员
	    		</a>
	        </li>
	        <li class="sub-menu">
		        <ul class="menu">
		        	<li>
		        		<a target="pageBox" href='<c:url value="/notice/list"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;公告管理
		            	</a>
		        	</li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/department/list"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;部门管理
		            	</a>
		            </li>
		            <li>
<!-- 需要跳转到servlet -->
		            	<a target="pageBox" href='<c:url value="/role/list"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;角色管理
		            	</a>
		            </li>
		            <li>
		            	<a target="pageBox" href='<c:url value="/user/list"></c:url>'>
		            		<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;用户管理
		            	</a>
		            </li>
		        </ul> 
	        </li>
	    </ul>
	    <div class="right-side">
	    <!-- "/WEB-INF/jsp/role/list.jsp" -->
	    	<iframe name="pageBox" src='<c:url value="/role/list"></c:url>'></iframe>
		    <div class="footer">
		    	智游教育 ©2017 河南智游臻龙教育科技有限公司
		    </div>
	    </div>    
    </div>
    <script src="lib/jquery/jquery.js"></script>
    <script src="js/admin.js"></script>
</body>
</html>