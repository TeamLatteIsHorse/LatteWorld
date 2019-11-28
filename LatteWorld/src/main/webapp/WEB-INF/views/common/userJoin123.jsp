<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>라떼는 이렇게 회원가입 했어</title>
<style>
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
</style>
</head>
<body>
	<jsp:include page="mainMenuBar.jsp"/>
	
		<div class = "content">
			<div id = "register" align = "center">
				<h1>회원 가입</h1>
				
				<form id = "registerForm" method = "post" >
					<table border = "1" cellspacing = "3" width = "800">
						<tr>
							<td width = "200px">아이디</td>
							<td><input id = "userId" type = "text" name = "userName" placeholder="아이디 입력!!"></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input id = "userPwd1" type = "password" name = "userPwd" placeholder = "비밀번호 입력!"></td>
						</tr>
						<tr>
							<td>비밀번호 확인</td>
							<!-- <td>비밀번호는 영문 대문자 + 영문 소문자 + 숫자 + 특수문자 조합으로 입력해주세요.(최대 20글자)</td> -->
							<td><input id = "userPwd2" type = "password" name = "userPwd2" placeholder = "비밀번호 확인!"></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input id = "userName" type = "text" name = "userName" placeholder="이름 입력!!"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td><input id = "email" type = "text" name = "email1" placeholder = "이메일을 입력해주세요."></td>
						</tr>
						<tr>
							
							<td>
								<select id = "emailPick" name = "email2">
									<option>@naver.com</option>
									<option>@daum.net</option>
									<option>@gmail.com</option>
								</select>
							</td>
						</tr>
						<tr>
							<td align = "center"><label type = "button" value = "reset">초기화</label></td>
						</tr>
						<tr>
							<td align = "center"><label onclick = "checkForm()">가입하기</label></td>
						</tr>
					</table>
				</form>	
				
			</div>
		</div>
	<jsp:include page="footer.jsp"/>
	<script type="text/javascript">
	function checkForm(){
            var passwd = document.getElementById("userPwd1");
            var passwd2 = document.getElementById("userPwd2");
			var userName = document.getElementById("userName");
			
			var re = /^[가-힣]{2,15}$/;
            if(!re.test(userName.value)){
            	alert("이름은 2~15글자의 한글이어야 합니다.")
            	userName.select();
            	return false;
            }
            var re = /^[a-zA-Z!-)\d]{8,15}$/;
            if (!re.test(passwd.value)) {
                alert('암호는 영문자와 숫자, !~)까지의 특수문자로 8글자이상 15글자 이하로 입력하세요'); //정규식과 일치하지 않는다면
                passwd.select();
                return false;
            }

            if (passwd.value != passwd2.value) {
                alert("암호와 암호 확인 값이 일치하지 않습니다.");
                passwd2.select();
                return false;
            }
            
            $("#registerForm").attr("action","join.do").submit();
            return true; //전송 처리
        };

	
</script>
	
</body>
</html>