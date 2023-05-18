<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<style>
body {
	background: #eee;;
}

.title {
	text-shadow: 2px 2px 0px rgba(0, 0, 0, 0.4) !important;
}

.divider-title {
	border: 1px solid #dddddd;
}

.project {
	margin-bottom: 30px;
	vertical-align: top;
	margin-right: 30px;
	float: left;
	cursor: pointer;
	width: 100%;
}

.project figure {
	position: relative;
	display: inline-block;
	width: 283px;
	-moz-box-shadow: 0 3px 0 #e2e2e2, transparent 0 0 0;
	-webkit-box-shadow: 0 3px 0 #e2e2e2, transparent 0 0 0;
	box-shadow: 0 3px 0 #e2e2e2, transparent 0 0 0;
	-webkit-box-shadow: 0 3px 0 #e2e2e2;
	-moz-box-shadow: 0 3px 0 #e2e2e2;
	box-shadow: 0 3px 0 #e2e2e2;
}

.project figure figcaption {
	position: relative;
	z-index: 10;
	padding: 8px 18px 11px;
	background: #fff;
	-ms-transition: all .2s ease-out;
	-webkit-transition: all .2s ease-out;
	-moz-transition: all .2s ease-out;
	-o-transition: all .2s ease-out;
	transition: all .2s ease-out;
	text-align: left;
	color: #555;
}

.project figure:hover .actions {
	opacity: 1;
}

.project figure .actions {
	display: block;
	position: absolute;
	top: 0;
	z-index: 1;
	width: 100%;
	height: 100%;
	opacity: 0;
	background-color: rgba(29, 29, 29, .7);
	-ms-transition: all .2s ease-out;
	-webkit-transition: all .2s ease-out;
	-moz-transition: all .2s ease-out;
	-o-transition: all .2s ease-out;
	transition: all .2s ease-out;
}

.project figure img {
	border: 0;
	width: 100%;
}

.btn-warning bnt-action {
	margin: 0% 0% auto;
}

figcaption .project-details {
	display: block;
	font-size: 16px;
	line-height: 33px;
	color: #0093d0;
	height: 27px;
	width: 85%;
	margin-bottom: 5px;
	overflow: hidden;
}

figcaption .project-price {
	position: absolute;
	right: 15px;
	top: 12px;
	font-size: 22px;
	text-align: right;
	margin-top: 8px;
	letter-spacing: -1px;
	-webkit-font-smoothing: antialiased;
}

figcaption .project-creator {
	font-size: 13px;
	color: #545454;
	display: block;
}

figcaption .project-creator {
	font-size: 13px;
	color: #545454;
	display: block;
}

.project figure .actions button {
	padding: 13px 20px;
	font-size: 16px;
	top: 32%;
	position: absolute;
	left: 50%;
	width: 90%;
	margin-left: -45%;
	line-height: 18px;
	letter-spacing: 1px;
}
</style>
<!-- Core theme CSS (includes Bootstrap)-->
<link rel="stylesheet" href="/css/style.css">
<!-- 부트스트랩 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<jsp:include page="navbar.jsp" />
<body>

	<div class="container bootstrap snippets bootdey">
		<h1 class="text-center text-primary title">Wedding Buddy MyPage</h1>
		<hr class="divider-title">

		<div class="col-ms-10 col-md-4">
			<div class="project">
				<figure class="img-responsive">
					<img src="<c:url value='/images/mypage_like.png' />" > 
					<span class="actions">
						<button class="btn btn-warning bnt-action" type="submit">♥찜 바로가기 ♥
						</button>
					</span>
				</figure>
			</div>
		</div>

		<div class="col-ms-10 col-md-4">
			<div class="project">
				<figure class="img-responsive">
					<img src="<c:url value='/images/mypage_update.png' />" > 
					<span class="actions">
						<button class="btn btn-warning bnt-action" type="submit">♥내 정보수정♥
						</button>
					</span>
				</figure>
			</div>
		</div>


		<div class="col-ms-10 col-md-4">
    <div class="project">
        <figure class="img-responsive">
            <a href="<c:url value='/userChat' />">
                <img src="<c:url value='/images/mypage_chat.png' />">
                <span class="actions">
                    <button class="btn btn-warning bnt-action" type="submit">♥내 채팅방♥</button>
                </span>
            </a>
        </figure>
    </div>
</div>

</body>
<jsp:include page="footer.jsp" />

</html>