<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发件箱 - 智游客户关系管理系统</title>
<link rel="stylesheet" href="<c:url value="/lib/font-awesome/css/font-awesome.css" />">
<link rel="stylesheet" href="<c:url value="/css/main.css" />">
</head>
<body>
	<div class="box">
		<h3>发件箱</h3>
		<div class="actions">
			<form id="searchForm" action="<c:url value="/message/listSend" />" method="post">
				<span>搜索内容：</span>
				<input type="text" name="keyword" value="${ keyword }" placeholder="请输入搜索关键词">
				&nbsp;&nbsp;&nbsp;
				<span>搜索字段：</span>
				<select name="searchField">
					<option value="subject" ${ field=="subject"?"selected":"" }>主题</option>
					<option value="content" ${ field=="content"?"selected":"" }>内容</option>
				</select>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="hidden" id="pageNo" name="pageNo" value="${ pageNo }">
				<input type="submit" class="btn btn-default" value="搜索">
			</form>
			<div>
				<a class="btn btn-primary" href="<c:url value="/message/save" />">写邮件</a>
			</div>
		</div>
		<table class="list">
            <tr>
                <th>序号</th>
                <th>收件人</th>
                <th>主题</th>
                <th>发送时间</th>
                <th>操作</th>
            </tr>
            <c:forEach var="message" items="${ list }">
            <tr>
                <td>${ message.messageId }</td>
                <td>${ message.receiverName }</td>
                <td>
	                <a title="查看详情" href="<c:url value="/message/detail?id=" />${message.messageId}" >
	                	${ message.subject }
	                </a>
                </td>
                <td>
                	<fmt:formatDate value="${message.sendTime}" type="both" pattern="yyyy-MM-dd HH:mm"/>
                </td>
                <td>
                	<a class="fa fa-remove" title="删除" href="javascript:confirmDelete(${message.messageId})"></a>
                </td>
            </tr>
            </c:forEach>
            <c:if test="${empty list}">
    		<tr>
    			<td colspan="5">
    				没有邮件..
    			</td>
    		</tr>
    		</c:if>
        </table>
        <%@ include file="/WEB-INF/shared/pageInfo.jsp"  %>
	</div>
	<script src="<c:url value="/lib/jquery/jquery.js" />"></script>
	<script>
    	function goPage(pageNo) {
    		$('#pageNo').val(pageNo);
    		$('#searchForm').submit();
    	}
    	function confirmDelete(id){
    		if (confirm("确定要删除码？")) {
    			location.href = '<c:url value="/message/remove?side=send&id=" />' + id
    		}
    	}
    </script>
</body>
</html>