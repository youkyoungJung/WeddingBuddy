<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Searching Planner</title>

<style>
body {
	margin-top: 20px;
	background: #FAFAFA;
}
/*==================================================
  Nearby People CSS
  ==================================================*/
.people-nearby .google-maps {
	background: #f8f8f8;
	border-radius: 4px;
	border: 1px solid #f1f2f2;
	padding: 20px;
	margin-bottom: 20px;
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

.box-radio-input input[type="radio"] {
	display: none;
}

.box-radio-input input[type="radio"]+span {
	display: inline-block;
	background: none;
	border: 1px solid #dfdfdf;
	padding: 0px 10px;
	text-align: center;
	height: 35px;
	line-height: 33px;
	font-weight: 500;
	cursor: pointer;
}

.box-radio-input input[type="radio"]:checked+span {
	border: 1px solid #F48fb1;
	background: #F48fb1;
	color: #fff;
}


#custom-search-input {
	padding: 3px;
	border: solid 1px #E4E4E4;
	border-radius: 6px;
	background-color: #fff;
	width: 40%
}

#custom-search-input input {
	border: 0;
	box-shadow: none;
}

#custom-search-input button {
	margin: 2px 0 0 0;
	background: none;
	box-shadow: none;
	border: 0;
	color: #666666;
	padding: 0 8px 0 10px;
	border-left: solid 1px #ccc;
}

#custom-search-input button:hover {
	border: 0;
	box-shadow: none;
	border-left: solid 1px #ccc;
}

#custom-search-input .glyphicon-search {
	font-size: 23px;
}
</style>
<jsp:include page="navbar.jsp" />

</head>

<body>

	<div class="container">
		<h3 id="header">플래너 찾기</h3>

		<!-- 검색뷰 시작 -->
		<section class="search-section">
			<div align="center">
				<form action="<c:url value='/search'/>" accept-charset="utf-8">
					<label class="box-radio-input"><input type="radio"
						name="type" value="area" checked="checked"><span>지역</span></label>
					<label class="box-radio-input"><input type="radio"
						name="type" value="name"><span>이름</span></label> <label
						class="box-radio-input"><input type="radio" name="type"
						value="group"><span>소속</span></label> 

					<div id="custom-search-input">
						<div class="input-group col-md-12">
							<input type="text" class="form-control input-lg"
								placeholder="검색어를 입력하세요." name="search" /> <span
								class="input-group-btn">
								<button class="btn btn-info btn-lg" type="submit">
									<i class="glyphicon glyphicon-search"></i>
								</button>
							</span>
						</div>
					</div>
					
				</form>
			</div>
		</section>
		<!-- 검색 끝 -->
		<br>
<!-- 모든플래너 -->
		<c:forEach items="${PlannerAll}" var="planner">
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
										이름:<a href="<c:url value="/search/planner/detail" />" class="profile-link">${planner.name }</a>
									</h5>
									<p>소속:${planner.agency_name }</p>
									<p class="text-muted">소개: ${planner.intro }</p>
								</div>
								<div class="col-md-3 col-sm-3">
									<button class="btn btn-primary pull-right" onClick=location.href='<c:url value="#"/>' >고객후기:
										${planner.cnt }</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>


<jsp:include page="footer.jsp" />
</html>