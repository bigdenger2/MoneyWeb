<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>表示一覧</title>
<%-- <link rel="stylesheet" type="text/css" href="../Todo.css" media= "all"/>--%>
</head>
<body>
<table border="1" align="center">
	<tr>
	  <th>コード</th>
	  <th>日付</th>
	  <th>科目</th>
	  <th>概要</th>
	  <th>入金</th>
	  <th>出金</th>
	  <th>残高</th>
	  
	</tr>
	<c:forEach items="${todoList}" var="vo">
	<tr>
	  <td><c:out value="${vo.code}" /></td>
	  <td><fmt:formatDate value="${vo.date}" pattern="yyyy-MM-dd"/></td>
	  <td><c:out value="${vo.title}" /></td>
	  <td><c:out value="${vo.task}" /></td>
	  <td><c:out value="${vo.inputmoney}" /></td>
	  <td><c:out value="${vo.outputmoney}" /></td>
	  <td><c:out value="${vo.lastmoney}" /></td>
	</tr>
	</c:forEach>
</table>
<br>
<div class="center">
☆<a href="./Register">登録</a>
<br>
☆<a href="./Editer">編集</a>
<br>
☆<a href="./Serch">検索</a>
<br>
☆<a href="./Delete">削除</a>
</div> <!-- center -->
</body>
</html>