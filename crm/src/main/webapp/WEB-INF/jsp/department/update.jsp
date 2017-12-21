<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改部门 - 智游客户关系管理系统</title>
<link rel="stylesheet" href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/css/main.css"></c:url>'>
</head>
<body>
	<div class="box">
		<h3>修改部门</h3>
		<form action='<c:url value="/department/update?id=${department.id }"></c:url>' method="post">
			<table class="form-table">
				<tr>
					<td>部门名称</td>
					<td colspan="3" class="control">
						<input type="text" name="departmentName" placeholder="填写部门名称">
					</td>
				</tr>
				<tr>
					<td>部门描述</td>
					<td colspan="3" class="control">
						<textarea class="p100" name="departmentDesc" placeholder="请填写部门描述"></textarea>
					</td>
				</tr>
			</table>
			<div class="buttons">
				<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
				<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
			</div>
		</form>
	</div>
</body>
</html>