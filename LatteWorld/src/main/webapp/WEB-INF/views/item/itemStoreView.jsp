<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
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
		<button style = "width : 50px !important;" onclick = "goKipItemView()">찜목록 이동</button>
		<button style = "width : 50px !important;" onclick = "goSendPresent()">보낸 선물함</button>
		<button style = "width : 50px !important;" onclick = "goReceivePresent()">받은 선물함</button>
		<button style = "width : 50px !important;" onclick = "gohaveItemList()">보유 아이템</button>
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
					<c:if test="${!empty UserInfo}">
						<c:url var = "buyItemView" value = "buyItemView.do">
							<c:param name="itemNo" value = "${bis.itemNo}"/>
						</c:url>
						<button class = "buyItem" value = "${bis.itemNo}" onclick = "location.href = '${buyItemView}'">구매하기</button>&nbsp;
						
						<c:url var = "presentItem" value = "presentItem.do">
							<c:param name="itemNo" value = "${bis.itemNo}"/>
						</c:url>
						<button onclick = "location.href = '${presentItem}'">선물하기</button>&nbsp;
							
						<button class= "kipItem" value = "${bis.itemNo}">찜하기</button>	
					</c:if>
					
					<c:if test="${empty UserInfo}">
						<button onclick = "login()">구매하기</button>&nbsp;
						<button onclick = "login()">선물하기</button>&nbsp;
						<button onclick = "login()">찜하기</button>
					</c:if>
				</div>
			</c:forEach>
			
			<div id="hitItemSearch" style = "margin-left : 10px;">
				<select id="searchItem">
					<option value="miniBackground" selected>미니미배경</option>
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
						<c:if test="${!empty UserInfo}">
							<c:url var = "buyItemView" value = "buyItemView.do">
							<c:param name="itemNo" value = "${iList.itemNo}"/>
						</c:url>
						<button class = "buyItem" value = "${iList.itemNo}" onclick = "location.href = '${buyItemView}'">구매하기</button>&nbsp;
							
						<c:url var = "presentItem" value = "presentItem.do">
							<c:param name="itemNo" value = "${iList.itemNo}"/>
						</c:url>
						<button onclick = "location.href = '${presentItem}'">선물하기</button>&nbsp;
								
						<button class= "kipItem" value = "${iList.itemNo}">찜하기</button>	
						</c:if>
						
						<c:if test="${empty UserInfo}">
							<button onclick = "login()">구매하기</button>&nbsp;
							<button onclick = "login()">선물하기</button>&nbsp;
							<button onclick = "login()">찜하기</button>
						</c:if>
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
		<input id = "hiddenId" type = "hidden" value = "${UserInfo.userId}">
	</div>
	<script>
		function login(){
			alert("로그인이 필요합니다!");
		}
		
		function goKipItemView(){
			var userId = $("#hiddenId").val();
			
			location.href = "kipItemView.do?userId="+userId;
		}
		
		function goSendPresent(){
			var userId = $("#hiddenId").val();
			location.href = "sendItemView.do?userId="+userId;
		}
		
		function goReceivePresent(){
			var userId = $("#hiddenId").val();
			location.href = "receiveItemView.do?userId="+userId;
		}
		
		function gohaveItemList(){	// 이거 아직 안되있어
			var userId = $("#hiddenId").val();
			location.href = "receiveItemView.do?userId="+userId;
		}

		$(function(){
			var kipItemNo = ${kipItemNo};	// controll에서 가져온 유저가 현재 찜목록+보유아이템 에 추가되어있는 아이템번호 리스트 
			var buyItemNo = ${buyItemNo};
			
			for(var i in buyItemNo){
				$('.buyItem[value = "'+buyItemNo[i]+'"]').attr('disabled', true);
				$('.buyItem[value = "'+buyItemNo[i]+'"]').css('background', 'red');
				$('.kipItem[value = "'+buyItemNo[i]+'"]').css('background', 'yellowgreen').addClass('alreadyBuy');
			}
			
			for(var i in kipItemNo){
				//$('.kipItem[value = "'+kipItemNo[i]+'"]').attr('disabled', true);
				$('.kipItem[value = "'+kipItemNo[i]+'"]').css('background', 'green').addClass('already');
			}
			
			$(".kipItem").click(function(){
				var itemNo = $(this).val();
				var userId = $("#hiddenId").val();
				var kipCount = ${kipCount};
				
				if($(this).hasClass('already')){
					alert("이미 찜목록에 등록되어있는 아이템입니다.");
				}else if($(this).hasClass('alreadyBuy')){
					alert("이미 구매한 아이템입니다.");
				}else{
					if(kipCount > 10){
						alert("찜목록은 최대 10개까지 등록가능합니다.");
					}else{
						$.ajax({
							url:"kipItem.do",
							data:{itemNo:itemNo,userId:userId},
							type:"post",
							success:function(data){
								if(data=="ok"){
									$('.kipItem[value = "'+itemNo+'"]').css('background', 'green').addClass('already');
									var check = confirm("찜목록에 추가되었습니다. 장바구니로 이동하시겠습니까?");
									if(check == true){
										location.href = "kipItemView.do?userId="+userId;
									}
								}
							},
							error:function(request, status, errorData){
								alert("error code : "+request.status + "\n" + 
										"message : " + request.responseText + 
										"error : " + errorData);
							}
						})
					}
				}

			})
		});
	</script>

	<jsp:include page="../common/footer.jsp"/>
</body>
</html>