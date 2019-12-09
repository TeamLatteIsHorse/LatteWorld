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
			<td>보낸이 : </td>
			<td>${m.sendId } (${m.sendDate })</td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td>${m.messageContent }</td>
		</tr>
		<tr>
			<td>
			<button onclick="resend()">답장하기</button>
			<button onclick="closeR()">확인</button>	
			<button>삭제</button>
		</tr>
		
	</table>
	<script>
		
		function closeR(){
			window.close();	
		}
		function resend(){
			location.href="resendView.do?receiveId="+${m.sendId};
		}
	</script>
	
</body>
</html>