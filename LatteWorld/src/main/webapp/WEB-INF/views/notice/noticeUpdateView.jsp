<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <jsp:include page="../common/menubar.jsp"/>	 --%>
	
	<h1 align="center">공지글 수정 페이지</h1>
	
	<br><br>
	
	<form action="nupdate.do" method="post" enctype="Multipart/form-data">
	<!-- 첨부파일도 수정할 수 있으니깐 form태그에 enctype은 multipart로 하자 -->
		
		<!-- 화면에 뿌려줄 필요 x, 사용자가 입력할 필요는 x지만 쿼리에서 필요한 것들 -->
		<input type="hidden" name="nId" value="${notice.nId }"/>
		<!-- 파일을 수정했다면 기존 파일은 지우기 위해 기존 파일명도 넘기자-->
		<input type="hidden" name="filePath" value="${notice.filePath }"/>
		
		
		<table align="center" border="1" cellspacing="0" width="400">
			<tr>
				<td>제목</td>
				<td>
					<input type="text" size="50" name="nTitle" value="${notice.nTitle }">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>
				<input type="text" size="50" name="nWriter" value="${notice.nWriter }">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
				<input type="text" size="50" name="nContent" value="${notice.nContent }">
				</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<input type="file" name="reloadFile">
					<c:if test="${!empty notice.filePath }">
						<br>현재 업로드한 파일:
						<img src="${contextPath }/resources/nuploadFiles/${notice.filePath}">
						<a href="${contextPath }/resources/nuploadFiles/${notice.filePath }" download>
						</a>
					</c:if>
					<br>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form>
	
	<p align="center">
		<a href="home.do">시작 페이지로 이동</a>
		<a href="nlist.do">목록 보기로 이동</a>
		<a href="javascript:history.go(-1);">이전 페이지로 이동</a>
	</p>
	
	
	
	
	
	
</body>
</html>