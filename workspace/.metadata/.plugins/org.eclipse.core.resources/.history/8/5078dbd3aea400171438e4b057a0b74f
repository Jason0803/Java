<%@page import="java.util.ArrayList"%>
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

<h1 align="center"><font color="black" size="15">장바구니</font></h1>
<table width="600" align="center">
<tr>
<td align="right"><a href="itemList.do">쇼핑 계속하기</a></td>
</tr>
</table>




<form action="itemCartRemove.do" method="post" name="removeFrm">
<table align="center" width="600" border="1">
<c:if test="${cartList != null}">
	<tr align="center" bgcolor="orange">
		<td>번호</td>
		<td>상품이미지</td>
		<td>상품명</td>
		<td>상품가격</td>
		<td>수량</td>
		<td align="center">
			<input type="submit" name="delete" value="삭제">
		</td>
	</tr>
</c:if>

 <c:forEach var="cartList" items="${cartList}" varStatus="cl">

<tr align="center">

	<td>${cl.count}</td>	
	<td><img src="${cartList.image}" width="70" height="70"></td>
	<td>${cartList.name}</td>
	<td>${cartList.price}</td>
	<td>
		
		<img alt="" src="img/up.jpg" width="15" height="15" border="0">
		<br>
		${cartList.quantity}<br>
		
		<img alt="" src="img/down.jpg" width="15" height="15" border="0">
		<br>		
	</td>
	<td align="center">
		<input type="checkbox" name="delete" value="${cartList.name}">
	</td>
</tr>
</c:forEach>
</table>
</form>
<table align="center" width="600" border="0">
	<tr align="center" bgcolor="orange">
	   <td align="right" colspan="6"><font color="gray" size="5">총 결제금액 : </font>
	   <font color="black" size="8">${sumMoney}  </font></td>
	</tr>
</table>


</body>
</html>














