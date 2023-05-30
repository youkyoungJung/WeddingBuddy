<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 채탱방</title>
<meta charset="UTF-8">
<title>프레임 예시</title>
<style>
body, html {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

.iframe-container {
	width: 25%;
	height: 100%;
	float: left;
	box-sizing: border-box;
	border: 1px solid #ccc;
}

.iframe-container:first-child {
	width: 75%;
}

.iframe-container iframe {
	width: 100%;
	height: 100%;
	border: none;
}

.back-button {
	position: absolute;
	top: 10px;
	left: 10px;
	z-index: 9999;
	width: 40px;
	height: 40px;
	background-image: url('../weddingBuddy/images/back_button.png');
	background-size: cover;
	border: none;
	cursor: pointer;
}
</style>
<script type="text/javascript">
	var iframe1 = document.getElementById('contentFrame');
	var iframe2 = document.getElementById('chatFrame');

	function changeIframe(url) {
		document.getElementById('contentFrame').src = url;
	}

	function goBack() {
		window.location.href = '/weddingBuddy/mypage/chat';
	}
</script>
</head>
<body>

	<div class="iframe-container">
		<iframe src="<c:url value="/" />" name="contentrame" id="contentFrame"></iframe>
	</div>
	<div class="iframe-container">
		<button class="back-button" onclick="goBack()"></button>
		<iframe src="<c:url value="/chat/${to_id }/${from_id }"/>"
			name="chatFrame" id="chatFrame"></iframe>
	</div>
</body>
</html>
