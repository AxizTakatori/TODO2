<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>

	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>

<p>１箇所以上の項目を変更してください<br>
※IDは変更できません</p>

<form action="updateInput" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id" value="${update.user_id}" readonly>
    </div>
    <div>
      <label>名前</label><input type="text" name="newName" value="${update.user_name}">
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="${update.telephone}">
    </div>
    <div>
      <label>PASS</label><input type="password" name="newPass" value="${update.password}">
    </div>
  </fieldset>
  <div>
    <input type="submit" name="button" value="確認">
    <input type="submit" name="button" value="戻る" onclick="location.href='update.jsp'; return false;">
  </div>
</form>

	<c:if test="${not empty msg}">
		<p class = "error">${msg}</p>
		</c:if>

<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
