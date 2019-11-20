<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<style>
</style>
</head>
<body>
	
	<jsp:include page ="mainMenuBar.jsp"/>
		<div class = "content">	
			<div id = "update" align = "center">
				<h1>마이 페이지</h1>
				<c:url var = "userUpdate" value ="update.do"/>				
				<form id = "updateForm" method = "post" action = "${userUpdate }">
					<label id = "nameLabel">이름</label>
					<input name = "userName" id = "userName" type = "text" value = "${UserInfo.userName }" readonly><br>
					<label id = "emailLabel">이메일</label>
					<input type = "text" name = "userId" value = "${UserInfo.userId }" readonly><br>
					<label id = "pwd1Label">비밀번호</label>
					<input id = "userPwd1" type = "password" name = "userPwd" placeholder = "비밀번호 입력!"><br>
					<label id = "pwd1Check" style = "display : none">비밀번호는 영문 대문자 + 영문 소문자 + 숫자 + 특수문자 조합으로 입력해주세요.(최대 20글자)</label>
					<label id = "pwd2Label">비밀번호 확인</label>
					<input id = "userPwd2" type = "password" name = "userPwd2" placeholder = "비밀번호 확인!"><br>
					<label id = "pwd2Check" style = "display : none">일치하지 않습니다.</label>			
					
					<hr>
					<a href="javascript:history.back();">뒤로가기</a>
					<button>수정하기</button>
				</form>	
			</div>
		</div>
	<jsp:include page ="footer.jsp"/>
	
	<script type="text/javascript">
	var date;

	function updateInfo(){
            var passwd = document.getElementById("userPwd");
            var passwd2 = document.getElementById("userPwd2");
			
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
            
            $("#updateForm").attr("action","update.do").submit();
            return true; //전송 처리
   };

     function goback(){
    	 location.href = "update.do";
     }
	
</script>
	
</body>
</html>