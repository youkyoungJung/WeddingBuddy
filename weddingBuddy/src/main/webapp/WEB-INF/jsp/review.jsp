<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
	
</script>
<style>
@font-face {
	font-family: 'Cafe24Simplehae';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}



.h2 {
	font-family: 'Cafe24Simplehae', sans-serif;
	font-weight: normal; /* 필요에 따라 font-weight를 추가하세요 */
	font-style: normal; /* 필요에 따라 font-style을 추가하세요 */
	margin-left: 30px;
	margin-top: 20px;
	padding: 20px;
	margin-bottom: 20px;
}

.form-outline {
	width: 600px;
	margin: 0 auto;
}

.file-upload {
	border-radius:30px;
	position: relative;
	background-color: #ffffff;
	width: 600px;
	margin: 0 auto;
	/* 	padding: 20px;
 */
}

.file-upload-btn {
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	width: 600px;
	color: #fff;
	display: flex;
	justify-content: center; /* 가로 중앙 정렬 */
	background: #f2a7a7;
	border: none;
	padding: 10px;
	border-radius: 4px;
	border-bottom: 4px solid #f57373;
	transition: all .2s ease;
	outline: none;
	text-transform: uppercase;
	font-weight: 700;
}

.file-upload-btn:hover {
	background: #fad9d9;
	color: #ffffff;
	transition: all .2s ease;
	cursor: pointer;
}

.file-upload-btn:active {
	border: 0;
	transition: all .2s ease;
}

.file-upload-content {
	display: none;
	text-align: center;
}

.file-upload-input {
	position: absolute;
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
	outline: none;
	opacity: 0;
	cursor: pointer;
}

.image-upload-wrap {
	margin-top: 20px;
	border: 4px dashed #f2a7a7;
	position: relative;
}

.image-dropping, .image-upload-wrap:hover {
	background-color: #fad9d9;
	border: 4px dashed #ffffff;
}

.image-title-wrap {
	padding: 0 15px 15px 15px;
	color: #222;
}

.drag-text {
	text-align: center;
}

.drag-text h3 {
	font-weight: 100;
	text-transform: uppercase;
	color: #f2a7a7;
	padding: 60px 0;
}

.file-upload-image {
	max-height: 200px;
	max-width: 600px;
	margin: auto;
	padding: 20px;
}

.remove-image {
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	width: 600px;
	color: #fff;
	display: flex;
	justify-content: center; /* 가로 중앙 정렬 */
	width: 600px;
	margin: 0;
	background: #f2a7a7;
	border: none;
	padding: 10px;
	border-radius: 4px;
	border-bottom: 4px solid #b02818;
	transition: all .2s ease;
	outline: none;
	text-transform: uppercase;
	font-weight: 700;
}

.remove-image:hover {
	background: #f2a7a7;
	color: #ffffff;
	transition: all .2s ease;
	cursor: pointer;
}

.remove-image:active {
	border: 0;
	transition: all .2s ease;
}

.btn {
	background-color: #f2a7a7;
	border-color: #f2a7a7;
}

.btn-primary {
	background-color: #f2a7a7;
	border-color: #f2a7a7;
}

.btn-block {
	background-color: #f2a7a7;
	border-color: #f2a7a7;
}
</style>
<script>
	function readURL(input) {
		if (input.files && input.files[0]) {

			var reader = new FileReader();

			reader.onload = function(e) {
				$('.image-upload-wrap').hide();

				$('.file-upload-image').attr('src', e.target.result);
				$('.file-upload-content').show();

				$('.image-title').html(input.files[0].name);
			};

			reader.readAsDataURL(input.files[0]);

		} else {
			removeUpload();
		}
	}

	function removeUpload() {
		$('.file-upload-input').replaceWith($('.file-upload-input').clone());
		$('.file-upload-content').hide();
		$('.image-upload-wrap').show();
	}
	$('.image-upload-wrap').bind('dragover', function() {
		$('.image-upload-wrap').addClass('image-dropping');
	});
	$('.image-upload-wrap').bind('dragleave', function() {
		$('.image-upload-wrap').removeClass('image-dropping');
	});
</script>


</head>
<body>

	<div class="container-xxl bg-white p-0">
		<%@ include file="navbar.jsp"%>
		<div class="container-xxl bg-primary page-header">
			<div class="container text-center">
				<h1 class="text-white animated zoomIn mb-3">리뷰작성</h1>
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

	<form action="<c:url value="/review" />" method="POST"
		enctype="multipart/form-data">
		<input type="hidden" name="planner_id" value="${planner_id}">
		<input type="hidden" name="user_id" value="${user_id}">

		<!-- Message input -->
		<div class="form-outline mb-4" style= "font-family: Cafe24Simplehae;">
			<textarea class="form-control" id="form4Example3" rows="10"
				name="content" placeholder="Tell me what you think!"></textarea>
		</div>

		<!-- 파일 업로드 부분 -->
		<div class="file-upload">
			<div class="image-upload-wrap">
				<!-- 파일 선택을 위한 input 필드 -->
				<input class="file-upload-input" type="file" name="formFileMultiple"
					multiple onchange="readURL(this);" accept="image/*" />

				<div class="drag-text" style= "font-family: Cafe24Simplehae;">
					<h3>Drag and drop a file or select add Image</h3>
				</div>
			</div>

			<div class="file-upload-content" style= "font-family: Cafe24Simplehae;" >
				<img class="file-upload-image" src="#" alt="your image" />
				<!-- 이미지를 미리보기할 영역 -->
				<div class="image-title-wrap">
					<button type="button" onclick="removeUpload()" class="remove-image">
						Remove <span class="image-title">Uploaded Image</span>
					</button>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<!-- Submit button -->
		<button type="submit" class="file-upload-btn" style= "font-family: Cafe24Simplehae;">등록하기</button>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>

	<jsp:include page="footer.jsp" />
</body>
</html>
