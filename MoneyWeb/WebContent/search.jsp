<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>現金出納帳一覧</title>
</head>
<body>
<table border="1">

<tr>
	<th>日付</th>
	<th>科目</th>
	<th>摘要</th>
	<th>入金</th>
	<th>出金</th>
	<th>残高</th>
	<th>編集画面へ</th>
</tr>
<c:forEach items="${MoneyWeb_List}" var="vo">
<tr>
	<td><c:out value="${vo.date}" /></td>
	<td><c:out value="${vo.title}" /></td>
	<td><c:out value="${vo.task}" /></td>
	<td><c:out value="${vo.inputmoney}"/></td>
	<td><c:out value="${vo.outputmoney}"/></td>
	<td><c:out value="${vo.lastmoney}" /></td>
	<td><a href="editer?tableid=<c:out value="${vo.userid}" />">編集画面へ</a></td>
</tr>
</c:forEach>
</table>
<br />

●<a href="input">新規登録</a>
●<a href="search">一覧の再表示</a>


<hr />
<c:if test="${message != '' }">
	<c:out value="${message}" />
</c:if>
<hr />
ログインユーザ名:<c:out value="${LoginUserId}" />
<c:if test="${isAdmin}">
	[管理者権限]
</c:if>
</body>
</html>