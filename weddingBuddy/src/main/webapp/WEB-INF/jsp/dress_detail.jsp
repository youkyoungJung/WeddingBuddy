<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dress Detail</title>
<%@ include file="navbar.jsp"%>
<style>
.contact-button {
	margin-top: 20px;
	display: flex;
	justify-content: center;
}

.image-container {
	display: flex;
	justify-content: space-between;
	align-items: flex-start;
}

.image-container img:first-child {
	width: 40%;
	max-height: 400px;
	object-fit: cover;
	margin-right: 10px;
}

.image-container img:last-child {
	width: 60%;
	max-height: 400px;
	object-fit: cover;
}

/* Modal Styles */
.modal {
	display: none;
	position: fixed;
	z-index: 1;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
	background-color: #fefefe;
	margin: 15% auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
	max-width: 400px;
	text-align: center;
	position: relative;
}

.close {
	position: absolute;
	bottom: 10px; /* 하단 여백 */
	left: 50%; /* 가로 중앙으로 위치 */
	transform: translateX(-50%); /* 가로 중앙 정렬 */
	font-size: 24px;
	color: #aaa;
	cursor: pointer;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
}
</style>
</head>
<body>
	<h2>Dress Detail</h2>

	<h3>${dressShop.name}</h3>
	<p>Price: ${dressShop.price_range}만원</p>

	<h4>Images</h4>
	<div class="image-container">
		<c:forEach var="imagePath" items="${dressImagesList}" varStatus="loop">
			<img src="${pageContext.request.contextPath}/${imagePath}"
				alt="Dress Image" />
			<c:if test="${loop.index eq 0}">
				<%-- 첫 번째 이미지에만 적용될 스타일 --%>
			</c:if>
		</c:forEach>
	</div>
	<br>
	<div class="contact-button">
		<button onclick="showPhoneNumber()">문의하기</button>
	</div>

	<!-- Modal -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<span class="close" onclick="closeModal()">&times;</span>
			<p>전화번호: ${dressShop.phone}</p>
		</div>
	</div>

	<script>
		function showPhoneNumber() {
			var modal = document.getElementById("myModal");
			modal.style.display = "block";
		}

		function closeModal() {
			var modal = document.getElementById("myModal");
			modal.style.display = "none";
		}
	</script>

	<%@ include file="footer.jsp"%>
</body>
</html>
