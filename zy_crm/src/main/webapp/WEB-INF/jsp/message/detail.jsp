<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮件详情 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>邮件详情</h3>
		<form action="#" method="post">
			<table class="form-table">
				<tr>
					<td class="label">发件人</td>
					<td class="detail">
						${ message.senderName }
					</td>
				</tr>
				<tr>
					<td class="label">收件人</td>
					<td colspan="3" class="detail">
						${ message.receiverName }
					</td>
				</tr>
				<tr>
					<td class="label">邮件主题</td>
					<td colspan="3" class="detail">
						${ message.subject }
					</td>
				</tr>
				<tr>
					<td class="label">邮件内容</td>
					<td colspan="3" class="detail">
						${ message.content }
					</td>
				</tr>
				<tr>
					<td class="label">发送时间</td>
					<td colspan="3" class="detail">
						<fmt:formatDate value="${ message.sendTime }" type="both" pattern="yyyy-MM-dd HH:mm"/>
					</td>
				</tr>
				
			</table>
			<div class="buttons">
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>