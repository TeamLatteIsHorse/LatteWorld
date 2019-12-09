<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>

</head>
<body>
	<jsp:include page ="../common/mainMenuBar.jsp"/>
	
	
	
	<div class="content">
		<h1 align="center">보낸 쪽지함</h1>
		<div class = "etcbutton">
			<input type="button" onclick="location.href='receivelist.do'" value="받은 쪽지함">
			<input type="button" onclick="location.href='eraselist.do'" value="휴지통">
		</div>
		<table align="center" border="1" cellspacing="0" width="800" id="sendMessage">
		<tr>
			<th><input type="checkbox" id="checkall"></th>
			<th>받은사람</th>
			<th width="300">내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="s" items="${list }">
		<input id="messageNo" type="hidden" name="messageNo" value="${s.messageNo}"/>
		<tr>
			<td align="center"><input type="checkbox" class="chk" name="chk" value="${s.messageNo }"></td>
			<td align="center">${s.sendId }</td>
			<td align="center">
			<a href="#" onclick="sendOpen()"> ${s.messageContent }</a>
			</td>
			<td align="center">${s.sendDate }</td>
		</tr>
		</c:forEach>
		
		<tr align="center" height="15">
			<td colspan="4">
				<c:if test="${pi.currentPage ==1 }">
					[이전]
				</c:if>
				
				<c:if test="${pi.currentPage > 1 }">
					<c:url var = "slistBack" value="sendlist.do">
						<c:param name="page" value="${pi.currentPage - 1 }"/>
					</c:url>
					<a href="${slistBack }">[이전]</a>
				</c:if>
				
				<c:forEach var = "p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:if test="${p eq pi.currentPage }">
						<font color = "red" size="3"><b>[${p }]</b></font>
					</c:if>

					
					<c:if test="${p ne pi.currentPage }">
						<c:url var="slistCheck" value="sendlist.do">
							<c:param name="page" value="${p }"/>
						</c:url>
						<a href="${slistCheck }">${p }</a>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage == pi.maxPage }">
	 					[다음]
	 				</c:if>
	 				
	 				<c:if test="${pi.currentPage < pi.maxPage }">
	 					<c:url var="slistEnd" value="sendlist.do">
	 						<c:param name="page" value="${pi.currentPage + 1 }"/>
	 					</c:url>
	 					<a href="${slistEnd }">&nbsp;[다음]</a>
	 				</c:if>
			</td>
		</tr>
		<tr>
			<td>
			<button>쪽지쓰기</button>
			<button id="deleteM">삭제하기</button>
			</td>
		</tr>
		</table>	
	</div>	
	
	
	
	
	<script>
		//체크박스 전체선택및 전체해제
		
		$("#checkall").click(function(){
			if($("#checkall").is(":checked")){
				$(".chk").prop("checked", true);
			}else{
				$(".chk").prop("checked",false);
			}
		});
		
		
		//한개의 체크박스 선택 해제 시 전체선택 체크박스도 해제
		$(".chk").click(function(){
			if($("input[name='chk']:checked").length =="#"){
				$("#checkall").prop("checked",true);
			}else{
				$("#checkall").prop("checked",false);
			}
		});
		
		//삭제하기
		$("#deleteM").click(function(){
			var chk="";
			$("input[name='chk']:checked").each(function(){
				chk=chk+$(this).val()+",";
			});
			chk=chk.substring(0,chk.lastIndexOf(","));
			
			if(chk==''){
				alert("쪽지를 선택하세요");
				return false;
			}
			
			if(confirm("삭제 하시겠습니까?")){
				location.href="deleteMessage.do?chk="+chk;
			}
		})
		
		var sendOpen;
		function sendOpen(){
			var messageNo = $("#messageNo").val();
			sendOpen = window.open("sendMessageDetail.do?messageNo="+messageNo,'win0',"width=400,height=600, scroll=no, toolbar=no, menubars=no, location=no, resizable=no");
		}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>