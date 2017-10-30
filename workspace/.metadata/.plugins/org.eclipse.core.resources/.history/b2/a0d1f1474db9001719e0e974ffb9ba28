<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="head.jsp"></jsp:include>
<div class="row">
<div class="col-7">
	<div class="card rounded-content">
		<div class="card-body">
			<h4 class="card-title">${dayInfo.date.year}년 ${dayInfo.date.month}월 ${dayInfo.date.date}일</h4>
			<hr>
			<h5>일정</h5>
			<c:if test="${empty dayInfo.schedules}">
				- 등록된 일정이 없습니다.
			</c:if>
			<c:forEach var = "schedule" items="${dayInfo.schedules}">
				<div class="scheduleItem" onmouseover="loadBtnSet(this)" onmouseout="hideBtnSet(this)">
					<span class="scheduleTitle">${schedule.title}</span>
					<span class="scheduleDate">${schedule.startDate.year}.${schedule.startDate.month}.${schedule.startDate.date} ${schedule.startDate.hour}:${schedule.startDate.minute}
								~${schedule.endDate.year}.${schedule.endDate.month}.${schedule.endDate.date} ${schedule.endDate.hour}:${schedule.endDate.minute}</span>
					<p class="scheduleContent">- ${schedule.content}</p>
					<c:forEach var="friend" items="${group_member}">
						<div>${friend }AWEFASEFASFSDFASDFASDF</div>
					</c:forEach>
					<div class="scheduleBtn">
						<input type="button" value="수정" onclick="updateSchedule('${schedule.no}', '${schedule}')" />
						<input type="button" value="삭제" onclick="deleteDiary(${schedule.no},${schedule.startDate.year},${schedule.startDate.month},${schedule.startDate.date})"/>
					</div>
				</div>
			</c:forEach>
			<hr>
			<h5>노트</h5>
			<c:if test="${empty dayInfo.notes}">
				- 등록된 노트가 없습니다.
			</c:if>
			<ul>
				<c:forEach var="note" items="${dayInfo.notes}">
					<li style="cursor:pointer" onclick="noteView(${note.no})">${note.title}</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
<div class="col-5">
	<div class="card rounded-content">
		<div class="card-body">
			<h4 class="card-title" id="scheduleFrmTitle">새로운 일정</h4>
			<p class="card-text"></p>
			<hr>
			<form action="DispatcherServlet" name="scheduleFrm" method="post" onsubmit="return valueCheck()">
				<input type="text" class="form-control rounded-bar" name="title" required="required" placeholder="일정 제목"/><br>
				<input type="datetime-local" class="form-control rounded-bar date-control" name="startDate" required="required" />
				<p align="center">~</p>
				<input type="datetime-local" class="form-control rounded-bar date-control" name="endDate" required="required"/><br>
				<br/>
				<input type="text" class="form-control rounded-bar" name="content" required="required" placeholder="일정 내용"/><br>
				<div class="row">
					<div class="col-9">
						<input type="text" class="form-control rounded-bar shcedule_group" name="schedule_group" placeholder="함께하는 사람"/>
					</div>
					<div class="col-3" style="padding-left:0px"> 
						<input style="width:100%" type="button" class="btn btn-primary" value="추가" onclick="addGroupMember()"/><br />
					</div>
					<div id="shcedule_group_container"></div><br /><br />
				</div>
				<input name="scheduleFrmSubmit" id="btn-long-pink" style="width:100%; margin-top:20px;" type="submit" class="btn btn-primary" value="일정 등록" />
				<input type="hidden" name="command" value="writeSchedule" />
				<input type="hidden" name="start_date" />
				<input type="hidden" name="end_date" />
				<input type="hidden" name="group_member" />
			</form>
			<hr>
		</div>
	</div>
</div>
</div>
<script type="text/javascript">
	document.scheduleFrm.startDate.value = "${dayInfo.date.year}-${dayInfo.date.month}-${dayInfo.date.date}T09:00:00.000";
	document.scheduleFrm.endDate.value = "${dayInfo.date.year}-${dayInfo.date.month}-${dayInfo.date.date}T18:00:00.000";
	
</script>
<jsp:include page="foot.jsp"></jsp:include>