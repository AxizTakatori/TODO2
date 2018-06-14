<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
session.invalidate();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインページ</title>
</head>
<body>
	<c:if test="${not empty msg}">
		<p>${msg}</p>
		</c:if>
	<p>メールアドレスとPASSを入力してください</p>

	<form action="login" method="post">
		<div>
			e-mail:<input type="text" name="email" value =${fn:escapeXml(param.email)}><br>
			PASS:<input type="password" name="pass" value =${fn:escapeXml(param.pass)}><br>
			<button type="submit">送信</button>
		</div>
	</form>
</body>
</html>