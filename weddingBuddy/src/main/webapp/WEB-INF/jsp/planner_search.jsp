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
<form method="post" action="<c:url value='/search/planner' />" accept-charset="utf-8">
    <label class="box-radio-input">
        <input type="radio" name="type" value="area" <c:if test="${type eq 'area'}">checked="checked"</c:if>>
        <span>지역</span>
    </label>
    <label class="box-radio-input">
        <input type="radio" name="type" value="name" <c:if test="${type eq 'name'}">checked="checked"</c:if>>
        <span>이름</span>
    </label>
    <label class="box-radio-input">
        <input type="radio" name="type" value="group" <c:if test="${type eq 'group'}">checked="checked"</c:if>>
        <span>소속</span>
    </label>




			<div id="custom-search-input">
				<div class="input-group col-md-12">
					<input type="text" class="form-control input-lg" placeholder="검색어를 입력하세요." name="search"  value = "${searchKeyword }"/>
					<span class="input-group-btn">
						<button class="searchbtn" type="submit">
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
<div class="row justify-content-center"> <!-- 중앙 정렬을 위해 justify-content-center 클래스 추가 -->
		<c:forEach items="${PlannerAll}" var="planner">
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
  <button class="btn btn-primary pull-right" onclick="redirectToReviewDetail(${planner._id})">
                                    고객후기: ${planner.cnt}
                         	</button>
    <div style="text-align: center; margin-top: 10px;">
    <a href="#" class="image-button" onclick = "handleFavoriteClick(${planner._id})">
      <img id="heartImage" src="${pageContext.request.contextPath}/images/prev_heart.png" alt="이미지 버튼" class="img-fluid" style="width: 30px; height: 30px; margin-top: 20px; margin-left: 60px;" data-planner-id = "${planner._id}">
    </a>
    
    <script>
function handleFavoriteClick(plannerId) {
	console.log('aaa')
  // 서버로 AJAX 요청을 보내 찜하기 상태를 업데이트
  var heartImage = document.getElementById('heartImage');
  var isFavorite = heartImage.getAttribute('src') == '${pageContext.request.contextPath}/images/prev_heart.png';
  console.log("isFavorite", heartImage.getAttribute('src'))

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
	  if (this.readyState === 4 && this.status === 200) {
	    // 응답을 받았을 때 처리할 내용
	    if (isFavorite) {
	      heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/next_heart.png');
	    } else {
	      heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/prev_heart.png');
	    }

	    // 플래너 정보 업데이트
/* 	    var plannerName = document.getElementById('plannerName');
	    plannerName.textContent = '${planner.name}';  */// 업데이트할 플래너 정보를 서버에서 받아와서 설정
	  }
	};


  xhttp.open('POST', '${pageContext.request.contextPath}/updateFavorite', true);
  xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
  xhttp.send('planner_id=' + plannerId + '&isFavorite=' + isFavorite);
  
  console.log("planner_id" ,plannerId);
  
}
</script>
    
   
</div>


</div>


						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
	
	
	<!-- 페이지네이션 -->
<div class="pagination-container text-center">
    <ul class="pagination">
        <c:if test="${currentPage > 1}">
            <li><a href="<c:url value='/search/planner?page=${currentPage - 1}&type=${type}&search=${searchKeyword}'/>">&laquo;</a></li>
        </c:if>
        <c:forEach begin="1" end="${totalPages}" varStatus="page">
            <c:choose>
                <c:when test="${page.index == currentPage}">
                    <li class="active"><a href="#"><c:out value="${page.index}"/></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="<c:url value='/search/planner?page=${page.index}&type=${type}&search=${searchKeyword}'/>"><c:out value="${page.index}"/></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${currentPage < totalPages}">
            <li><a href="<c:url value='/search/planner?page=${currentPage + 1}&type=${type}&search=${searchKeyword}'/>">&raquo;</a></li>
        </c:if>
    </ul>
</div>


<script>
    function redirectToReviewDetail(plannerId) {
        var url = '/weddingBuddy/review/detail?planner_id=' + plannerId;
        location.href = url;
    }
</script>


	
</body>


<jsp:include page="footer.jsp" />
</html>