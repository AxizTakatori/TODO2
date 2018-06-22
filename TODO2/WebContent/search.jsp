<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp" />
<title>TODOタスクの一覧</title>
</head>
<body>

	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
<%-- 		<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="index.jsp"/>
	</c:if> --%>

	<jsp:include page="nav.jsp" />
	<div class="container">
	<table class="table table-bordered">
		<tr>
			<th>id</th>
			<th>タイトル</th>
			<th>タスク内容</th>
			<th>期限</th>
			<th>登録者名</th>
			<th>状況</th>
			<th>詳細画面へ</th>
		</tr>
	<c:forEach var="select" items="${userList}">
			<tr>

 				<td><c:out value="${select.id}" /></td>
				<td><c:out value="${select.title}" /></td>
				<td><c:out value="${select.task}" /></td>
				<td><c:out value="${select.limitdate}" /></td>
				<td><c:out value="${select.name}" /></td>
				<td><c:out value="${select.status}" /></td>
<td>
	<form action = "detail" method="POST">
		<input type="hidden" name="id" value="${select.id}">
			<input type="submit" value="更新・削除画面へ">
		</form>
		</td>


			</tr>
		</c:forEach>
	</table>

		<form action="logout" method="post">
		<input type="submit" class="btn btn-success" value="ログアウト">
	</form>

	</div>
</body>
</html>