<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.content {
    padding-left: 423px;
    padding-top: 4px;
    min-height: 759px;
    min-width : 1201px;
    width: 88.32%;
}
.content > *{
	min-width : 777px;
}
#mainTop{
	width : 85%;
	height : 10%;
}
#mainTop *{
	display : inline-block;
	text-align : center;
	vertical-align : middle;
}
#registerForm *{
width : 150px;
}
#topMenu{
position : relative;
left : 20%;
}
</style>

</head>
<body>
	<jsp:include page="mainMenuBar.jsp"/>
		<div class = "content">
			<div id = "register" align = "center">
				<h1>아이디/비밀번호 찾기</h1>
				<form id = "registerForm" method = "post" >
					<label id = "nameLabel">이름</label>
					<input id = "userName" type = "text" name = "userName" placeholder="이름 입력!!"><br>
					<label id = "emailLabel">이메일</label>
					<input id = "email" type = "text" name = "email1" placeholder = "이메일을 입력해주세요.">
					<select id = "emailPick" name = "email2">
						<option>@naver.com</option>
						<option>@daum.net</option>
						<option>@gmail.com</option>
						<option>직접 입력</option>
					</select><br>
					<input id = "emailInsert" type = "text" name = "email2" style = "display : none" placeholder = "직접 입력해주세요.">
					<button type="button" class="btn btn-primary btn-lg btn-block" onclick="send_mail()">인증번호 보내기</button><br>
					<label id = "emailAuthLabel">이메일 인증번호 입력</label>
					<input id ="authCheck" type ="text" placeholder="인증번호 입력!"><br>
					<label id = "emailAuthCheck" style = "display : none">인증번호가 일치하지 않습니다. 확인 해주세요.</label>
					<label id = "pwd1Label">비밀번호</label>
					<input id = "userPwd1" type = "password" name = "userPwd1" placeholder = "비밀번호 입력!"><br>
					<label id = "pwd1Check" style = "display : none">비밀번호는 영문 대문자 + 영문 소문자 + 숫자 + 특수문자 조합으로 입력해주세요.(최대 20글자)</label>
					<label id = "pwd2Label">비밀번호 확인</label>
					<input id = "userPwd2" type = "password" name = "userPwd2" placeholder = "비밀번호 확인!"><br>
					<label id = "pwd2Check" style = "display : none">일치하지 않습니다.</label>
					
					<hr>
					<label type = "button" value = "reset">초기화</label>
					<label onclick = "checkForm()">가입하기</label>
				</form>	
			</div>
		</div>
	
	<jsp:include page="footer.jsp"/>
</body>
</html>