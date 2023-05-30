<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Review Detail</title>
<style>
@font-face {
	font-family: 'Cafe24Simplehae';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

.review-item {
	margin-bottom: 10px;
	margin-top: 10px;
	padding: 5px;
	position: relative;
	display: flex;
	align-items: center;
	width: 70%; 
	margin-left: auto;
	margin-right: auto;
}

.review-item h3 {
	margin-top: 0;
	font-size: 20px;
}

.review-item p {
	margin: 0;
}

.review-List {
	border-radius:30px;
	width: 70%;
	height: 150px;
	background: #F5F5F5;
	position: relative;
	z-index: 1;
	padding: 10px;
	display: flex; /* 수정: 내용을 수직 가운데 정렬하기 위해 flex 설정 */
	flex-direction: column;
	/* 수정: 내용을 수직 가운데 정렬하기 위해 flex-direction을 column으로 설정 */
	justify-content: center;
	/* 수정: 내용을 수직 가운데 정렬하기 위해 justify-content를 center로 설정 */
}

.review-List .content {
	font-weight: bold;
	font-family: 'Cafe24Simplehae';
	margin-bottom: 10px;
}

.review-List .nameAndDate {
	font-family: 'Cafe24Simplehae';
	margin-bottom: 10px;
}

.review-Image {
	position: absolute;
	width: 30%;
	height: 100%;
	left: calc(70% + 3px);
	top: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	overflow: hidden;
	margin-bottom: 20px;
	padding: 10px;
}

.review-Image img {
	max-width: 100%;
	max-height: 100%;
}

.slideshow-button {
	position: absolute;
	top: 50%;
	transform: translateY(-50%);
	width: 40px;
	height: 40px;
	background-color: #f5f5f5;
	border-radius: 70%;
	border: none;
	color: #000;
	font-size: 24px;
	cursor: pointer;
	align-items: center;
	justify-content: center;
	display: none;
}

.slideshow-button.prev {
	left: 10px;
}

.slideshow-button.next {
	right: 20px;
	color: pink !important;
}

.review-item:hover .slideshow-button {
	display: flex;
}

.hidden {
	display: none;
}

.visible {
	display: block;
}





</style>

</head>
<body>
	
	
	<div class="container-xxl bg-white p-0">
		<%@ include file="navbar.jsp"%>
		<div class="container-xxl bg-primary page-header">
			<div class="container text-center">
				<h1 class="text-white animated zoomIn mb-3">전체 리뷰</h1>
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb justify-content-center">
						
						<li class="breadcrumb-item"><a class="text-white" href="<c:url value="/mypage/like"/>">찜</a></li>
						<li class="breadcrumb-item"><a class="text-white" href="<c:url value='/mypage/'/>">내정보수정</a></li>
						<li class="breadcrumb-item"><a class="text-white" href="<c:url value='/mypage/chat'/>">내채팅방</a></li>
						
					</ol>
				</nav>
			</div>
		</div>
	</div>

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
				<div class="review-List">

					<div class="content">
						<h3>${review.content}</h3>
					</div>
					<div class="nameAndDate">
						<!-- user_id에 해당하는 name 값을 가져와서 표시 -->
						<p>
							<c:out value="${userAccountMap[review.user_id]}" />
							|
							<c:set var="formattedDate"
								value="${review.reg_date.substring(0, 10)}" />
							${formattedDate}
						</p>
					</div>
				</div>
				<c:if test="${reviewImagesList.size() > 1}">
					<div class="review-Image">
						<c:forEach var="reviewImage" items="${reviewImagesList}"
							varStatus="loop">
							<c:if test="${reviewImage.review_id == review.review_id}">
								<img src="<c:url value='${reviewImage.image}' />"
									alt="Review Image"
									class="<c:if test='${loop.index == 0}'>visible</c:if> hidden" />
							</c:if>
						</c:forEach>
					</div>
					<button class="slideshow-button prev" onclick="prevImage(this)"></button>
					<button class="slideshow-button next" onclick="nextImage(this)">
					<i class="bi bi-arrow-right-circle-fill"></i>
					</button>
				</c:if>
			</div>
		</c:forEach>
	</c:if>

	<jsp:include page="footer.jsp" />

	<script>
		function prevImage(button) {
			var imageWrapper = button.parentElement
					.querySelector('.review-Image');
			var images = imageWrapper.querySelectorAll('img');
			var currentImageIndex = 0;
			for (var i = 0; i < images.length; i++) {
				if (images[i].classList.contains('visible')) {
					currentImageIndex = i;
					break;
				}
			}
			images[currentImageIndex].classList.remove('visible');
			images[currentImageIndex].classList.add('hidden');
			if (currentImageIndex === 0) {
				images[images.length - 1].classList.remove('hidden');
				images[images.length - 1].classList.add('visible');
			} else {
				images[currentImageIndex - 1].classList.remove('hidden');
				images[currentImageIndex - 1].classList.add('visible');
			}
		}

		function nextImage(button) {
			var imageWrapper = button.parentElement
					.querySelector('.review-Image');
			var images = imageWrapper.querySelectorAll('img');
			var currentImageIndex = 0;
			for (var i = 0; i < images.length; i++) {
				if (images[i].classList.contains('visible')) {
					currentImageIndex = i;
					break;
				}
			}
			images[currentImageIndex].classList.remove('visible');
			images[currentImageIndex].classList.add('hidden');
			if (currentImageIndex === images.length - 1) {
				images[0].classList.remove('hidden');
				images[0].classList.add('visible');
			} else {
				images[currentImageIndex + 1].classList.remove('hidden');
				images[currentImageIndex + 1].classList.add('visible');
			}
		}

		window.addEventListener('DOMContentLoaded', function() {
			  var reviewItems = document.querySelectorAll('.review-item');
			  for (var i = 0; i < reviewItems.length; i++) {
			    var reviewImageWrapper = reviewItems[i].querySelector('.review-Image');
			    var images = reviewImageWrapper.querySelectorAll('img');
			    if (images.length > 1) {
			      images[0].classList.add('visible');
			      images[0].classList.remove('hidden');
			      reviewItems[i].querySelector('.slideshow-button').style.display = 'flex';
			    } else if (images.length === 1) {
			      images[0].classList.add('visible');
			      images[0].classList.remove('hidden');
			    }
			  }
			});

	</script>

</body>
</html>