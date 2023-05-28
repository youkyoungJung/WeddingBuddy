<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="my_user_id" value="Hello, JSTL!" />
<c:set var="my_planner_id" value="Hello, JSTL!" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS 파일 로드 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>내 채팅방</title>
<style>
.chatback {
	float: right;
	width: 200px;
	height: 100px;
}

.list-group-item.custom-list-item {
	background-color: #F4E0E0;
}

.list-group-item.custom-list-item {
	margin-bottom: 20px;
}
</style>

<%@ include file="navbar.jsp"%>

<%-- <c:set var="user_id" value="${LoginUser.user_id }"/>
<c:set var="planner_id" value="${LoginUser.planner_id }"/>
 --%>

</head>

<body>
	<div class="container">
		<h1>플래너 채팅방</h1>

		<div class="row">
			<div class="col-lg-10 col-md-10 col-sm-12">
				<c:forEach items="${PlannerInfo}" var="info">
					<div class="list-group">
						 <a href="#"
							class="list-group-item list-group-item-action d-flex justify-content-between align-items-center custom-list-item">
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1"></h5>
							</div>
							<p class="mb-1">고객님 성함 : ${info.name }</p> <small
							class="text-muted">채팅예약 시간 : </small>
							<div>
								<button type="button" class="btn btn-primary"
									onClick=location.href='<c:url value="/start"/>?to_id=${ChatWithUser.planner_id }&from_id=${info.user_id }'>실시간채팅
									바로가기</button>
								<button type="button" class="btn btn-secondary"
									onClick=location.href='<c:url value="/review?planner_id=${planner.planner_id }"/>' >리뷰
									쓰기</button>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<!-- Bootstrap JS 파일 로드 -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"></script>
</body>
</html>