<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Dress Detail</title>
<style>
.image-container {
    position: relative;
    width: 100%;
    height: 0;
    padding-bottom: 45%; 
    padding-right: var(--bs-gutter-x, 6em);
    padding-left: var(--bs-gutter-x, 6em);
    /* margin-right: auto;
    margin-left: auto; */
    display: flex;
    justify-content: space-between;
    align-items: flex-start;
}


.image-container img:first-child {
	width: 40%;
	max-height: 700px;
	object-fit: cover;
	margin-right: 10px;
}




.image-container img:last-child {
	width: 60%;
	max-height: 700px; 
	object-fit: cover;
	margin-left: 10px;
}

.contact-button button {
    border-color: pink;
  	color: gray;
  	
}

.contact-button button:hover {
	background-color : pink;
	color:gray;
}

.contact-button {
	margin-top: 20px;
	display: flex;
	justify-content: center;
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


#modal_span {
	color: gray;
}


</style>
</head>
<body>
<div class="container-xxl bg-white p-0">
		<%@ include file="navbar.jsp"%>
		<div class="container-xxl bg-primary page-header">
			<div class="container text-center">
				<h1 class="text-white animated zoomIn mb-3">드레스 상세보기</h1>
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb justify-content-center">
						<li class="breadcrumb-item"><a class="text-white" href="<c:url value="/studio"/>">스튜디오</a></li>
						<li class="breadcrumb-item"><a class="text-white" href="<c:url value="/dress"/>">드레스</a></li>
						<li class="breadcrumb-item"><a class="text-white" href="<c:url value="/beauty_Salon"/>">메이크업</a></li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	
	<div class="container">
	<div class="image-container">
		<c:forEach var="imagePath" items="${studioImagesList}" varStatus="loop">
			<img src="${pageContext.request.contextPath}/${imagePath}"
				alt="Studio Image" />
			<c:if test="${loop.index eq 0}">
				<%-- 첫 번째 이미지에만 적용될 스타일 --%>
				<div style="margin-right: 20px;"></div>
		
			</c:if>
		</c:forEach>
	</div>
	</div>
	<div class="contact-button">
		<button class="btn btn-outline-light rounded-pill border-2 py-3 px-5 animated slideInRight" onclick="showPhoneNumber()">Contact</button>
	</div>

	<!-- Modal -->
	<div id="myModal" class="modal">
		<div class="modal-content">
			<br>
			<p> tel : ${dressShop.phone}</p>
			<br>
			<span id ="modal_span" class="btn btn-outline-light rounded-pill border-1 py-2 px-1 animated slideInRight" onclick="closeModal()">닫기 </span>
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
