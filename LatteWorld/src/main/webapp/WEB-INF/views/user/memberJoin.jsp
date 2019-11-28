<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
	.centerText table{
		margin: auto;
	}
	body{
		background-image:url("resources/images/background.jpg");
	}
	.guide{
		display:none;
		font-size:12px;
		top:12px;
		right:10px;
	}
	span.ok{color:green;}
	span.error{color:red;}
	

</style>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class="content">
	<h1>회원가입!	</h1>
		<form action="join.do" method="post" id="joinForm" >
			<table width="500" cellspacing="5">
				<tr>
					<td width="150">* 아이디</td>
					<td width="450">
						<input type="text" name="userId" id="userId">
						<!---------------- ajax 후에 적용할 부분 ------------------->
						<span class="guide ok">이 아이디는 사용 가능합니다.</span>
						<span class="guide error">이 아이디는 사용할 수 없습니다.</span>
						<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value="0">
						<!-- ------------------------------------------------ -->
						
					</td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>* 비밀번호</td>
					<td><input type="password" name="userPwd"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="tel" name="phone"></td>
				</tr>
				<!-- 
					이제 주소 input을 작성 할낀데 너무 식상하니깐 API 사용해보자
					주소와 우편번호를 입력할 <input>들을 생성하고 적당한 name과 class를 부여하자
				 -->				
				<tr>
					<td colspan="2" align="center">
						<button type="button" onclick="validate()">가입하기</button>
						<!-- 이 버튼은 type이 "button"이어야지만 중복 아이디일 때 회원 가입 클릭시 submit을 막을 수 있다. -->
						&nbsp;
						<input type="reset" value="취소하기">
					</td>
				</tr>
			</table>
		</form>
		<br><br>
		<a href="home.do">시작 페이지로 이동</a>
	</div>
		<!-- 작성 후 minsert.do 요청을 처리하는 부분 작성하러 MemberController로 가자. -->
	
	
		<!-- ajax 후에 추가 하입시더 -->
		<script>
			$(function(){
				$("#userId").on("keyup",function(){
					var userId = $(this).val().trim();
					
					if(userId.length < 4){
						$(".guide").hide();
						$("#idDuplicateCheck").val(0);
						
						return;	
					}
					 
					$.ajax({
						url:"dupid.do",
						data:{userId:userId},
						success:function(data){
							if(data == "true"){
								$(".guide.error").hide();
								$(".guide.ok").show();
								$("#idDuplicateCheck").val(1);
							}else{
								$(".guide.error").show();
								$(".guide.ok").hide();
								$("#idDuplicateCheck").val(0);
							}
						},
						error:function(request, status, errorData){
							alert("error code: " + request.status + "\n"
									+"message: " + request.responseText
									+"error: " + errorData);
						}
					});
				});
			});
			
			function validate(){
				// 아이디 중복 체크 후 회원가입 버튼을 눌렀을 때
				if($("#idDuplicateCheck").val()==0){
					alert("사용 가능한 아이디를 입력해 주세요");
					$("#userId").focus();
				}else{
					$("#joinForm").submit();
				}
			}
			
			
			
		</script>
		
	<!-- 중복확인 및 로그인 버튼 함수까지 작성 했으면 
	     게시글 조회수가 높은 랭킹 top5 게시글을 메인 페이지에 보여주는 작업을 해보자(물론 ajax로..)
	   home.jsp로 ㄱㄱ씽 -->
	
	
	
</body>
</html>
	
	