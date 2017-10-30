<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<title>코코아노트 가입하기</title>
<c:if test="${memberVO!=null}">
<script type="text/javascript">
	location.href = "DispatcherServlet?command=cal&year=${today.year}&month=${today.month}";
</script>
</c:if>
<script type="text/javascript">

function registerCheck() {
	var regFrm = document.registerFrm;
	if(regFrm.password.value==regFrm.password_chk.value){
		return true;
	} else {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
}
</script>

</head>
<body>
	<div class="container">
		<div class="row ">			
		<div class="col">
		<br /><br /><h2>cocoaNOTE</h2>
		</div>
				
			</div>
			<div class="dropdown-divider"></div>






		
	<div class="row">
	
			<div class="col-6 d-flex justify-content-end " style="margin-top: 30px;">
				<div><br/><br/><br/></div>
				 
				
				<div class="card text-center" style="width: 25rem; height: 30rem">
				<br/>				
				<h4>
					<strong>지금 코코아노트에 가입하세요.</strong>
				</h4>
					<div class="card-body">
						<form action="DispatcherServlet" method="post" name="registerFrm"
							onsubmit="return registerCheck();">
							<input class="form-control" type="text" name="id" placeholder="아이디(email)" required="required" /><br /> 
							<input class="form-control" type="password" name="password" placeholder="비밀번호" required="required" /><br />
							<input class="form-control" type="password" name="password_chk" 	placeholder="비밀번호 확인" required="required" /><br /> 
							<input class="form-control" type="text" name="name" placeholder="이름" required="required" /><br />
							<input id="btn-longer-pink" class="btn btn-primary"   type="submit" value="가입하기" />
							<c:if test="${param.register==false}">
								<br />
								<span style="color: red">이미 존재하는 ID입니다.</span>
							</c:if>
							 <input class="form-control" type="hidden" name="command" value="register" /><br /> 
							 <br/>
							 <h6><small>가입과 동시에 귀하는 쿠키 사용을 포함해 이용약관과 개인정보 처리방침에 동의하는 것입니다. </small></h6>
							<h6>이미 회원이신가요? <a	href="login.jsp">로그인</a></h6>
						</form>
				</div>
			</div>
			
			
			</div>
			<div  class="col-6 d-flex justify-content-start " style="margin-top: 30px;">
<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block rounded" src="img/1.JPG" width="400" height="480" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block rounded" src="img/2.JPG" width="400" height="480" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block rounded" src="img/3.JPG" width="400" height="480" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    
    <span class="sr-only">Next</span>
  </a>
</div>
			</div>
</div>
</div>
</body>
</html>