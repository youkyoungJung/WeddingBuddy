<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<style>
body {
	font-family: sans-serif;
	background-color: #eeeeee;
}

.h2 {
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
	background-color: #ffffff;
	width: 600px;
	margin: 0 auto;
	/* 	padding: 20px;
 */
}

.file-upload-btn {
	width: 100%;
	margin: 0;
	color: #fff;
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
	max-width: 200px;
	margin: auto;
	padding: 20px;
}

.remove-image {
	width: 200px;
	margin: 0;
	color: #fff;
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

<jsp:include page="navbar.jsp" />
<!-- <link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script> -->

</head>
<body>
	<script class="jsbin"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>

	<form action="<c:url value="/review" />" method="POST"
		enctype="multipart/form-data">
		<input type="hidden" name="planner_id" value="${planner_id }">
		<!-- Message input -->
		<div class="form-outline mb-4">
			<h2>리뷰 작성</h2>
			<label class="form-label" for="form4Example3">Tell me what
				you think!</label>
			<textarea class="form-control" id="form4Example3" rows="10"
				name="content"></textarea>
		</div>
		<div class="file-upload">
			<div class="image-upload-wrap">
				<input class="file-upload-input" type='file' multiple='multiple'
					name="image_url" onchange="readURL(this);"
					accept="<c:url value="/images/*" />" />
				<div class="drag-text">
					<h3>Drag and drop a file or select add Image</h3>
				</div>
			</div>
			<div class="file-upload-content">
				<img class="file-upload-image" src="#" alt="your image" />
				<div class="image-title-wrap">
					<button type="button" onclick="removeUpload()" class="remove-image">
						Remove <span class="image-title">Uploaded Image</span>
					</button>
				</div>
			</div>
			<label for="formFileMultiple" class="form-label">Multiple
				files input example</label> <input class="form-control" type="file"
				id="formFileMultiple" multiple />
			<!-- Submit button -->
			<br>
			<button type="submit" class="file-upload-btn">등록하기</button>
		</div>


	</form>

	<jsp:include page="footer.jsp" />
</body>
</html>