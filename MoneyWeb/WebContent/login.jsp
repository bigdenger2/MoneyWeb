<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<form action="Login" method="post"></form>
<table>
	<tr>
		<td>ユーザID</td>
		<td><input type ="text" name="userid" value="" /></td>
	</tr>
	<tr>
		<td>パスワード</td>
		<td><input type ="password" name="password" value="" /></td>
	</tr>
</table>
<br />
<input type="submit" value="ログイン" />
<br />
<br />
☆<a href="./NewRegister" >新規ユーザ登録の方こちらへ</a>
</body>
</html>