<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign-Out</title>
</head>
<body>
<%
	String name = (String)session.getAttribute("name");
	
	if (session != null) {
	    session.invalidate();
	}
	
	System.out.println("Session for " + name + "has been successfully closed !");
	
%>

<h2> <%= name %>, You are successfully logged out !</h2><br>
<h1 align="center"><a href="index.html">Go Home</a></h1>

</body>
</html>