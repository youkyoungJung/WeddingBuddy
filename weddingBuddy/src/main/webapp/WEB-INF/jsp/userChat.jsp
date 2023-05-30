<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="my_user_id" value="Hello, JSTL!" />
<c:set var="my_planner_id" value="Hello, JSTL!" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<!-- Bootstrap CSS 파일 로드 -->
<!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
<title>내 채팅방</title>
<style>

@font-face {
	font-family: 'Cafe24Simplehae';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

.container-xxl.bg-white.p-0 {
	margin-bottom: 20px;
	padding: 20px;
}

.page-header {
	margin-bottom: 20px;
	padding: 20px;
}

.custom-list-item {
	background-color: #F4E0E0;
	margin-bottom: 20px;
	
}

.btn-primary, .btn-secondary {
	margin-top: 10px;
	margin-right: 10px;
}



.list-group {
	border-radius: 30%;
	background: #F5F5F5;
	justify-content: center;
	padding: 20px;
	position: relative;
	display: flex;
	align-items: center;
	flex-direction: column;
	margin-left: auto;
	margin-right: auto;
}



.list-group-item.custom-list-item {
	border-radius: 30%;
	background: rgba(245, 245, 245, 0.5);
	border-color: transparent;
	transform: translateX(10%); 
	display: flex;
	justify-content: center;
	align-items: center;
	height: 150px;
	width: 110%;
	line-height: 2;
}

.list-group-item:hover{
	border-color: pink;
}

.contact-button button {
	border-color: pink;
	color: gray;
	justify-content: center;
}

.contact-button button:hover {
	background-color: pink;
	color: black;
	justify-content: center;
}

.contact-button {
	display: flex;
	justify-content: center;
}
.contact-button button + button {
  	margin-left: 20px; /* 다음 버튼과의 간격 설정 */
}


</style>

<%-- <c:set var="user_id" value="${LoginUser.user_id }"/>
<c:set var="planner_id" value="${LoginUser.planner_id }"/>
 --%>

</head>

<body>
	<div class="container-xxl bg-white p-0">
		<%@ include file="navbar.jsp"%>
		<div class="container-xxl bg-primary page-header">
			<div class="container text-center">
				<h1 class="text-white animated zoomIn mb-3">내채팅방</h1>
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb justify-content-center">
						<li class="breadcrumb-item"><a class="text-white"
							href="<c:url value="/mypage/like"/>">찜</a></li>
						<li class="breadcrumb-item"><a class="text-white"
							href="<c:url value='/mypage/'/>">내정보수정</a></li>
						<li class="breadcrumb-item"><a class="text-white"
							href="<c:url value='/mypage/chat'/>">내채팅방</a></li>
					</ol>
				</nav>
			</div>
		</div>
	</div>

	<div class="container">

		<div class="row">
			<div class="col-lg-10 col-md-10 col-sm-12">
				<c:forEach items="${chatPlanner}" var="planner">
					<div class="list-group" onClick=location.href='<c:url value="/start"/>?to_id=${LoginUser.user_id }&from_id=${planner.planner_id }' >
						<a href="#" class="list-group-item list-group-item-action d-flex justify-content-between align-items-center custom-list-item">
							<div>
								<h5 class="mb-1">${planner.name }</h5>
								<!-- 플래너 이름 -->
								<p class="mb-1">채팅예약 시간: ${reservedDates[planner.planner_id]}</p>
								<!-- 채팅예약 시간 -->
							</div>
							<%-- <div>
								<button type="button" class="btn btn-primary"
									onClick=location.href=
									'<c:url value="/start"/>?to_id=${LoginUser.user_id }
									&from_id=${planner.planner_id }'>실시간채팅 바로가기</button>
								<button type="button" class="btn btn-secondary"
									onClick="location.href='<c:url value="/review?planner_id=${planner.planner_id}&user_id=${LoginUser.user_id}"/>'">
									리뷰 쓰기</button>
							</div> --%>

								<div class="contact-button">
									<button
										class="btn btn-outline-light rounded-pill border-2 py-2 px-3 animated slideInRight"
										onClick=location.href='<c:url value="/start"/>?to_id=${LoginUser.user_id }&from_id=${planner.planner_id }'>Chat
									</button>
									<button
										class="btn btn-outline-light rounded-pill border-2 py-2 px-4 animated slideInRight"
										onClick="location.href='<c:url value="/review?planner_id=${planner.planner_id}&user_id=${LoginUser.user_id}"/>'">리뷰 쓰기</button>
									
								</div>


						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp" />
	<!— Bootstrap JS 파일 로드 —>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"></script>
</body>
</html>
