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
	<script type="text/javascript">
	var date;
	var authNo;
	var eamil;
	function send_mail(){
		var email = document.getElementById("email");
		var re = /^[a-zA-Z\d]{8,15}$/;
		if (!re.test(email.value)) {
            alert('이메일을 정확하게 입력해주세요.');
            return false;
        }
		
		if(document.querySelector("#emailPick").value == "직접 입력"){
			email = $("#registerForm > input[name='email1']").get(0).value + $("#registerForm > input[name='email2']").get(0).value
		}else{
			email = $("#registerForm > input[name='email1']").get(0).value + document.querySelector("#emailPick").value;
		}
		
		$.ajax({
        	url : "<%= request.getContextPath() %>/RegisterCheckServlet",
        	data : {email : email},
        	success : function(data){
        		
        		if(data[0] === 0){        			
        			$.ajax({
        				url : "<%= request.getContextPath()%>/mailAuth.ml",
        				data : {email : email},
        				success : function(data){
        					authNo = data[0];
        					alert("인증번호가 발송 되었습니다.");
        				}
        			});
        			
        		}else{
        			alert("중복되는 아이디가 있습니다. 다른 이메일을 입력해주세요.")
        			document.getElementById("email").value = '';
        			$("#email").focus();
        			return false;
        		}
        	}
        });		
	}
	
	$("#authCheck").change(function(){
		
		if(authNo == null){
			alert("이메일 인증번호 받기를 먼저 진행해주세요.");
			document.querySelector("#authCheck").value = '';
			$("#authCheck").focus();
		}else if(document.querySelector("#authCheck").value != authNo){
			$("#emailAuthCheck").css({"display":"block", "color":"red","width":"auto"}).text("인증번호가 일치하지 않습니다. 확인 해주세요.");
		}else{
			$("#emailAuthCheck").css({"display":"block", "color":"blue","width":"auto"}).text("인증번호 일치!");
			if(document.querySelector("#emailPick").value == "직접 입력"){
				$("#emailPick").prop("disabled","true")
			}
		}
	});
	$("#emailPick").change(function(){	
		if(document.querySelector("#emailPick").value == "직접 입력"){
			$("#emailInsert").css("display","block");
		}else{
			$("#emailInsert").css("display","none");
		}
	});

	function checkForm(){
            var passwd = document.getElementById("userPwd1");
            var passwd2 = document.getElementById("userPwd2");
			var userName = document.getElementById("userName");
            var emailAuth = document.getElementById("authCheck");
			
			var re = /^[가-힣]{2,15}$/;
            if(!re.test(userName.value)){
            	alert("이름은 2~15글자의 한글이어야 합니다.")
            	userName.select();
            	return false;
            }
            
            if(authNo != null){
            	if(!(document.querySelector("#emailAuthCheck").textContent == "인증번호 일치!")){
            		alert("인증번호가 일치하지 않습니다. 다시 확인 해주세요.");
            		document.querySelector("#emailAuthCheck").select()
            		return false;
            	}
            }else{
            	alert("이메일은 아이디로 사용됩니다. 꼭 인증 절차를 거쳐 주세요.");
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