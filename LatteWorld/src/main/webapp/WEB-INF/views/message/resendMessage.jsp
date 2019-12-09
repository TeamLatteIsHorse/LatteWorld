<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sendMessage.do?sendId">
	<table>
		<tr>
			<td>받는이 : </td>
			<td>
			
			</td>
		</tr>
		<tr>
			<td>내용</td>
		</tr>
		<tr>
			<td>
			<textarea name="content" cols="40" rows="5"></textarea>
			</td>
		</tr>
		<tr>
			<td>
			<button type="submit" >전송</button>
			<button onclick="closeR()">닫기</button>	
			
		</tr>
		
	</table>
	</form>
	
	<script>
		
		function closeR(){
			window.close();	
		}
		
		
	</script>
</body>
</html>