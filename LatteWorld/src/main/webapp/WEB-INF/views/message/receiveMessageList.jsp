<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<style>

</style>

</head>
<body>
<jsp:include page ="../common/mainMenuBar.jsp"/>
	
	<div class = "content">
	<h1 align="center">받은 쪽지함</h1>
		<div class = "etcbutton">
			<input type="button" onclick="location.href='eraselist.do'" value="휴지통">
			<input type="button" onclick="location.href='sendlist.do'" value="보낸 쪽지함">
		</div>
		<table align="center" border="1" cellspacing="0" width="800" id="receiveMessage">
		<tr>
			<th width="20"><input type="checkbox" id="checkall"></th>
			<th>보낸사람</th>
			<th width="300">내용</th>
			<th>날짜</th>
		</tr>
		<c:if test="${!empty list }">
		<c:forEach var="r" items="${list }">
		<input id="messageNo" type="hidden" name="messageNo" value="${r.messageNo}"/>
		<input id="messageStatus" type="hidden" name="messageStatus" value="${r.messageStatus }"/>	
		<tr>
			<td align="center"><input type="checkbox" class="chk" name="chk" value="${r.messageNo }"></td>
			<td align="center">${r.sendId }</td>
			<%-- <c:if test="${r.messageStatus } " eq N> --%>
			<td align="center">
					<a href="#" onclick="receiveOpenWin()">${r.messageContent }</a>
			</td>
			<%-- </c:if> --%>
			<td align="center">${r.sendDate }</td>
		</tr>
		</c:forEach>
		</c:if>
		<c:if test="${ empty list}">
		<tr>
			<td align="center" colspan="5">
				쪽지가 없습니다.
			</td>
		</tr>
		</c:if>
		
		<tr align="center" height="15">
			<td colspan="4">
				<c:if test="${pi.currentPage ==1 }">
					[이전]
				</c:if>
				
				<c:if test="${pi.currentPage > 1 }">
					<c:url var = "rlistBack" value="receivelist.do">
						<c:param name="page" value="${pi.currentPage - 1 }"/>
					</c:url>
					<a href="${rlistBack }">[이전]</a>
				</c:if>
				
				<c:forEach var = "p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:if test="${p eq pi.currentPage }">
						<font color = "red" size="3"><b>[${p }]</b></font>
					</c:if>

					
					<c:if test="${p ne pi.currentPage }">
						<c:url var="rlistCheck" value="receivelist.do">
							<c:param name="page" value="${p }"/>
						</c:url>
						<a href="${rlistCheck }">${p }</a>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage == pi.maxPage }">
	 					[다음]
	 				</c:if>
	 				
	 				<c:if test="${pi.currentPage < pi.maxPage }">
	 					<c:url var="rlistEnd" value="receivelist.do">
	 						<c:param name="page" value="${pi.currentPage + 1 }"/>
	 					</c:url>
	 					<a href="${rlistEnd }">&nbsp;[다음]</a>
	 				</c:if>
			</td>
		</tr>
		<tr>
			<td><button onclick="sendMessageOpen()">쪽지쓰기</button> 
				<button id="eraseM">삭제하기</button></td>
			
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
		
		//체크된거 휴지통으로
		$("#eraseM").click(function(){
			var chk="";
			$("input[name='chk']:checked").each(function(){
				chk=chk+$(this).val()+",";
			});
			chk=chk.substring(0,chk.lastIndexOf(","));
			
			if(chk==''){
				alert("쪽지를 선택하세요");
				return false;
			}
			
			if(confirm("휴지통으로 보내시겠습니까?")){
				location.href="eraseMessage.do?chk="+chk;
			}
		})
		
		var receiveOpenWin;
		function receiveOpenWin(){
			var messageNo = $("#messageNo").val();
			var messageStatus=$("#messageStatus").val();
			if(messageStatus=='N'){
			location.href="updateMessageStatus.do?messageNo="+messageNo;
			}
			window.open("receiveMDetail.do?messageNo="+messageNo ,'win0',"width =400, height=600, scroll=no, toolbar=no, menubars=no, location=no, resizable=no ");
		}
		var sendMessageOpen;
		function sendMessageOpen(){
			window.open("sendMessageGo.do", 'win00',"width=400, height=600, scroll=no, toolbar=no, menubar=no, location=no, resizable=no");
		}
		
		
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>