<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:include page="../common/menubar.jsp"/> --%>	
	
	<h1 align="center">${notice.nId }번 글 상세 보기</h1>
	
	<br><br>
	
	<table align="center" border="1" cellspacing="0" width="400">
		<tr>
			<td>번호</td>
			<td>${notice.nId }</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${notice.nTitle }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${notice.nWriter }</td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td>${notice.nCreateDate }</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${notice.nContent }</td>
		</tr>
		<c:if test="${!empty notice.filePath }">
			<tr>
				<td>첨부파일</td>
				<td>
					<img src="${contextPath }/resources/nuploadFiles/${notice.filePath}">
					<br>
					<a href="${contextPath }/resources/nuploadFiles/${notice.filePath}" download>
						${notice.filePath }
					</a>
				</td>
			</tr>
		</c:if>
		
		<!-- 공지사항 쓰기와 공지사항 상세보기가 끝나면 이제 수정이랑 삭제를 해보자. -->
		<c:url var="nupView" value="nupView.do">
			<c:param name="nId" value="${notice.nId }"/>
		</c:url>
		<c:url var="ndelete" value="ndelete.do">
			<c:param name="nId" value="${notice.nId }"/>
		</c:url>
		<c:if test="${loginUser.id eq notice.nWriter }">
			<tr>
				<td colspan="2" align="center">
					<a href="${nupView }">수정 페이지로 이동</a> &nbsp;&nbsp;
					<a href="${ndelete }">삭제하기</a>
				</td>
			</tr>
		</c:if>
		
	</table>
	<!-- 일단은 여기까지 하고 공지사항 글쓰기를 완성해보자 noticeListView로 ㄱㄱ-->
	
	
	
	
	
	
</body>
</html>