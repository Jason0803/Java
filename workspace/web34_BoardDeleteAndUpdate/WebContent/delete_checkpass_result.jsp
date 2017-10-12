<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	<c:choose>
		<c:when test="${flag==true}">
			if(confirm("정말로 삭제를 진행할까요?")){
				window.opener.location.href="DispatcherServlet?command=deletePosting&&no=${param.no}";
			}
		</c:when>		
		<c:otherwise>
			alert("해당 글이 패스워드와 일치하지 않습니다..");
		</c:otherwise>
	</c:choose>
	
	window.self.close();
</script>








