<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户 - 智游客户关系管理系统</title>
<link rel="stylesheet"
	href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/css/main.css"></c:url>'>
</head>
<body>

	<div class="box">
		<h3>修改用户</h3>
		<form action='<c:url value="/user/update?id=${list.id }"></c:url>' method="post">
			<table class="form-table">
				<tr>
					<td>用户名称</td>
					<td colspan="3" class="control">
						<input type="text" name="name" value="${list.name }">
					</td>
					<td>密码</td>
					<td colspan="3" class="control">
						<input type="password" name="password" value="${list.password }">
					</td>
				</tr>
				<tr>
					<td>部门</td>
					<td colspan="3" class="control" >
						<select name="departmentId">
						<c:forEach items="${departmentList }" var="department">
							<option value="${department.id }"<c:if test="${user.departmentId == 

department.id }">selected="selected"</c:if> >${department.name }

</option>
						</c:forEach>
						</select>
					</td>
					<td>角色</td>
					<td colspan="3" class="control">
						<select name="roleId">
							<c:forEach items="${roleList }" var="role">
								<option value="${role.id }">${role.name }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td colspan="3" class="control">
						<input type="radio" name="gender" checked="checked" value="0">男
						<input type="radio" name="gender" value="1">女
					</td>
					<td>手机号</td>
					<td colspan="3" class="control">
						<input type="text" name="phone" value="${list.phone }">
					</td>
				</tr>
				<tr>
				<td>邮箱</td>
					<td colspan="9" class="control">
						<input type="text" name="email" placeholder="填写邮箱">
					</td>
				</tr>
				<tr>
					<td>用户描述</td>
					<td colspan="9" class="control">
						<textarea class="p100" name="description" value="${list.description }"></textarea>
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