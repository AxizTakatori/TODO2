<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー画面</title>
<link href="css/commons.css" rel="stylesheet">
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>
</head>
<body>

	<p>${loginname}さん、こんにちは</p>

	<p>
		<a href="select.jsp">検索</a>
	</p>
	<p>
		<a href="insert.jsp">登録</a>
	</p>
	<p>
		<a href="update.jsp">更新</a>
	</p>
	<p>
		<a href="delete.jsp">削除</a>
	</p>
	<form action="logout" method="post">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>
