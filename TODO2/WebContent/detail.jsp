<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>TODOタスクの詳細画面</title>
<jsp:include page="header.jsp" />
<script type="text/javascript">
window.onload = function() {
	var status = document.getElementById("status");
	status.selectedIndex = ${dto.status};
};
</script>
</head>
<body>

	<c:if test="${not empty msg}">
		<p class = "error">${msg}</p>
		</c:if>

<jsp:include page="nav.jsp" />
<div class="container">
	<form action="taskinsert" method="post">
<table class="table">
	<tr>
		<th>id</th>
		<td>
			<c:choose>
				<c:when test="${dto.id > 0}">
					<c:out value="${dto.id}" />
				</c:when>
				<c:otherwise>
					(新規)
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
	<tr>
		<th>タイトル</th>
		<td><input type="text" name="title" value="<c:out value="${dto.title}" />" size="20"/></td>
	</tr>
	<tr>
		<th>タスク内容</th>
		<td><input type="text" name="task" value="<c:out value="${dto.task}" />" maxlength="128" size="60"/></td>
	</tr>
	<tr>
		<th>期限</th>
		<td>
		<c:choose>
			<c:when test="${dto.inputLimitdate != null }">
				<input type="text" name="limitdate" value="<c:out value="${dto.inputLimitdate}" />" size="10"/>
			</c:when>
			<c:otherwise>
				<input type="text" name="limitdate" value="<fmt:formatDate value="${dto.limitdate }" pattern="yyyy-MM-dd"/>" size="10"/>
			</c:otherwise>
		</c:choose>
		</td>
	</tr>
	<tr>
		<th>登録者名</th>
		<td><input type="text" name="name" value="<c:out value="${dto.userid}" />" size="16"/></td>
	</tr>
	<tr>
		<th>状況</th>
		<td>
			<input type="text" name="status" value="<c:out value="${dto.inputLimitdate}" />" size="10"/>
		</td>
	</tr>
</table>

<input type="submit" class="btn btn-success" value="登録する" />
</form>

</div>
</body>
</html>