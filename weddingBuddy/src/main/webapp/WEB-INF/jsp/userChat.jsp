<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap CSS 파일 로드 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>내 채팅방</title>
<style>
.chatback {
	float: right;
	width: 200px;
	height: 100px;
}

.list-group-item.custom-list-item {
	background-color: #F4E0E0;
}

.list-group-item.custom-list-item {
	margin-bottom: 20px;
}
</style>

<%@ include file="navbar.jsp"%>
</head>

<body>
	<div class="container">
		<h1>내 채팅방</h1>

		<div class="row">
			<div class="col-lg-10 col-md-10 col-sm-12">
				<div class="list-group">
					<a href="#"
						class="list-group-item list-group-item-action d-flex justify-content-between align-items-center custom-list-item">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1"></h5>
							<small class="text-muted">14</small>
						</div>
						<p class="mb-1">Additional content goes here</p> <small
						class="text-muted">More info</small>
						<div>
							<button type="button" class="btn btn-primary">채팅 바로가기</button>
							<button type="button" class="btn btn-secondary">리뷰 쓰기</button>
						</div>
					</a> <a href="#"
						class="list-group-item list-group-item-action d-flex justify-content-between align-items-center custom-list-item">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">A second list item</h5>
							<small class="text-muted">2</small>
						</div>
						<p class="mb-1">Additional content goes here</p> <small
						class="text-muted">More info</small>
						<div>
							<button type="button" class="btn btn-primary">채팅 바로가기</button>
							<button type="button" class="btn btn-secondary">리뷰 쓰기</button>
						</div>
					</a> <a href="#"
						class="list-group-item list-group-item-action d-flex justify-content-between align-items-center custom-list-item">
						<div class="d-flex w-100 justify-content-between">
							<h5 class="mb-1">A third list item</h5>
							<small class="text-muted">1</small>
						</div>
						<p class="mb-1">Additional content goes here</p> <small
						class="text-muted">More info</small>
						<div>
							<button type="button" class="btn btn-primary">채팅 바로가기</button>
							<button type="button" class="btn btn-secondary">리뷰 쓰기</button>
						</div>
					</a>
				</div>
			</div>
		</div>
	</div>


	<!-- Bootstrap JS 파일 로드 -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0/js/bootstrap.min.js"></script>
</body>
</html>