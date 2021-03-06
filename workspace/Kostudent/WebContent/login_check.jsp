<%@ page import="vo.Student" %>
<%@ page import= "java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
  <title>KOStudent</title>
  <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
  <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="./css/home.css" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="./js/chattingScript.js"></script>
  <script type="text/javascript">
 <% 
 	if(session.getAttribute("name").equals(null)) {
 		System.out.println("WARNING :: Abnormal Access Sensored !!");
 		request.getRequestDispatcher("index.html").forward(request, response);
 	}
 	System.out.println("Current Session with User : " + session.getAttribute("name"));
 	Student student = (Student)application.getAttribute("user");
 	String temp_PW = student.getPassword();
 	int classNo = student.getUserClass();
 %>
	$(function() {
		$('#frm_editProfile').serialize();
	});
	
	function checkForm(form) {
	   if(form.currentPW.value == <%= temp_PW %>) {
		  if(form.currentPW.value == form.newPW.value) {
		   alert("The New password you have entered is same as previous !")
		   return false;
		  } else if (form.newPW.value.length < 6) {
		   alert("Password is too short ! You should enter more than 6 characters !");
		   return false;
		  } else {
			  return true;
		  }
	  } else {
		  alert("Current Password is incorrect !");
		  return false;
	  } 
	}
	  
  </script>
</head>
<body>
<% 
	ArrayList<Student> list = (ArrayList<Student>)application.getAttribute("studentDB");
	Student currentUser = (Student)application.getAttribute("user");
%>
<img src="./image/background_image.png" id="bg" alt="">
<!-- For Navigation Bar ... -->
  <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="splash.html">KOStudent</a>
        </div>
        <ul class="nav navbar-nav">
          <li class="active"><a href="index.html">Home</a></li>
          <li><a href="notice.html">Notice</a></li>
          <li><a href="#">Discussion</a></li>
          <li><a href="#">Contact Us</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
<% 
		if( session.getAttribute("login_result").equals(Student.LOGIN_SUCCESS + " ")) { %>
			<li><a href="#" data-toggle="modal" data-target="#modal_editProfile"><span class="glyphicon glyphicon-edit"></span> Edit Profile</a></li>
	     	<li><a href="LogOut" ><span class="glyphicon glyphicon-off"></span> Log Out</a></li><%

		} else { %>
		    <li><a href="#" data-toggle="modal" data-target="#modal_SignUP"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     		<li><a href="#" data-toggle="modal" data-target="#modal_SignIn"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			<% 
	    }
%>
        
       </ul>
      </div>
  </nav>
<!-- For Navigation Bar ... -->

<div class="container" style="margin-top:100px">
  <div class="jumbotron">
    <h1>KOStudent</h1> <hr>
    <p>This is a community web-site for students @KOSTA.</p> 
    <p>Contact me on : +82-10-2616-6795<br>@Kakao : Jasonchoi93</p>
    <p><a href="#" data-toggle="collapse" data-target="#meal">오늘의 식단(미래에셋)</a></p> 
    <div id="meal" class="collapse">
      <img src="./image/meal_1.jpeg">
    </div>

    
  </div>
  <div class="jumbotron">
    <h1>My Class    
      <a href="#" id="refresh_class">
            <span class="glyphicon glyphicon-refresh"></span>
      </a> 
    </h1>
    <h2>수료일 (2017.12.29)</h2>
    
    <div class="progress">
		<div class="progress-bar" role="progressbar" aria-valuenow="20" 
			aria-valuemin="0" aria-valuemax="100" style="width:20%">
	    20%
  		</div>
	</div>
    <hr>
    <!-- Messages go top-down way thread -->
    <div class="msgs" id="myClass">
<!-- Temp. Messages -->
	    <!-- Left-aligned -->
		<div class="media">
		  <div class="media-left">
		    <img src="./image/img_avatar1.png" class="media-object" style="width:60px">
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">(174) 최수영</h4>
		    <p>저 내일 못와요... (17.09.18)</p>
		  </div>
		</div>
    
        <!-- Left-aligned -->
		<div class="media">
		  <div class="media-left">
		    <img src="./image/img_avatar2.png" class="media-object" style="width:60px">
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">(174) 김인수</h4>
		    <p>네 말씀드리겠습니다~ (17.09.18)</p>
		  </div>
		</div>

	    <!-- Left-aligned -->
		<div class="media">
		  <div class="media-left">
		    <img src="./image/img_avatar2.png" class="media-object" style="width:60px">
		  </div>
		  <div class="media-body">
		    <h4 class="media-heading">(174) 김인수</h4>
		    <p><b><font color='red'>공지</font></b> 오늘 회식 있습니다 ^^ <a href="#" data-toggle="modal" data-target="#tempModal">#치어스</a> (17.09.22) </p>
		  </div>
		</div>
		<!-- Temp. Messages -->
	</div>
	
    <br><br><p>Message : <input type="text" id="inputMsg_1">
    <button type="button" class="btn btn-primary" id="sendMsg_1">Send</button>
	<select>
		<option>일반</option>
		<option>공지</option>
		<option>투표</option>
	</select>
    </p>

  </div>

  <div class="jumbotron">
    <h1>All Classes</h1> 

    <div clas="msgs" id="allClass">
	    <p>(174) 최수영 : 청소기 미리 예약점; (17.09.18)</p>
	    <p>(172) 아무개 : ㄴㄴ (17.09.18)</p> 
    </div>

	<br><br><p>Message : <input type="text" id="inputMsg_2"> 
	<button type="button" class="btn btn-primary" id="sendMsg_2">Send</button></p>

  </div>

    <div class="jumbotron">
    <h1>Live Thread</h1> 
    <p><a href="#" data-toggle="collapse" data-target="#temp_1">174기 회식 (17.09.22) @치어스</a></p> 
   	<div id="temp_1" class="collapse">
      <img src="./image/cheers.png">
    </div>
    <p><a href="#" data-toggle="collapse" data-target="#temp_2">166기 수료 (17.09.22)</a></p> 
    <div id="temp_2" class="collapse">
      축하합니다 ^^
    </div>
  </div>

<div id="footer" align="center"><b>KOStudent by Jason Choi.</b></div>
</div>


<!-- Modal for Edit -->
<div class="modal fade" id="modal_editProfile" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Edit Profile</h4>
      </div>
      <div class="modal-body">
		<form action="EditProfile" method="post" id="frm_editProfile" onsubmit="return checkForm(this);">
		    <fieldset disabled>
			&nbsp;&nbsp;&nbsp;<b>Class :</b>
			<select name= "userClass" lass="s" >
				<option value=> <%= classNo %></option>
				<% System.out.println("login_check.jsp - Current User is : " + currentUser.getName()); %>
			</select><br><br>
			</fieldset>
			<!-- ID -->
			<div class="form-group">
		      <label for="disabledInput" class="col-sm-2 control-label">ID : </label>
		      <div class="col-sm-10">
		        <input class="form-control" id="disabledInput" type="text" name="userName" placeholder=<%= currentUser.getName() %> disabled>
		      </div>
		    </div><br><br>
		    <!-- Prev. PW -->
			 <div class="form-group">
		      <label class="col-sm-2 control-label">Current Password</label>
		      <div class="col-sm-10">
		        <input class="form-control" type="password" name="currentPW" placeholder="Input Current Password">
		      </div>
		    </div><br><br>
		    <!-- New PW -->
		    <!-- Data Validation to be implemented later !! -->
			 <div class="form-group">
		      <label class="col-sm-2 control-label">New Password</label>
		      <div class="col-sm-10">
		        <input class="form-control" type="password" name="newPW" placeholder="Input New Password">
		      </div>
		    </div><br><br>		

		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
      </div>
    </div>
  </div>
</div> 
<!-- Modal -->

 <!-- tempModal (Advertisement) -->
  <div class="modal fade" id="tempModal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">치어스</h4>
        </div>
        <div class="modal-body">
          <p>치어스 : 경기 성남시 분당구 대왕판교로 660 3층</p>
          
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
			  <!-- Indicators -->
			  <ol class="carousel-indicators">
			    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			    <li data-target="#myCarousel" data-slide-to="1"></li>
			    <li data-target="#myCarousel" data-slide-to="2"></li>
			  </ol>
			
			  <!-- Wrapper for slides -->
			  <div class="carousel-inner">
			    <div class="item active">
			      <img src="./image/adv/1.jpg" alt="Los Angeles" width=240px height=240px>
			    </div>
			
			    <div class="item">
			      <img src="./image/adv/2.jpg" alt="Chicago" width=240px height=240px>
			    </div>
			
			    <div class="item">
			      <img src="./image/adv/3.jpg" alt="New York" width=240px height=240px>
			    </div>
			  </div>
			
			  <!-- Left and right controls -->
			  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#myCarousel" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right"></span>
			    <span class="sr-only">Next</span>
			  </a>
			</div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div> 
</body>
</html>