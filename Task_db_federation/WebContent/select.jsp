<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索画面</title>
<link href="css/commons.css"
	rel="stylesheet">
</head>
<body>


	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>


	<p>検索したいデータを入力してください。<br>
	※空白の場合は全検索を行います</p>
	<c:if test="${not empty msg}">
		<p class = "error">${msg}</p>
	</c:if>
	<form action="select" method="get">
		<fieldset>
			<div>
				<label>ID</label><input type="text" name="user_id" value = "${defoid}">
			</div>
			<div>
				<label>名前</label><input type="text" name="user_name">
			</div>
			<div>
				<label>TEL</label><input type="text" name="telephone">
			</div>
		</fieldset>
		<input type="submit" value="検索">
	</form>
	<div>
		<a href="menu.jsp">メニューに戻る</a>
	</div>
</body>
</html>