<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集画面</title>
</head>
<%--<link rel="stylesheet" type="text/css" href="../Todo.css" media= "all"/> --%>
<body>
<form id="sender" action="Edit" method="POST">

<table border="1" align="center">
		    	
	<tr>
		<th>日付</th>
		<td><input type="text" name="date" value="<fmt:formatDate value="${vo.date }" pattern="yyyy-MM-dd"/>" size="10" /></td>
	</tr>
	<tr>
		<th>科目</th>
		<td>
		  <select name="title" id="title" >
		  		<option value="101">売上高</option>
		  		<option value="202">施設費</option>
		  		<option value="303">消耗費</option>
		  		<option value="404">交通費</option>
		  		<option value="505">交際費</option>
		  		<option value="606">会議費</option>
		  		<option value="707">支給</option>
		  		<option value="808">その他</option>
		  </select>
		</td>  
	</tr>
	<tr>
		<th>概要</th>
		<td><input type="text" name="task" value="<c:out value="${vo.task}" />" maxlength="128" size="60" /></td>
	</tr>
	<tr>
		<th>入金</th>
		<td><input type="text" name="inputmoney" value="<c:out value="${vo.inputmoney}" />" size="16" /></td>
	</tr>
	<tr>
		<th>出金</th>
		<td><input type="text" name="outputmoney" value="<c:out value="${vo.outputmoney}" />" maxlength="128" size="60" /></td>
	</tr>
</table>

<input type="hidden" name="id" value="<c:out value="${ vo.id }"/>" />
<br>
<div class="center">
<input type="submit" value="編集する" /></div> 
</form>
<br>
<form id="delete" action="Delete" method="POST">
	<input type="hidden" name="id" value="<c:out value="${ vo.id }"/>" />
	<div class="center">
	<input type="submit" value="削除する" />
	</div>
</form>
<div class="center">
<br>
☆<a href="./Edit" >表示一覧に戻る</a>
</div>
</body>
</html>