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
<h1 align="center">${item.name} 의 정보</h1><p>
<table align="center" width="600">
	<tr bgcolor="orange">
		<td align="right">
		조회수 : ${item.count} &nbsp; &nbsp; &nbsp; &nbsp;
		<a href="itemCartAdd.do?itemid=${item.itemnumber}">장바구니 담기</a>
		</td>
	</tr>
</table>
<table align="center" width="600">
	<tr>
	    <td rowspan="3"><img src="${item.url}"></td>&nbsp; &nbsp; &nbsp; &nbsp;
		<td>종 류 : ${item.name}</td>
	</tr>
	
	<tr>
		<td>가 격 : ${item.price}</td>
	</tr>
	
	<tr>
		<td>설 명 : ${item.description}</td>
	</tr>
	
	<tr>
		<td colspan="1" align="center"><a href="itemList.do">상품 목록 보기</a></td>
	</tr>
</table>
</body>
</html>



















