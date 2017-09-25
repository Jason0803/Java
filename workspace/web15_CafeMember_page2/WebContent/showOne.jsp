<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<% String name = request.getParameter("name"); %>
<body>
<b><%= name %></b>님, Cafe Register Success!!!<p>
<A href="index.html">홈으로 가기</A><p>
<A href="ShowAllMember">전체회원 명단 보기</A><p>
</body>
</html>