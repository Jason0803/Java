<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Fruit Total List 2.</h1><p>
<table align="center">

	<tr>
		<c:forEach var="item" items="${requestScope.list}" varStatus="i">
			<td>
				<a href="itemView.do?itemnumber=${item.itemnumber }">
				<img  src="${item.url}" height="150" width="150" border="2"></a><br>
				상품명 : ${item.name}<br>
				가 격 :${item.price}원
			</td>	
			<%-- <c:if test="${i.count%5==0}">
			<tr></tr>
			</c:if> --%>
		</c:forEach>
	</tr>
</table>
</body>
</html>














