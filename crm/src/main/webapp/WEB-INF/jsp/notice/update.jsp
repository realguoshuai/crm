<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改用户 - 智游客户关系管理系统</title>
<link rel="stylesheet"
	href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/css/main.css"></c:url>'>
</head>
<body>
	<div class="box">
		<h3>更改公告</h3>
		<form action='<c:url value="/notice/add"></c:url>' method="post">
			<table class="form-table">
				<tr>
					<td>修改发布时间</td>
					<td colspan="3" class="control">
						<input type="date"  name="beginTime">
					</td>
					<td>修改截止时间</td>
					<td colspan="3" class="control">
						<input type="date" name="endTime">
					</td>
				</tr>
				<tr>
					<td>修改主题</td>
					<td colspan="3" class="control">
						<input type="text" name="title" placeholder="请输入主题">
					</td>
					<td>修改通知范围</td>
					<td colspan="3" class="control">
						<select name="departmentId">
							<c:forEach items="${departmentList }" var="department">
								<option value="${department.id }">${department.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>修改用户描述</td>
					<td colspan="9" class="control">
						<textarea class="p100" name="content" placeholder="请填写用户描述"></textarea>
					</td>
				</tr>
			</table>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="submit" value="保存">
				&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>