<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userName = (String)request.getParameter("userName"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>라떼는</title>
<style>
#miniHome {
    height: 650px;
    width: 1216px;
    top: 40px;
    left: 50px;
    position: fixed;
}
#miniHome, #miniHome > div{
	border : 1px solid black;
}
#miniLeft {
    position: fixed;
    left: 50px;
    top: 40px;
    width: 199px;
    height: 650px;
}
#miniLeft > div{
	border : 1px solid blue;
}
#ownerInfo {
    height: 200px;
    position: fixed;
    left: 50px;
    top: 458px;
    width: 199px;
}
#profile {
    height: 360px;
    width: 199px;
    left: 50px;
    position: fixed;
    top: 97px;
}
#miniCenter {
    position: fixed;
    left: 250px;
    top: 97px;
    width: 870px;
    height: 593px;
}
#miniRight {
    position: fixed;
    width: 145px;
    left: 1121px;
    top: 40px;
    height: 650px;
}
#visitCheck {
    left: 50px;
    top: 40px;
    position: fixed;
}
#miniTitle{
	 position : fixed;
	 top: 40px;
	 left: 19%;
     width: 65.95%;
}
#latteWave {
    position: fixed;
    height: 31px;
    width: 199px;
    left: 50px;
    top: 659px;
}
div#minihomeMenu {
    position: fixed;
    left: 1034px;
    top: 170px;
}
</style>
</head>
<body onresize="parent.resizeTo(1320,800)" onload="parent.resizeTo(1320,800)" style="overflow-x:hidden; overflow-y:hidden;">
	<div id = "miniHome">
	<div id="visitCheck" style="height: 56px; width:  199px;"><label id="todayVisitCount">오늘의 방문자</label> / <label id="totalVisitCount">총 방문자</label></div>
	<div id = "miniTitle" style = "height : 56px">${UserInfo.userName }님의 미니홈피</div>
		<div id = "miniLeft">
			<div id = "profile">이미지를 하나 넣고나서 <br><br><br><br><br><br><br><br><br>ㄴr는 ㄱr끔 눙물을 흘린ㄷr...*<br><button id = "profileHistory">history</button></div>
			<div id = "ownerInfo">개인 정보<br>이름 : 김라떼<br>나이 : 20대 중반<br>이상형 : 현모양처<br>특기 : 개드립<br>방문자에게 하고싶은 말<br> : 볼 건 없지만 재밌게 보다 가세요!<br>방명록 / 일촌평은 쎈쓰!!!!<br>
			</div>
			<div id = "latteWave">
					<select id = "relateWave">
						<option>----</option>
						<option>일촌1</option>
						<option>일촌2</option>
						<option>일촌3</option>
						<option>일촌4</option>
					</select>
			</div>
		</div>
		
		<div id = "miniCenter" class = "mini2nd">
			<div id = "miniHomeImg">미니 홈페이지 꾸며놓은거 가져다 놓기</div>
			<div id = "relativeComments">일촌들이 글 싸지르는 공간</div>
		</div>
		
		<div id = "minihomeMenu">
			<button>홈</button><br>
			<button>프로필</button><br>
			<button>사진첩</button><br>
			<button>일반 게시판</button><br>
			<button>다이어리</button><br>
			<button>방명록</button><br>
			<button>Setting</button>
		
		</div>
		
		<div id = "miniRight" class = "mini2nd">
			<div id = "bgmBox">여기는 비쥐엠</div>
		</div>
	</div>
	
<script type="text/javascript">
	document.onkeydown=processKey;
	function processKey(){
		if(event.keyCode >= 112 && event.keyCode <= 123){
			event.keyCode = 0;
			event.cancelBubble = true;
			event.returnValue = false;
		}
		
	}
</script>
</body>
</html>