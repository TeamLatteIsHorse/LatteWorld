<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
			<tr>
				<td>받은이 : </td>
				<td>${m.receiveId } (${m.sendDate })</td>
			</tr>
			<tr>
				<td>내용</td>
			</tr>
			<tr>
				<td>${m.messageContent }</td>
			</tr>
			<tr>
				<td>
				<button>확인</button>	
				<button>삭제</button>
			</tr>
			
	</table>
</body>
</html>