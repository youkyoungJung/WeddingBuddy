<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Studio.jsp</title>
<style>

.service-icon{
	height: 30px;
	width: 30px;
	
}
.image-container {
	text-align: center;
	margin-bottom: 10px;
}

.image-container img {
	display: flex;
	padding : 5px;
	margin : 3px;
	max-width: 300px;
	height: auto;
	margin: 0 auto; /* 가운데 정렬을 위한 margin 설정 */
}

.heart-container {
	position: relative;
	top: 10px;
	right: 10px;
}

.heart-button {
	display: inline-block;
	position: relative;
}

.flower_image {
	width: 30px;
	height: 30px;
}
</style>
<script>
        function goToStudioDetail(studio_id) {
            var contextPath = "${pageContext.request.contextPath}";
            location.href = contextPath + '/studio_detail?studio_id=' + studio_id;
        }

        function handleFavoriteClick(event) {
            event.preventDefault(); // 기본 동작 방지

            var heartImage = event.currentTarget.querySelector('img');
            var isFavorite = heartImage.getAttribute('src') === '${pageContext.request.contextPath}/images/prev_heart.png';

            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    if (isFavorite) {
                        heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/next_heart.png');
                    } else {
                        heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/prev_heart.png');
                    }
                }
            };
        }
    </script>
</head>
<body>
	<div class="container-xxl bg-white p-0">
		<%@ include file="navbar.jsp"%>
		<div class="container-xxl bg-primary page-header">
			<div class="container text-center">
				<h1 class="text-white animated zoomIn mb-3">스튜디오 </h1>
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


	<div class="container-xxl py-6">
		<div class="container">
			<div class="row g-4">
				<c:forEach var="studio" items="${studios}">
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s"
						onclick="goToStudioDetail(${studio.studio_id})">
						<div class="service-item rounded h-100">
							<div class="d-flex justify-content-between">
								<div class="service-icon"style="display: flex; align-items: center;">
									<i class="bi bi-heart" style="font-size: 20px; color: #F8E8EE;"></i>
								</div>
							</div>

							<c:set var="firstImage" value="${true}" />
							<!-- 첫 번째 이미지를 표시하기 위한 변수 추가 -->

							<c:forEach var="studioImage" items="${studioImagesList}">
								<c:if
									test="${studioImage.company_unique_id == studio.company_unique_id}">
									<div class="image-container">
										<c:if test="${firstImage}">
											<img src="<c:url value='${studioImage.image}' />"
												alt="studio Image" style="max-width: 300px; height: auto;" />
											<c:set var="firstImage" value="${false}" />
										</c:if>
									</div>
								</c:if>
							</c:forEach>

							<div class="p-5">
								<h5 class="mb-3">${studio.name}</h5>
								<span>${studio.price_range}만원</span>
							</div>

						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>
