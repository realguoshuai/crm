<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公告管理 - 智游客户关系管理系统</title>
<link rel="stylesheet"
	href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/css/main.css"></c:url>'>
</head>
<body>
	<div class="box">
		<h3>公告信息</h3>
		<div class="actions">
			<form id="searchForm" action='<c:url value="/notice/list"></c:url>'>
				<span>搜索内容：</span>
				<input type="text" name="keyword" value="${keyword }"
					placeholder="请输入搜索关键词">
				&nbsp;&nbsp;&nbsp;
				<span>搜索字段：</span>
				<select name="type">
					<option value="1"
					
						<c:if test="${type == 1 }">selected="selected"</c:if>>主题</option>
					<option value="2"
						<c:if test="${type == 2 }">selected="selected"</c:if>>内容</option>
					<option value="3"
						<c:if test="${type == 3 }">selected="selected"</c:if>>公告人</option>
					<option value="4"
						<c:if test="${type == 4 }">selected="selected"</c:if>>通知范围</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" class="btn btn-default" value="搜索">
			</form>
			<div>
			</div>
		</div>
		<table class="list">
			<tr>
				<th>序号</th>
				<th>公告人</th>
				<th>公告主题</th>
				<th>通知范围</th>
				<th>公告内容</th>
				<th>公告时间</th>
				<th>截至时间</th>
			</tr>
			<c:forEach items="${list }" var="notice">
				<tr>
					<td>${notice.id }</td>
					<td>${notice.userName }</td>
					<td>${notice.title }</td>
					<td>${notice.departmentName }</td>
					<td>${notice.content }</td>
					<td>${notice.beginTime }</td>
					<td>${notice.endTime }</td>
				</tr>
			</c:forEach>
		</table>

		<%@ include file="/WEB-INF/jsp/templete/page" %>

	</div>
	<script src="lib/jquery/jquery.js"></script>
	<script>
		function confirmDelete(id) {
			if (confirm("确定要删除" + id + "吗？")) {
				location.href = '<c:url value="/notice/delete?id="></c:url>'
						+ id;
			}
		}
	</script>
</body>
</html>