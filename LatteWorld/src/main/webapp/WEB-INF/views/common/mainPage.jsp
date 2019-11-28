<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
div#centerBottom {
    display: inline-flex;
    width : 100%;
} 
div#centerBottomLeft {
    width: 50%;
    height: 100%;
}
div#centerBottomRight {
    width: 50%;
    height: 100%;
}
#centerBottom * {
border : 1px solid blue;
}
#centerBottomLeft *{
height : auto;
}
#centerBottomRight *{
height : 33%;
}
#goodMessage *{
width : 50%;}

</style>
</head>
<body>
	<jsp:include page="mainMenuBar.jsp"/>
	<div class="content">
		<div id="goodMessage">
			<img src="resources/images/mainContent.jpg"
				height="200px" width="500px">
		</div>

		<div id="search">
			<select id="searchMenu">
				<option value="all">전체검색</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
				<option value="writer">작성자</option>
			</select> <input style="width: 350px" id="searchContent"
				placeholder="라떼는 이렇게 검색헀어...!">
			<button id="searchBtn">찾 기</button>
		</div>

		<div id="centerBottom">
			<div id="centerBottomLeft">
				<div id="todayNews">라떼는 이런게 핫했다!<br><br><br><br><br><br><br></div>
				<div id="todayHomepage">오늘의 홈페이지</div>
				<div id="todayMember">오늘의 핫피플</div>
			</div>
			<div id="centerBottomRight">
				<div id="todayWriter">최고의 글</div>
				<div id="purchase">선물가게</div>
				<div id="events">이벤트</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"/>
	

</body>
</html>