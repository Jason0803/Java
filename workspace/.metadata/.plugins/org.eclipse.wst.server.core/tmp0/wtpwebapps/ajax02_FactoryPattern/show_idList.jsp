<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var xhr;
	function startRequest() {
		xhr = new XMLHttpRequest();
		xhr.onreadystatechange = callback;
		var id = document.getElementById("idList").value;
		//xhr.open("get", "IdCheckServlet?id="+id.value,true);
		xhr.open("post","DispatcherServlet")
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
		xhr.send("command=findMember&&id="+id);
		//alert(xhr.readyState);
	}
	
	function callback() {
		if(xhr.readyState == 4) {
			if(xhr.status == 200) {
				//alert("response");
				var text = xhr.responseText;
				document.getElementById("resultView").innerHTML = 
					+"<font color='green'>"+text+"</font>";
			}
		}
	}
	</script>
</head>
<body>
<h2 align="center">ID List</h2><p>
<h3>Select an ID from the list below</h3>
<select id="idList" onchange="startRequest()">
	<option></option>
	<c:forEach var="memberId" items="${list}">
		<option value="${memberId}">${memberId}</option>
	</c:forEach>
</select>
<span id="resultView"></span>
</body>
</html>