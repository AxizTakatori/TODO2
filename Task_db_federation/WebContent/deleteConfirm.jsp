<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>


	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>

<p>これでよろしいですか？</p>

<form action="deleteConfirm" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id" value="${fn:escapeXml(info.user_id)}" readonly>
    </div>
    <div>
      <label>名前</label><input type="text" name="name" value="${fn:escapeXml(info.user_name)}" readonly>
    </div>
    <div>
      <label>TEL</label><input type="text" name="tel" value="${fn:escapeXml(info.telephone)}" readonly>
    </div>
  </fieldset>
  <div>
    <input type="submit" name="button" value="削除">
    <input type="submit" name="button" value="戻る" onclick="location.href='delete.jsp'; return false;">
  </div>
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
