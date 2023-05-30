<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Arrays"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>플래너 예약</title>



</head>
<body>
	<div class="container-xxl bg-white p-0">
		<%@ include file="navbar.jsp"%>
		<div class="container-xxl bg-primary hero-header">
			<div class="container">
				<div class="row g-5 align-items-center">
					<div class="col-lg-6 text-center text-lg-start">
						<h1 class="text-white mb-4 animated zoomIn"
							style="margin-left: 50px; font-size: 3em">예약이 완료되었습니다.</h1>
						<p class="text-white pb-3 animated zoomIn"
							style="margin-left: 50px; font-size: 2em;">
							마이페이지 >> 채팅방<br>에서 예약시간을 확인할 수 있습니다.<br>좋은 시간 되세요~!
						</p>
						<a href="${pageContext.request.contextPath}/mypage"
							class="btn btn-outline-light rounded-pill border-2 py-3 px-5 animated slideInRight"
							style="margin-left: 50px">마이페이지로</a>
					</div>
					<div class="col-lg-6 text-center text-lg-start">
						<img class="img-fluid animated zoomIn"
							src="<c:url value = "/images/logo.png"/>" alt=""
							style="margin-right: 100px">
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />




</body>

</html>