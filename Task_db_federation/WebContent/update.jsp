<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>


	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>



	<c:if test="${not empty msg}">
		<p class = "error">${msg}</p>
		</c:if>

<p>更新を行うデータのIDを入力してください<br>
<span class="required"></span>は必須です</p>

<form action="update" method="post">
  <fieldset>
    <div>
      <label class="required">ID</label><input type="text" name="id">
    </div>
  </fieldset>
  <input type="submit" value="確認">
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
