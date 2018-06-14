<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザーページ</title>
</head>
<body>
	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.u_id}">
		<c:redirect url="http://localhost:8080/D_0531/login.jsp" />
	</c:if>

	いらっしゃい、${fn:escapeXml(user.name)}さん
	<table border="1">
		<tr>
			<th>ユーザID</th>
			<th>name</th>
			<th>email</th>
		</tr>

		<tr>
			<td>${fn:escapeXml(user.uid)}</td>
			<td>${fn:escapeXml(user.name)}</td>
			<td>${fn:escapeXml(user.email)}</td>
		</tr>

	</table>
	<ul>
		<li><a href="http://localhost:8080/D0531/buy">商品一覧</a></li>
		<li><a href="http://localhost:8080/D0531/result">履歴</a></li>
		<li><a href="http://localhost:8080/D0531/login.jsp">ログアウト</a></li>
	</ul>

</body>
</html>