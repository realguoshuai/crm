<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色管理 - 智游客户关系管理系统</title>
<link rel="stylesheet"
	href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/css/main.css"></c:url>'>
</head>
<body>
	<div class="box">
		<h3>客户分类</h3>
		<div class="actions">
		<form id="searchForm" action='<c:url value="/user/select"></c:url>' method="post">
            <span>搜索内容：</span>
            <input type="text" name="keyword"  placeholder="请输入搜索关键词">
            &nbsp;&nbsp;&nbsp;
            <span>搜索字段：</span>
            <select name="searchField">
                <option value="name">用户名</option>
                <option value="phone">手机号</option>
                <option value="id">序号</option>
            </select>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" class="btn btn-default" value="搜索">
            </form>
            
            
			<div>
				<a class="btn btn-primary" href='<c:url value="/client/classify/add"></c:url>'>添加分类</a>
			</div>
		</div>
		<table class="list">
			<tr>
				<th>序号</th>
				<th>分类名称</th>
				<th>分类描述</th>
				<th>更新时间</th>
				<th>操作</th>
			</tr>
			<c:forEach items="${list }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.fromName}</td>
					<td>${user.fromDesc }</td>
					<td>${user.gmtModified }</td>
					<td>
						<a class="fa fa-pencil" title="编辑"
							href='<c:url value="/client/classify/update?id=${user.id }"></c:url>'></a>
						&nbsp;&nbsp;
						<a class="fa fa-remove" title="删除"
							href="javascript:confirmDelete(${user.id })"></a>
					</td>
				</tr>

			</c:forEach>
		</table>
		
	</div>

	<script src='<c:url value="/lib/jquery/jquery.js"></c:url>'></script>
	<script>
    	function confirmDelete(id){
    		if (confirm("确定要删除序号为" + id + "的数据吗？")) {
    			//location.href  发送请求  = 请求地址
    			location.href ='<c:url value="/client/classify/delete?id="></c:url>' + id
    		}
    	}
    </script>
</body>
</html>