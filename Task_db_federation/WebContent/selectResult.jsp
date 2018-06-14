<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>

	<table border="1">
		<tr>
			<th>user_id</th>
			<th>user_name</th>
			<th>password</th>
		</tr>
	<c:forEach var="select" items="${userList}">
		<tr>
			<td>${fn:escapeXml(select.user_id)}</td>
			<td>${fn:escapeXml(select.user_name)}</td>
			<td>${fn:escapeXml(select.telephone)}</td>
		</tr>
	</c:forEach>
	</table>
<div>
	<a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>