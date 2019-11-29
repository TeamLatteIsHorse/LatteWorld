<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src = "http://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
	.content {
	    margin-left: 423px;
	    margin-top: 4px;
	    margin-bottom: 4px;
	    padding : 0 !important;
	  	width : 1300px !important; 
	  	height : auto !important; 
	  	border : 1px solid red;
	  	
	}
	
	#hitItem{
		margin : 5px;
		border : 1px dashed blue;
		width : 800px;
		height : auto;
		
	}
	.hitItemArea{
		margin : 10px;
		margin-top : 0;
		display : inline-block;
		width : auto;
		height : 250px;
		border : 1px dashed green;
	}
	
	.hitItemImg{
		width : auto;
		height : 120px;
		border : 1px solid black;
		margin-right : auto;
		margin-left : auto;
		margin-top : 10px;
		margin-bottom : 10px;
		text-align : center;
		background-size: cover;
		
	}
	
	#ItemStore{
		margin : 5px;
		width : 1300px;
		height : 500px;
		border : 1px solid blue;
		display : table;
	}
	.itemArea{
		margin : 10px;
		margin-top : 0;
		display : inline-block;
		width : auto;
		height : 230px;
		border : 1px dashed green;
	}
	.itemImg{
		width : auto;
		height : 120px;
		border : 1px solid black;
		margin-right : auto;
		margin-left : auto;
		margin-top : 10px;
		margin-bottom : 10px;
		text-align : center;
		background-size: cover;
	}
	.content img{
		
		height : 100%;
	}
</style>
</head>
<body>
	<jsp:include page="../common/mainMenuBar.jsp"/>
	
	<div class = "content">
	<h2>인기 상품</h2>
		<div id = "hitItem">
			<c:forEach var = "bis" items = "${bestItemList}">
				<div class = "hitItemArea">
					<p style = "text-align : left; margin : 0; margin-left : 15px; color : gold;" >
						best!
					</p>
					<div class = "hitItemImg">
						<img src="${contextPath}/resources/itemImages/${bis.itemLink}">
					</div>
					<p style = "text-align : center; margin : 5px">
						[${bis.itemCategory}]
						${bis.itemName}<br>
						가격 : 잣 ${bis.price}개
					</p>
					<button>구매하기</button>&nbsp;
					<button>선물하기</button>&nbsp;
					<button>찜하기</button>
				</div>
			</c:forEach>
			
			<div id="hitItemSearch" style = "margin-left : 10px;">
				<select id="searchItem">
					<option value="all">전체검색</option>
					<option value="miniBackground">미니미배경</option>
					<option value="minimi">미니미</option>
					<option value="pet">펫</option>
					<option value="diaryBackground">다이어리배경</option>
				</select>
				<button>검색</button>
			</div>
		</div>
<h2>아이템샵</h2>	
		<div id = "ItemStore">
			<div style = "width : 1300px; height : 470px;">
			
				<c:forEach var = "iList" items = "${itemList}">
					
					<div class = "itemArea">
						<div class = "itemImg">
							<img src="${contextPath}/resources/itemImages/${iList.itemLink}">
						</div>
						<p style = "text-align : center; margin : 5px">
							[${iList.itemCategory}]
							${iList.itemName}<br>
							가격 : 잣 ${iList.price}개
						</p>
						<%-- <c:if test="${!empty UserInfo}"> --%>
							<c:url var = "buyItem" value = "buyItem.do">
								<c:param name="itemNo" value = "${iList.itemNo}"/>
							</c:url>
							<button onclick = "location.href = '${buyItem}'">구매하기</button>&nbsp;
							
							<c:url var = "presentItem" value = "presentItem.do">
								<c:param name="itemNo" value = "${iList.itemNo}"/>
							</c:url>
							<button onclick = "location.href = '${presentItem}'">선물하기</button>&nbsp;
							
							<input type = "hidden" id = "hiddemItemNo" value = "${iList.itemNo}">
							<button id = "kip" class= "kipItem">찜하기</button>
							<!-- 구매, 선물은 이 방식으로 해도되는데 찜하기는 ajax이용해야되서 script에서 값 받아줘야됨.... -->
						<%-- </c:if> --%>
						
						<%-- <c:if test="${empty UserInfo}">
							<button onclick = "login()">구매하기</button>&nbsp;
							<button onclick = "login()">선물하기</button>&nbsp;
							<button onclick = "login()">찜하기</button>
						</c:if> --%>
						
					</div>
				</c:forEach>
			</div>	
			<br>
			<div id = "pagingArea" align = "center" >
				<!-- [이전] -->
	 				<c:if test="${pi.currentPage == 1 }">
	 					[이전]&nbsp;
	 				</c:if>
	 				
	 				<c:if test="${pi.currentPage > 1 }">
	 					<c:url var="itemListBack" value="itemStoreList.do">
	 						<c:param name="page" value="${pi.currentPage - 1 }"/>
	 					</c:url>
	 					<a href="${itemListBack}">[이전]</a>
	 				</c:if>
	 				
	 				<!-- [번호들] -->
	 				<c:forEach var="p" begin="${pi.startPage }" end="${pi.endPage }">
	 					<c:if test="${p eq pi.currentPage }">
	 						<font color="red" size="4"><b>[${p}]</b></font>
	 					</c:if>
	 					
	 					<c:if test="${p ne pi.currentPage }">
	 						<c:url var="itemListCheck" value="itemStoreList.do">
	 							<c:param name="page" value="${p }"/>
	 						</c:url>
	 						<a href="${itemListCheck}">${p }</a>
	 					</c:if>
	 				</c:forEach>
	 				
	 				<!-- [다음] -->
	 				<c:if test="${pi.currentPage == pi.maxPage }">
	 					&nbsp;[다음]
	 				</c:if>
	 				
	 				<c:if test="${pi.currentPage < pi.maxPage }">
	 					<c:url var="itemListEnd" value="itemStoreList.do">
	 						<c:param name="page" value="${pi.currentPage + 1 }"/>
	 					</c:url>
	 					<a href="${itemListEnd }">&nbsp;[다음]</a>
	 				</c:if>
			</div>
			
			<div id="itemSearch" style = "margin-left : 10px; ">
				<select id="searchItem">
					<option value="all">전체검색</option>
					<option value="miniBackground">미니미배경</option>
					<option value="minimi">미니미</option>
					<option value="pet">펫</option>
					<option value="diaryBackground">다이어리배경</option>
				</select>
				<input type = "text" style="width : 100px" id="searchContent" placeholder="검색">
				<button>검색</button>
			</div>
		</div>
	</div>
	<script>
		function login(){
			alert("로그인이 필요합니다!");
		}

		$(function(){
			$(".kipItem").click(function(){
				var itemNo = $(this).parents().find("input[id='hiddemItemNo']").val();
				
				console.log(itemNo);
			})
		});
		
	</script>

	<jsp:include page="../common/footer.jsp"/>
</body>
</html>