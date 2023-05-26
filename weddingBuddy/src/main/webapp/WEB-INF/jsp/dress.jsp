<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dress.jsp</title>
<%@ include file="navbar.jsp"%>
<style>
.dress-item {
	margin-bottom: 20px;
	padding: 10px;
	border: 1px solid #ccc;
	cursor: pointer; /* 클릭 가능한 커서 스타일 지정 */
}

.dress-item:hover {
	background-color: #f0f0f0; /* 마우스 호버 시 배경색 변경 */
}

.dress-item h3 {
	margin-top: 0;
}

.dress-item p {
	margin: 0;
}

.dress-item .image-container {
	text-align: center;
	margin-bottom: 10px;
}

.dress-item img {
	max-width: 100%;
	height: auto;
}
</style>
<script>
    function goToDressDetail(dress_shop_id) {
        var contextPath = "${pageContext.request.contextPath}";
        location.href = contextPath + '/dress_detail?dress_shop_id=' + dress_shop_id;
    }
</script>

</head>
<body>
	<h2>dress 보기</h2>

	<c:forEach var="dress" items="${dressShops}">
		<div class="dress-item"
			onclick="goToDressDetail(${dress.dress_shop_id})">
			<h3>${dress.name}</h3>
			<p>${dress.price_range}만원~</p>
			<!-- dressImageList에서 해당 company_unique_id에 맞는 이미지만 표시 -->
			<c:forEach var="dressImage" items="${dressImagesList}">
				<c:if
					test="${dressImage.company_unique_id == dress.company_unique_id}">
					<div class="image-container">
						<img src="<c:url value='${dressImage.image}' />" alt="Dress Image" />
					</div>
					<%-- 첫 번째 이미지만 표시하고 반복문 종료 --%>
					<%-- <c:break /> --%>
				</c:if>
			</c:forEach>
		</div>
	</c:forEach>

	<%@ include file="footer.jsp"%>
</body>
</html>
