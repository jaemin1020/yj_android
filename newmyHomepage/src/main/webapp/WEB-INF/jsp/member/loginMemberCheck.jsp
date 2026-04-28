<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="egovframework.member.service.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hi!
<%
	MemberVO memberVO = (MemberVO)request.getAttribute("memberVO");
%>
id : <%=memberVO.getId()%><br>
Name : <%=memberVO.getName()%><br> 
Tel : <%=memberVO.getTel()%><br> 

</body>
</html>