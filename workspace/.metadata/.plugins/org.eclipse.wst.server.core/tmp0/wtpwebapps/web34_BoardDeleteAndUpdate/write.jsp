<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function content_submit(){
	var f=document.write_form;
	if(f.title.value==""){
		alert("제목을 입력하세요!");
		f.title.focus();
		return; 
	}
	if(f.writer.value==""){
		alert("이름을 입력하세요!");
		f.writer.focus();
		return;
	}
	if(f.password.value==""){
		alert("패스워드를 입력하세요!");
		f.password.focus();
		return;
	}
	if(f.content.value==""){
		alert("내용을 입력하세요!");
		f.content.focus();
		return;
	}
	//이동할 페이지로 폼값을 가지고 전송됨
	f.submit();
}
function cancel(){
	var f=document.write_form;
	f.reset();
}
</script>
</head>
<body>
<c:import url="header.jsp"></c:import>
<h3>글쓰기</h3> <br>
  <form action="DispatcherServlet" method="post" name="write_form">
  <input type="hidden" name="command" value="write">
   <table width="500px" >
    <tr>
     <td width="10%">제목</td>
     <td colspan="3">
     <input type="text" name="title" maxlength="200" size="50">
     </td>
    </tr>
    <tr>
     <td width="10%">이름</td>
     <td width="35%"><input type="text" name="writer"></td>
     <td width="15%">비밀번호</td>
     <td >
     <input type="password" name="password" maxlength="4" size="4">
     </td>
    </tr>
    <tr>
     <td colspan="4">
     <textarea cols="55" rows="15" name="content"></textarea>
     </td>
    </tr> 
    <tr>
     <td colspan="4" align="center" >
      <img src="img/confirm.gif" alt="확인"  onclick="content_submit()">
      <a href="" onclick="cancel()"><img src="img/cancel.gif"></a>      
     </td>  
    </tr>
   </table>
  </form>
  </body>
</html>




