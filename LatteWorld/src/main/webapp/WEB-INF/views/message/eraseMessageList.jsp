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
		<h1 align="center">휴지통</h1>
		<div class = "etcbutton">
			<input type="button" onclick="location.href='receivelist.do'" value="받은 쪽지함">
			<input type="button" onclick="location.href='sendlist.do'" value="보낸 쪽지함">
		</div>
		<table align="center" border="1" cellspacing="0" width="800" id="receiveMessage">
		<tr>
			<th><input type="checkbox" id="checkall"></th>
			<th>보낸사람</th>
			<th width="300">내용</th>
			<th>날짜</th>
		</tr>
		<c:if test="${!empty list }">
		<c:forEach var="e" items="${list }">
		<input type="hidden" name="messageNo" value="${e.messageNo}"/>
		<tr>
			<td align="center"><input type="checkbox" class="chk" name="chk" value="${e.messageNo }"></td>
			<td align="center">${e.sendId }</td>
			<td align="center">
				<c:url var="edetail" value="receiveMessage.do">
					<c:param name="messageNo" value="${e.messageNo }"/>
					<c:param name="page" value="${pi.currentPage }"/>
				</c:url>
					<a href="${receiveMessage }">${e.messageContent }</a>
			</td>
			<td align="center">${e.sendDate }</td>
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
					<c:url var = "elistBack" value="eraselist.do">
						<c:param name="page" value="${pi.currentPage - 1 }"/>
					</c:url>
					<a href="${elistBack }">&nbsp;[이전]</a>
				</c:if>
				
				<c:forEach var = "p" begin="${pi.startPage }" end="${pi.endPage }">
					<c:if test="${p eq pi.currentPage }">
						<font color = "red" size="3"><b>[${p }]</b></font>
					</c:if>
					
					<c:if test="${p ne pi.currentPage }">
						<c:url var="elistCheck" value="eraselist.do">
							<c:param name="page" value="${p }"/>
						</c:url>
						<a href="${rlistCheck }">${p }</a>
					</c:if>
				</c:forEach>
				<c:if test="${pi.currentPage == pi.maxPage }">
	 					[다음]
	 				</c:if>
	 				
	 				<c:if test="${pi.currentPage < pi.maxPage }">
	 					<c:url var="elistEnd" value="eraselist.do">
	 						<c:param name="page" value="${pi.currentPage + 1 }"/>
	 					</c:url>
	 					<a href="${elistEnd }">&nbsp;[다음]</a>
	 				</c:if>
			</td>
		</tr>
		<tr>
			<td><button id="rewindM">복원하기</button> <button id="deleteM">삭제하기</button></td>
			
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
		//체크된거 삭제
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
				location.href="eraseMessage.do?chk="+chk;
			}
		})
		//복원시키기
		$("#rewindM").click(function(){
			var chk="";
			$("input[name='chk']:checked").each(function(){
				chk=chk+$(this).val()+",";
			});
			chk=chk.substring(0,chk.lastIndexOf(","));
			
			if(chk==''){
				alert("쪽지를 선택하세요");
				return false;
			}
			
			if(confirm("복원 하시겠습니까?")){
				location.href="rewindMessage.do?chk="+chk;
			}
		})
		
		
		
		
		
		
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>