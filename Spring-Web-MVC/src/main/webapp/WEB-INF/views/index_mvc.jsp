<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Web MVC Test</title>
</head>
<body>

<p>ここに受け取ったメッセージが表示されます。</p>
<p>${fn:escapeXml(msg)}</p>

<form:form action="post" modelAttribute="test">
  <form:input path="text" />
  <form:button>送信</form:button>
</form:form>

</body>
</html>
