<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
  </style>
  <script type="text/javascript">
    function toggleIframe2() {
      var iframe1 = document.getElementById('contentFrame');
      var iframe2 = document.getElementById('chatFrame');
      var iframe2Visible = iframe2.style.display === 'none';

      if (iframe2Visible) {
        iframe2.style.display = 'block';
        iframe1.style.width = '70%';
      } else {
        iframe2.style.display = 'none';
        iframe1.style.width = '100%';
      }
    }

    function changeIframe(url) {
      document.getElementById('contentFrame').src = url;
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
