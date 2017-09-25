<%@page import="context.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%  ArrayList<MemberVO> list = (ArrayList)request.getAttribute("list"); %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	body table{
		width: 50%;
		margin: opx;
		 margin-left: auto;
		 margin-right:  auto;
	}
	table tr:HOVER{
		text-align: center;
		background-color: pink;
	}
</style>
</head>


<body>
<table border="2">
	<tr>
		<th>ID</th><th>NAME</th><th>ADDRESS</th>
	</tr>
	<% for(int i=0; i<list.size(); i++){ %>
		<tr>
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getAddress() %></td>
		</tr>
	<%} %>
</table>
</body>
</html>
















