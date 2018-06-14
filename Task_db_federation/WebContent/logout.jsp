<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Refresh" content="3;URL=index.jsp">
<title>ログアウト</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>


<div class="center">
  <p>ログアウトしました。<br>
  ※３秒後にTOP画面に遷移します。</p>
</div>
</body>
</html>
