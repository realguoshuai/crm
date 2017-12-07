<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>角色管理 - 智游客户关系管理系统</title>
<link rel="stylesheet" href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/css/main.css"></c:url>'>
</head>
<body>
	<div class="box">
		<h3>角色管理</h3>
		<div class="actions">
            <form id="searchForm" action="#" method="post">
        	</form>
			<div>
				<a class="btn btn-primary" href='<c:url value="/role/add"></c:url>'>添加角色</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>角色名称</th>
                <th>角色描述</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
         <c:forEach items="${list }" var="role">
            <tr>
                <td>${role.id }</td>
                <td>${role.name }</td>
                <td>${role.description }</td>
                <td>${role.gmtModified } </td>
                <td>
                    <a class="fa fa-pencil" title="编辑" href='<c:url value="/role/update?id=${role.id }"></c:url>'></a>
                	&nbsp;&nbsp;
                	<a class="fa fa-remove" title="删除" href="javascript:confirmDelete(${role.id })"></a>
                </td>
            </tr>
         
         </c:forEach>
        </table>

       
	<script src='<c:url value="/lib/jquery/jquery.js"></c:url>'></script>
	<script>
    	function confirmDelete(id){
    		if (confirm("确定要删除序号为" + id + "的数据吗？")) {
    			//location.href  发送请求  = 请求地址
    			location.href ='<c:url value="/role/delete?id="></c:url>' + id
    		}
    	}
    </script>
</body>
</html>