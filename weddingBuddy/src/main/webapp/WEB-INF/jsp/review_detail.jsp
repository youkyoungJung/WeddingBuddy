<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Review Detail</title>
<style>
.review-item {
	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid #ccc;
}

.review-item h3 {
	margin-top: 0;
}

.review-item p {
	margin: 0;
}

.review-item .content {
	margin-bottom: 10px;
}
.review-item img {
	max-width: 100%;
	height: auto;
}

</style>
<jsp:include page="navbar.jsp" />
</head>
<body>
	<h2>Planner Reviews</h2>

	<%-- Planner ID에 해당하는 모든 리뷰 조회 --%>
	<%@ page import="com.multicampus.kb03.weddingBuddy.dto.User"%>
	<%@ page import="java.util.Map"%>

	<c:set var="plannerId" value="${param.planner_id}" />

	<%-- 해당 Planner ID에 대한 리뷰 리스트 가져오기 --%>
	<c:set var="reviewList" value="${reviewList}" />

	<%-- UserAccountMap 설정 --%>
	<c:set var="userAccountMap" value="${userAccountMap}" />

	<%-- 리뷰 리스트가 비어있는지 확인 --%>
	<c:if test="${empty reviewList}">
		<p>No reviews found for this planner.</p>
	</c:if>

	<%-- 리뷰 리스트가 비어있지 않은 경우, 리뷰 정보를 표시 --%>
	<c:if test="${not empty reviewList}">
		<%-- 리뷰 정보를 반복하여 표시 --%>
		<c:forEach var="review" items="${reviewList}">
			<div class="review-item">
				<div>
					<label>이름 :</label>
					<p><c:out value="${userAccountMap[review.user_id]}"/></p> <!-- user_id에 해당하는 name 값을 가져와서 표시 -->
				</div>
				<div class="content">
					<label>고객 후기:</label>
					<p>${review.content}</p>
				</div>
				<div>
					<label>등록 날짜:</label>
					<p>${review.reg_date}</p>
				</div>
				<!-- reviewImagesList에서 해당 review_id에 맞는 이미지만 표시 -->
				<c:forEach var="reviewImage" items="${reviewImagesList}">
					<c:if test="${reviewImage.review_id == review.review_id}">
						<img src="<c:url value='${reviewImage.image}' />" alt="Review Image" />
					</c:if>
				</c:forEach>


			</div>
		</c:forEach>
	</c:if>

	<jsp:include page="footer.jsp" />
</body>
</html>
