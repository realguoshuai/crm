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
		<h3>员工信息</h3>
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
			</div>
		</div>
		<table class="list">
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>部门</th>
				<th>角色</th>
				<th>手机号</th>
				<th>邮箱</th>
				<th>更新时间</th>
			</tr>
			<c:forEach items="${list }" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name }</td>
					<td>${user.departmentId }</td>
					<td>${user.roleId }</td>
					<td>${user.phone }</td>
					<td>${user.eMail }</td>
					<td>${user.gmtModified }</td>
				</tr>

			</c:forEach>
		</table>
		
		      <div class="pager-info">
		      
            <div>共有${count }条数据，第${pageIndex }/${pageSum} 页 </div>

			<div>
                <ul class="pagination">
                    <li class="paginate_button previous disabled" onclick="goPage(1)">
                        <a href='<c:url value="/user/list?pageIndex=${pageIndex>1?pageIndex-1:1 }"></c:url>'>上一页</a>
                    </li>
                    
                    <c:forEach begin="1" end="${pageSum }" varStatus="index">
	                    <li class="paginate_button <c:if  test='${index.index==pageIndex }'>active</c:if> " 
	                        onclick="goPage(1)">
	                        <a href='<c:url value="/user/list?pageIndex=${index.index }"></c:url>'>${index.index}</a>
	                    </li>
                    </c:forEach>
                    <li class="paginate_button next}">
                        <a href='<c:url value="/user/list?pageIndex=${pageIndex<pageSum?pageIndex+1:pageSum }"></c:url>'>下一页</a>
                    </li>
                </ul>
            </div>
        </div>
	</div>

	<script src='<c:url value="/lib/jquery/jquery.js"></c:url>'></script>
	<script>
    	function confirmDelete(id){
    		if (confirm("确定要删除序号为" + id + "的数据吗？")) {
    			//location.href  发送请求  = 请求地址
    			location.href ='<c:url value="/user/delete?id="></c:url>' + id
    		}
    	}
    </script>
</body>
</html>