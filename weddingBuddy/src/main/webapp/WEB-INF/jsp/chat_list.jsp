<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/css/message.css">

<meta charset="UTF-8">

<title>채팅리스트</title>
<style>
@font-face {
	font-family: 'Cafe24Simplehae';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: Cafe24Simplehae;
	background-color: #f8f9fa;
}
</style>
<script>
	function toMessage(caller_id, receiver_id) {
		window.open(
				"<c:url value='/chat/" + caller_id + "/" + receiver_id + "'/>",
				"chatting", "width=600,height=725,location=no,status=no");

	}
</script>
</head>

<body>

	<c:choose>
		<c:when test="${fn:length(chatPlanner) == 0 }">
			<div align="center">
				<br> <img src="<c:url value="/images/logo.jpg" />" width="20%" height="20%">
				<br>
				<h2>대화 상대가 없습니다.</h2>
				<h3>플래너들과 대화를 시작해보세요!</h3>
			</div>
		</c:when>
		<c:otherwise>
			<div class="inbox_people">
				<c:set var="id" value="${sessionScope.user_id}" />
				<div class="inbox_chat scroll">
					<c:forEach var="box" items="${chatPlanner}">
						<c:if test="${box.planner_id eq planner_id}">
							<c:set var="caller" value="${box.user_id}" />
							<c:set var="receiver" value="${box.planner_id}" />
						</c:if>
						<c:if test="${box.planner_id ne planner_id}">
							<c:set var="caller" value="${box.user_id}" />
							<c:set var="receiver" value="${box.planner_id}" />
						</c:if>
						<div class="chat_list"
							onclick="toMessage('${user_id}', '${planner_id}'); false;">
							<div class="chat_people">
								<div class="chat_img">
									<img src="/images/logo.png" width="50" height="50" alt="sunil">
								</div>
								<div class="chat_ib">
									<h5>
										${planner_id} <span class="chat_date">${box.senttime}</span>
									</h5>
									<p>${box.content}</p>
								</div>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>

		</c:otherwise>
	</c:choose>

</body>

</html>