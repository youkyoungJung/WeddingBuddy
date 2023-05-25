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

/* 	function goBack() {
		window.history.back();
	} */
	
	function changeIframe(url) {
        // iframe1의 src 속성 변경
        document.getElementById("contentFrame").src = url;
    }
</script>
</head>
<body>
	<div class="iframe-container">
		<iframe src="<c:url value="/" />" name="contentrame" id="contentFrame"></iframe>
	</div>
	<div class="iframe-container">
		<!-- <button onclick="goBack()">뒤로 가기</button> -->
		<iframe src="<c:url value="/chat/${to_id }/${from_id }"/>" name="chatFrame"
			id="chatFrame"></iframe>
	</div>
</body>

</html>