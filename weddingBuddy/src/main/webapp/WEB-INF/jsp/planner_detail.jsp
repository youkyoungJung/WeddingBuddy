<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>플래너 상세보기</title>

<jsp:include page="navbar.jsp" />
<style>

.carousel-example-generic {
  width: 500px; /* 원하는 가로 크기로 설정 */
  height: 300px; /* 원하는 세로 크기로 설정 */
}


/* 캐러셀(이미지슬라이드) 이미지 크기변경 */
.carousel-inner {
	width: auto;
	height: 790px; /* 이미지 높이 변경 */
}

.carousel-item {
	width: auto;
	height: 100%;
}

.d-block {
	display: block;
	width: auto;
	height: 100%;
}
</style>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.2.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.2.1/js/bootstrap.min.js"></script>
</head>
<body>

	<section class="slider-section">
		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators slider-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class="active"></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"></li>
				<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active" width="100px">
					<img src="<c:url value="/images/logo.jpg"/>" alt="">
				</div>
			</div>

			<!-- Controls 버튼 -->
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span
				class="pe-7s-angle-left glyphicon-chevron-left" aria-hidden="true"></span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span
				class="pe-7s-angle-right glyphicon-chevron-right" aria-hidden="true"></span>
			</a>
		</div>
	</section>





	<script src="<c:url value="//code.jquery.com/jquery-3.2.1.min.js"/>"></script>
	<script src="<c:url value="/js/owl.carousel.js" />"></script>
	<script>
	
		$(function(){
		 	$('.owl-carousel').owlCarousel( 
		 		items: 4,
		 		margin: 10,
		 		loop: true,
		 		autoWidth:true
		 	);
		 });
	</script>

</body>
<jsp:include page="footer.jsp" />

</html>