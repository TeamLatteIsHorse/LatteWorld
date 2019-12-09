<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.3.1.min/js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body > div{
border : 1px solid black;
}
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}
.topnav {
	padding-left: 200px;
	padding-top: 50px;
	overflow: hidden;
	background-color: white;
	height: 144px;
	min-width : 1000px;
}
.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}
.topnav a:hover {
	background-color: white;
	color: black;
}
div#topMenu {
    height: 86px;
    width: 87%;
    min-width: 1000px;
}
.sidenav {
    padding-left: 200px;
    padding-top : 4px;
    min-height: 759px;
    width: 420px;
    position: absolute;
    z-index: 0;
    left: 0;
    background-color: white;
    overflow-x: hidden;
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
#topMenu *{
display : inline-block;
}

/* 이름 클릭 드롭박스 */
	.logdropbtn {
	  border: none;
	  cursor: pointer;
	}

	.logdropdown {
  		position: relative;
  		display: inline-block;
	}

	.logdropdown-content {
	  display: none;
	  background : white;
	  position: absolute;
	  min-width: 160px;
	  overflow: auto;
	  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	  z-index: 1;
	}

	.logdropdown-content a {
	  padding: 12px 16px;
	  text-decoration: none;
	  display: block;
	}

	.logshow {display: block;}
	
</style>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.servletContext.contextPath }" scope="application"/>
	<div class="topnav">
		<div id="topMenu">
			<img id="mainLogo" width="80px" height="80px" src="resources/images/MainLogo.jpg" onclick="location.href ='home.do'">
			<div id ="link"><a href="#"	onClick="javascript:openWin()">미니홈피</a><a>일촌 신청하기</a><a>선물가게</a></div>
			<input type="button" value="BGM 상점">
		</div>
	</div>

	<div class="sidenav">
		<div id="leftLoginBox">LATTE WORLD</div>
		<c:if test="${empty sessionScope.UserInfo }">
			<div id = "leftLogin">
				<form action ="login.do" method = "post">
					<table>
						<tr>
							<td>이메일</td>
							<td><input type = "text" size = "10px" name = "userId"></td>
							<td rowspan = "2"><button>Login</button></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type = "password" size = "10px" name = "userPwd"></td>

						</tr>
					</table>
					<div id = "findZone">
						<label id ="findIdPw" onclick = "find()">이메일 / 비밀번호 찾기</label><br>
						<label id ="join" onclick = "register()">회원 가입하기</label>
					</div>
				</form>
			</div>
		</c:if>
		<c:if test = "${!empty sessionScope.UserInfo}">
			<div id="leftLogin">
				<img src="resources/images/pic2.jpg" height="130px"
					width="160px"><br>
					<div class="logdropdown">
						<button onclick="logmyFunction()" class="logdropbtn">${UserInfo.userName }</button>
						<div id="lognameDropdown" class="logdropdown-content">
							<a href="#" onclick = "openWin()">미니 홈피</a>
							<a href="#bf">BF 신청하기</a>
							<a href="#report">신고 하기</a>
						</div>
					</div>
					님 환영합니다 :)
				<button onclick = "location.href = 'receivelist.do' ">쪽지 보내기</button>
				<c:url var = "mypage" value = "mypage.do">
					<c:param name = "userId" value = "${UserInfo.userId }"/>
				</c:url>
				<button	onclick = "location.href = '${mypage}'">마이페이지</button>
				<button onclick="location.href ='logout.do'">로그아웃</button>
			</div>
		</c:if>	
		
		<div id="leftMenuBar">
			<div id="leftMenus">
			<c:if test = "${!empty sessionScope.UserInfo}">
				<c:url var = "findBF" value = "bfFind.do">
					<c:param name = "userId" value = "${UserInfo.userId }"/>
				</c:url>
			</c:if>
				<a onclick = "location.href='${findBF }'">BF 찾기</a>
				<p>내 미니홈피</p>
				<p>내 BF 보기</p>
				<p>공지사항</p>
				<p>고객센터</p>
			</div>
			<div id="addLeftMenus">
				<p>여다가는 뭘 넣지</p>
				<p>뭘느까</p>
				<p>음음</p>
				<p>뭣을 너으까</p>
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript">
	function register(){
		location.href = "join.do";
	}
	function find(){
		location.href = "findUser.do";
	}
	 var openwin;
	function openWin(){
	    openwin = window.open("minihome.do?userId=${UserInfo.userId}", 'win0', "width = 1420, height = 850, scroll = no, toolbar = no, menubar = yes, location = no, resizable = no");  
	} 
	
	</script>
	
<script>

	function logmyFunction() {
	  document.getElementById("lognameDropdown").classList.toggle("logshow");
	}
	
	
	window.onclick = function(event) {
	  if (!event.target.matches('.logdropbtn')) {
	    var logdropdowns = document.getElementsByClassName("logdropdown-content");
	    var i;
	    for (i = 0; i < logdropdowns.length; i++) {
	      var openDropdown = logdropdowns[i];
	      if (openDropdown.classList.contains('logshow')) {
	        openDropdown.classList.remove('logshow');
	      }
	    }
	  }
	}
</script>

</body>
</html>