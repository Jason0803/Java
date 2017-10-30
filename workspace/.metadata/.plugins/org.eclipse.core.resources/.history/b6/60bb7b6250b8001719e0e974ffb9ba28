<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/global-tier-one.css">
<link rel="stylesheet" type="text/css" href="css/animate.css">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>

<c:if test="${memberVO!=null}">
	<script type="text/javascript">
		location.href = "DispatcherServlet?command=cal&year=${today.year}&month=${today.month}";
	</script>
</c:if>

<title>코코아노트. 당신의 하루를 기록하세요.</title>
</head>
<body>
	<div class="container">
		<div class="row ">

			 
			
			 
			 
			 <div class="col"> <br/><br/><h2>cocoaNOTE</h2></div>
			 
			 
			 
			
			
			

		</div>
		<div class="dropdown-divider"></div>
		<div class="row ">
		
			<div class="col-6  text-wrapper  " style="border-right: 0px solid gray;">
			<div><br/><br/><br/></div>
				<div class="animated-words d-flex justify-content-start" style="margin-left:100px;" >
					<br> <br><span>일정, 노트, 메모를<br> 한 곳에서 모두
						기록하세요.
					</span> <span>설정 없이,<br> 모든 기기와 연동됩니다.
					</span> <span>일정을 <br>친구와 공유해 보세요.
					</span> <span>당신의<br>하루를 담아보세요.
					</span>
				</div>
				<div class="animated-words-last d-flex justify-content-center">
					<span>자, 이제<br>시작해 보세요.
					</span>
				</div>
			</div>
			<div class="col-4">
			<div><br/><br/><br/><br/></div>
				<div class="card" style="width: 20rem; margin-left: 100px;">
					<div class="card-body text-center ">
					
						<form action="DispatcherServlet" method="post">
							<h4 class="card-title">오늘도 파이팅!</h4>
							<input class="form-control" type="text" name="id"
								placeholder="아이디(email)" required="required" /><br /> 
								<input class="form-control" type="password" name="password"
								placeholder="password" required="required" /><br />
								 <input id="btn-long-pink" class="btn btn-primary" type="submit" value="로그인" />
							<c:if test="${param.login==false}">
								<br />
								<span style="color: red">회원정보가 일치하지 않습니다.</span>
							</c:if>
							<input type="hidden" name="command" value="login" />
						</form>
					</div>
					
				</div>
				<br/>
				<div class="card" style="width: 20rem; margin-left: 100px;">
				<div class="card-body text-center" style="padding:0.5rem;">
					<div><h6><small>계정이 없으신가요? <a href=register.jsp>가입하기</a></small></h6></div>
				
				</div>
				</div>
			</div>
		</div>
		<div class="row"></div>
	</div>

</body>
</html>