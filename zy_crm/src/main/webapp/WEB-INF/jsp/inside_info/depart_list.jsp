<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门管理 - 智游客户关系管理系统</title>
<link rel="stylesheet" href='<c:url value="/lib/font-awesome/css/font-awesome.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/css/main.css"></c:url>'>
</head>
<body>
	<div class="box">
		<h3>部门信息</h3>
		<div class="actions">
            <form id="searchForm" action="#" method="post">
        	</form>
			<div>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>部门名称</th>
                <th>部门描述</th>
                <th>更新时间</th>
            </tr>
         <c:forEach items="${listDepartment }" var="department">
            <tr>
                <td>${department.id }</td>
                <td>${department.name }</td>
                <td>${department.description }</td>
                <td>${department.gmtModified } </td>
            </tr>
         
         </c:forEach>
        </table>

       
	<script src='<c:url value="/lib/jquery/jquery.js"></c:url>'></script>
	<script>
    	function confirmDelete(id){
    		if (confirm("确定要删除序号为" + id + "的数据吗？")) {
    			//location.href  发送请求  = 请求地址
    			location.href ='<c:url value="/department/delete?id="></c:url>' + id
    		}
    	}
    </script>
</body>
</html>