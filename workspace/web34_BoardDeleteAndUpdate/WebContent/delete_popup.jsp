<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function delAction() {
		var pass = document.delCheckForm.password.value;
		if(pass=="")
			alert("password 입력하세요...");
		else
			document.delCheckForm.submit();
	}
</script>
</head>
<body>
<form action="DispatcherServlet" name="delCheckForm" method="post">
<input type="password" name="password"><br><br>
<input type="hidden" name="command" value="deleteCheckPassword">
<input type="hidden" name="no" value="${param.no}">
<input type="button" value="삭제" onclick="delAction()">
<input type="button" value="창닫기" onclick="javascript:self.close()">
</form>
</body>
</html>



















