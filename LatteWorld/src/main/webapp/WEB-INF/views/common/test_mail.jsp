<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="mail.*"  %>
<%@ page import="com.google.gson.*"%>

<%
	String email = (String)request.getParameter("email");
	MailSend ms = new MailSend();
	String ranNum = ms.MailSend(email);
	String[] arr = {ranNum};
	response.setContentType("application/json");
	new Gson().toJson(arr,response.getWriter());
	
%>