<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>요청 파라미터값 테스트</h2>

	<form action="/web/request/join" method="POST">
		<fieldset>
			<legend>회원 가입 양식</legend>
			<p>
				# ID : <input type="text" name="userID" size="10"> <br>
				# PW : <input type="password" name="userPW" size="10"> <br>
				# NAME : <input type="text" name="userNAME" size="10"> <br>
				# HOBBY : 
				<input type="checkbox" name="hobby" value="soccer">축구 &nbsp;
				<input type="checkbox" name="hobby" value="book">독서 &nbsp;
				<input type="checkbox" name="hobby" value="music">음악감상 &nbsp;
				<br>
				<input type="submit" value="확인">
			</p>
		</fieldset>
	</form>

</body>
</html>