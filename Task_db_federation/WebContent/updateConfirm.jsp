<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新内容確認画面</title>
<link href="css/commons.css" rel="stylesheet">
<style>
.col {
  float: left;
}

.col-clear {
  clear: both;
}

#arrow {
  margin-top: 60px;
}
</style>
</head>
<body>


	<!--  セッションの内容がnullのとき、ログインページに飛ばす  -->
	<c:if test="${empty sessionScope.loginname}">
		<c:redirect url="http://localhost:8080/Task_db_federation/login.jsp" />
	</c:if>


	<c:if test="${not empty msg}">
		<p class="error">${msg}</p>
	</c:if>

<p>これでよろしいですか？</p>

<form action="updateConfirmt" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id" value="${fn:escapeXml(update.user_id)}" readonly>
    </div>
  </fieldset>

  <fieldset class="col">
    <legend>変更前</legend>
    <div>
      <label>名前</label><input type="text" value="${fn:escapeXml(update.user_name)}" disabled>
    </div>
    <div>
      <label>TEL</label><input type="text" value="${fn:escapeXml(update.telephone)}" disabled>
    </div>
    <div>
      <label>PASS</label><input type="password" value="${fn:escapeXml(update.password)}" disabled>
    </div>
  </fieldset>

  <div id="arrow" class="col">⇒</div>

  <fieldset class="col label-110">
    <legend>変更後</legend>
    <div>
      <label>名前</label><input type="text" name="newName" value="${fn:escapeXml(newname)}" readonly>
    </div>
    <div>
      <label>TEL</label><input type="text" name="newTel" value="${fn:escapeXml(newtel)}" readonly>
    </div>
    <div>
      <label>PASS(再入力)</label><input type="password" name="rePass" value="${fn:escapeXml(defopass)}">
    </div>
  </fieldset>

  <div class="col-clear">
    <input type="submit" name="button" value="更新">
    <input type="submit" name="button" value="戻る" onclick="location.href='updateInput.jsp'; return false;">
  </div>
</form>
<div>
  <a href="menu.jsp">メニューに戻る</a>
</div>
</body>
</html>
