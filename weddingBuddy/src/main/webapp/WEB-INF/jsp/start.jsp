<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프레임 예시</title>
<style>
body, html {
	height: 100%;
	margin: 0;
	padding: 0;
}

.iframe-container {
	height: 100%;
	float: left;
	box-sizing: border-box;
	border: 1px solid #ccc;
}

.iframe-container:first-child {
	width: 70%;
}

.iframe-container iframe {
	width: 100%;
	height: 100%;
	border: none;
}
</style>
<script type="text/javascript">
	var iframe1 = document.getElementById('contentFrame');
	var iframe2 = document.getElementById('chatFrame');

	var iframe2Url = iframe2.src;
	console.log('iframe2 URL: ', iframe2Url);
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
	<div class="iframe-container">
		<iframe src="<c:url value="/" />" name="contentrame" id="contentFrame"></iframe>
	</div>
	<div class="iframe-container">
		<button onclick="goBack()">뒤로 가기</button>
		<iframe src="<c:url value="/mypage/chat"/>" name="chatFrame"
			id="chatFrame"></iframe>
	</div>

	<!-- 	<script>
		// 드래그 앤 드롭 기능 구현을 위한 JavaScript 코드
		var element = document.getElementById("element");
		var isDragging = false;
		var offsetX = 0;
		var offsetY = 0;

		element.addEventListener("mousedown", function(event) {
			isDragging = true;
			offsetX = event.clientX - element.offsetLeft;
			offsetY = event.clientY - element.offsetTop;
		});

		document.addEventListener("mousemove", function(event) {
			if (isDragging) {
				element.style.left = (event.clientX - offsetX) + "px";
				element.style.top = (event.clientY - offsetY) + "px";
			}
		});

		document.addEventListener("mouseup", function() {
			isDragging = false;
		});
	</script> -->
</body>

</html>