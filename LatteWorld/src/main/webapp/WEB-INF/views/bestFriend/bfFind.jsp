<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src = "http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<title>게 씨판</title>
<style>
	#bfFindTable td{
	height : 33px;
	}
	.dropbtn {
	  border: none;
	  cursor: pointer;
	}

	.dropdown {
  		position: relative;
  		display: inline-block;
	}

	.dropdown-content {
	  display: none;
	  position: absolute;
	  min-width: 160px;
	  overflow: auto;
	  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
	  z-index: 1;
	}

	.dropdown-content a {
	  padding: 12px 16px;
	  text-decoration: none;
	  display: block;
	}

	.show {display: block;}
	
</style>
</head>
<body>
	<jsp:include page = "../common/mainMenuBar.jsp"/>
	
	<!-- 로그인 한 회원만 게시물을 보기 위해서 다음과 같은 조건 추가 -->
	<c:if test="${!empty UserInfo }">
		<div id = "content">
		<br>
		<h1 align = "center">BF 찾기</h1>
		
		<div id = "searchArea" align = "center">
			<c:if test="${!empty bfsc}">
				<label>검색 조건</label>
				<input id = "searchType" type = "hidden" value = "${bfsc.bfType }">
				<select id = "searchCondition" name = "bfType">
					<option>-----------</option>
					<option value = "all">전체</option>
					<option value = "id">아이디</option>
					<option value = "name">이름</option>
				</select>
				<input type = "search" id = "searchValue" value = "${bfsc.bfValue }">
				
				<button onclick = "searchBoard()">검색하기</button>
			</c:if>
			<script type="text/javascript">	
				$("#searchCondition").val($("#searchType").val());
			</script>
			<c:if test="${empty bfsc}">
				<label>검색 조건</label>
				<select id = "searchCondition" name = "bfType">
					<option>-----------</option>
					<option value = "all">전체</option>
					<option value = "id">아이디</option>
					<option value = "name">이름</option>
				</select>
				<input type = "search" id = "searchValue" name = "bfValue">
				<button onclick = "searchBoard()">찾기</button>
			</c:if>
		</div>
		<script>
			function searchBoard(){
				var searchCondition = $("#searchCondition").val();
				var searchValue = $("#searchValue").val();
				location.href = "search.do?bfType="+searchCondition+"&bfValue="+searchValue;
			}
		</script>
			<table id = "bfFindTable" align = "center" width = "800" align = "center" border = "1px" cellspacing = "0">
				<tr>
					<th>아이디</th>
					<th>이름</th>
				</tr>
			<c:if test="${empty bfList }">
				<tr>
					<td colspan = "3" rowspan ="4">검색되는 유저가 없습니다.</td>
				</tr>					
			</c:if>

				<c:forEach var = "b" items="${bfList }">
					<tr>
						<td>
							<div class="dropdown">
								<button onclick="myFunction()" class="dropbtn">${b.userId }</button>
								<div id="nameDropdown" class="dropdown-content">
									<a href="#home">미니 홈피</a>
									<a href="#bf">일촌 신청</a>
									<a href="#report">신고 하기</a>
								</div>
							</div>
						</td>
						<td>${b.userName }</td>
					</tr>
				</c:forEach>
			</table>
			
			
			<c:if test="${empty bfsc}">
			<!-- 페이징 부분 -->		
			<div id = "pagingArea" align = "center">
				<!-- [이전] -->
				<c:if test = "${pi.currentPage <= 1 }">
					[이전]&nbsp;
				</c:if>
				<c:if test="${pi.currentPage>1 }">
					<c:url var="blistBack" value = "/selectList.bo">
						<c:param name="currentPage" value = "${pi.currentPage -1 }"/>
					</c:url>
					<a href = "${blistBack }">[이전]</a>
				</c:if>
				<!-- [번호들] -->
				<c:forEach var ="p" begin = "${pi.startPage }" end = "${pi.endPage }">
					<c:if test="${p eq pi.currentPage }">
						<font color = "red" size ="4"><b>[${p }]</b></font>
					</c:if>
					<c:if test="${p ne pi.currentPage }">
						<c:url var="blistCheck" value = "selectList.bo">
							<c:param name = "currentPage" value = "${p }"/>
						</c:url>
						<%-- <a href = "${contextPath }/selectList.bo?currentPage=${p}">${p }</a> --%>
 						<a href = "${blistCheck }">${p }</a>
					</c:if>
				</c:forEach>
				
				<!-- [다음] -->
				<c:if test = "${pi.currentPage >= pi.maxPage }">
					&nbsp;[다음]
				</c:if>
				<c:if test = "${pi.currentPage < pi.maxPage}">
					<c:url var = "blistEnd" value = "selectList.bo">
						<c:param name = "currentPage" value = "${pi.currentPage+1}"/>
					</c:url>
					<a href = "${blistEnd }">&nbsp;[다음]</a>
				</c:if>
			</div>
			</c:if>
			<c:if test="${!empty bfsc}">
			<!-- 페이징 부분 -->		
			<div id = "pagingArea" align = "center">
				<!-- [이전] -->
				<c:if test = "${pi.currentPage <= 1 }">
					[이전]&nbsp;
				</c:if>
				<c:if test="${pi.currentPage>1 }">
					<c:url var="blistBack" value = "/search.bo">
						<c:param name="currentPage" value = "${pi.currentPage -1 }"/>
						<c:param name ="searchCondition" value = "${sc.type }"/>
						<c:param name ="searchValue" value = "${sc.value }"/>
					</c:url>
					<a href = "${blistBack }">[이전]</a>
				</c:if>
				<!-- [번호들] -->
				<c:forEach var ="p" begin = "${pi.startPage }" end = "${pi.endPage }">
					<c:if test="${p eq pi.currentPage }">
						<font color = "red" size ="4"><b>[${p }]</b></font>
					</c:if>
					<c:if test="${p ne pi.currentPage }">
						<c:url var="blistCheck" value = "search.bo">
							<c:param name = "currentPage" value = "${p }"/>
							<c:param name ="searchCondition" value = "${sc.type }"/>
							<c:param name ="searchValue" value = "${sc.value }"/>
						</c:url>
 						<a href = "${blistCheck }">${p }</a>
					</c:if>
				</c:forEach>
				
				<!-- [다음] -->
				<c:if test = "${pi.currentPage >= pi.maxPage }">
					&nbsp;[다음]
				</c:if>
				<c:if test = "${pi.currentPage < pi.maxPage}">
					<c:url var = "blistEnd" value = "search.bo">
						<c:param name = "currentPage" value = "${pi.currentPage+1}"/>
						<c:param name ="searchCondition" value = "${sc.type }"/>
						<c:param name ="searchValue" value = "${sc.value }"/>
					</c:url>
					<a href = "${blistEnd }">&nbsp;[다음]</a>
				</c:if>
			</div>
			</c:if>

			
			
			<!--	게시글 상세 보기 -->
			<script type="text/javascript">
				$(function(){
					$("#boardArea").find("td").mouseenter(function(){
						$(this).parents("tr").css({"background":"orangered","cursor":"pointer"});
					}).mouseout(function(){
						$(this).parents("tr").css({"background":"black"});
					}).click(function(){
						var bId = $(this).parents().children("td").eq(0).text();
						location.href = "selectOne.bo?bId="+bId;
					});
				});
			
			</script>
		</div>
	</c:if>
	<c:if test="${empty UserInfo }">
		<c:set var = "message" value="로그인이 필요한 서비스 입니다." scope = "request"/>
		<jsp:forward page = "../common/errorPage.jsp"/>
	</c:if>
	<jsp:include page = "../common/footer.jsp"/>

<script>

function myFunction() {
  document.getElementById("nameDropdown").classList.toggle("show");
}


window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
</script>
	
</body>
</html>