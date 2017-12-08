<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>写邮件 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>写邮件</h3>
		<form action="<c:url value="/message/save" />" method="post">
			<table class="form-table">
				<tr>
					<td>收件人</td>
					<td colspan="3" class="control">
						<select name="receiver">
						<c:forEach var="user" items="${ users }">
							<option value="${ user.userId }">${ user.username }</option>
						</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>主题</td>
					<td colspan="3" class="control">
						<input type="text" name="subject" placeholder="请填写邮件主题">
					</td>
				</tr>
				<tr>
					<td>内容</td>
					<td colspan="3" class="control">
						<textarea class="p100" name="content" placeholder="请填写邮件内容"></textarea>
					</td>
				</tr>
			</table>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="submit" name="send" value="发送">&nbsp;&nbsp;
				<input class="btn btn-primary va-bottom" type="submit" name="save" value="保存草稿">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>