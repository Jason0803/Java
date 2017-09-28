<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkId() {
		var cid = document.findForm.id;
		if(cid.value==""){
			alert("아이디를 입력하세여");
			return false;
		}
	}
</script>
</head>
<body>
<!-- find_action.jsp의 내용이 들어간다...
	 실행결과를 수행했을때 해당 id를 찾으면 find_ok.jsp로 결과를 돌리고
	 실행결과를 수행했을때 해당 id를 찾지 못하면 find_fail.jsp로 결과를 돌리고
 -->
<form action="front.do" name="findForm" onsubmit="return checkId()">
아이디 : <input type="text" name="id">
<input type="hidden" name="command" value="find">
<input type="submit" value="검색">
</form>
</body>
</html>











