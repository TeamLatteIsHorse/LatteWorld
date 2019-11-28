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
<h1 align="center">받은 쪽지함</h1>
	
	
	
		<table align="center" border="1" cellspacing="0" width="800" id="receiveMessage">
		<tr>
			<th><input type="checkbox" id="checkall"></th>
			<th>보낸사람</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="r" items="${list }">
		<input type="hidden" name="messageNo" value="${r.messageNo}"/>
		<tr>
			<td align="center"><input type="checkbox" class="chk" name="chk"></td>
			<td align="center">${r.receiveId }</td>
			<td align="center">
				<c:url var="rdetail" value="receiveMessage.do">
					<c:param name="messageNo" value="${r.messageNo }"/>
					<c:param name="page" value="${pi.currentPage }"/>
					<a href="${receiveMessage }">${r.content }</a>
				</c:url>
			</td>
			<td align="center">${r.sendDate }</td>
		</tr>
		</c:forEach>
		
		<tr align="center" height="15">
			<td colspan="4">
				<c:if test="${pi.currentPage ==1 }">
					이전
				</c:if>
				
				<c:if test="${pi.currenPage > 1 }">
					<c:url var = "rlistBack" value="/receivelist.do">
						<c:param name="page" value="${pi.currendPage - 1 }"/>
					</c:url>
					<a href="${rlistBack }">이전</a>
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
	 					<c:url var="rlistEnd" value="rlist.do">
	 						<c:param name="page" value="${pi.currentPage + 1 }"/>
	 					</c:url>
	 					<a href="${rlistEnd }">&nbsp;[다음]</a>
	 				</c:if>
			</td>
		</tr>
		<tr>
			<td><button>쪽지쓰기</button></td>
			<td><button>삭제하기</button>
		</tr>
		</table>	
	
		
	
	
	
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
		
		
		
		
		
		
		
	</script>
	
	<jsp:include page="../common/footer.jsp"/>
</body>
</html>