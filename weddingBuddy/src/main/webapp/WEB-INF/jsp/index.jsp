<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Searching Planner</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/chat.css">

<style>


body{
    margin-top:20px;
    background:#FAFAFA;    
=======
body {
	margin-top: 20px;
	background: #FAFAFA;
>>>>>>> branch 'develop' of https://github.com/Kongonii/WeddingBuddy.git
}
/*==================================================
  Nearby People CSS
  ==================================================*/
<<<<<<< HEAD
  
  
  
  
  
 .header-avatar{
 	pointer-events: none;
 } 

.people-nearby .google-maps{
  background: #f8f8f8;
  border-radius: 4px;
  border: 1px solid #f1f2f2;
  padding: 20px;
  margin-bottom: 20px;
=======
.people-nearby .google-maps {
	background: #f8f8f8;
	border-radius: 4px;
	border: 1px solid #f1f2f2;
	padding: 20px;
	margin-bottom: 20px;
>>>>>>> branch 'develop' of https://github.com/Kongonii/WeddingBuddy.git
}

.people-nearby .google-maps .map {
	height: 300px;
	width: 100%;
	border: none;
}

.people-nearby .nearby-user {
	padding: 20px 0;
	border-top: 1px solid #f1f2f2;
	border-bottom: 1px solid #f1f2f2;
	margin-bottom: 20px;
}

img.profile-photo-lg {
	height: 80px;
	width: 80px;
	border-radius: 50%;
}

#header {
	margin-left: 30px;
}

.chat-icon img {
	width: 60px;
	height: 60px;
}
</style>
<jsp:include page="navbar.jsp" />

</head>

<body>
	<div class="container">
		<h3 id="header">Best Planner Top 3</h3>
		<c:forEach items="${plannerTop3}" var="planner">
			<div class="row">
				<div class="col-md-8">
					<div class="people-nearby">
						<div class="nearby-user">
							<div class="row">
								<div class="col-md-2 col-sm-2">
									<img src="https://bootdey.com/img/Content/avatar/avatar7.png"
										alt="user" class="profile-photo-lg">
								</div>
								<div class="col-md-7 col-sm-7">
									<h5>
										이름: <a href="#" class="profile-link">${planner.name }</a>
									</h5>
									<p>소속:${planner.agency_name }</p>
									<p class="text-muted">소개: ${planner.intro }</p>
								</div>
								<div class="col-md-3 col-sm-3">
									<button class="btn btn-primary pull-right">고객후기:
										${planner.cnt }</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


	<c:if test="${isLogin}">
		<!DOCTYPE html>
		<html>
<head>
<meta charset="UTF-8">
<title>Chat Room</title>
</head>
<body>
<<<<<<< HEAD
<div class="chat-icon" style="position: fixed; bottom: 20px; right: 20px; z-index: 9999;">
    <img src="${pageContext.request.contextPath}/images/chaticon.png" alt="Chat Icon" class="chat-icon-image" style="display: none;" onload="this.style.display = 'block';" onclick="return false;" >
    <div id="tlkio" data-channel="weddingbuddy" data-theme="theme--pop;" style="width:100%;height:600px;" link rel = "stylesheet" data-custom-css="http://w3schools.com"></div>
</div>
<script async src="https://tlk.io/embed.js" type="text/javascript"></script>
=======
	<div class="chat-icon"
		style="position: fixed; bottom: 20px; right: 20px; z-index: 9999;">
		<img src="${pageContext.request.contextPath}/images/chaticon.png"
			alt="Chat Icon" class="chat-icon-image">
		<div id="tlkio" data-channel="weddingbuddy" data-theme="theme--pop"
			style="display: none;"></div>
	</div>
>>>>>>> branch 'develop' of https://github.com/Kongonii/WeddingBuddy.git

	<script async src="https://tlk.io/embed.js" type="text/javascript"></script>

	<script type="text/javascript">
		var tlkio = document.getElementById('tlkio');
		var username = "<c:out value="${account_id}" />";
		tlkio.setAttribute('data-nickname', username);
		tlkio.setAttribute('data-disable-twitter', 'true');
	</script>

</body>
		</html>

	</c:if>
	<script src="<c:url value="//code.jquery.com/jquery-3.2.1.min.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('.chat-icon').click(function() {
				$('#tlkio').toggle();
			});
		});
	</script>

</body>

<jsp:include page="footer.jsp" />
</html>