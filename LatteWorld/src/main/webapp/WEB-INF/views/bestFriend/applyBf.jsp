<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min/js"></script>
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<h2 align = "center">일촌 신청하기</h2>
		<br>
		<h3 align = "center">보내는 사람 : ${UserInfo.userName }</h3>
		<hr>
		<span  align = "center">${bfName }님께 Best Friend를 신청 합니다.</span>
		<br>
		BestFriend가 되고싶어요!
		<form>
			<textarea align = "center" rows="3" cols="40" placeholder = "상대방에게 전할 메세지를 넣어주세요"></textarea>
			<br>
			<span  align = "center">상대방이 동의하면 BestFriend가 됩니다.</span>
			<br>
			<hr>
			<button>보내기</button>&nbsp;<button onclick = "self.close()">취소</button>
		</form>
	</div>
	
	
</body>
</html>