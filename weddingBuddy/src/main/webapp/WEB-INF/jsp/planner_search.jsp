<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Searching Planner</title>
<style>




.kong-team-item {

   margin-left:5px;
     width:25em;
    height:32em;

    position: relative;
   
    text-align: center;
    transition: .5s;
    z-index: 1;
    

}

.kong-team-item::before,
.kong-team-item::after {
    position: absolute;
    content: "";
    width: 100%;
    height: 40%;
    top: 0;
    left: 0;
    border-radius: 5px;
    background: #FFFFFF;
    box-shadow: 0 0 45px rgba(0, 0, 0, .07);
    transition: .5s;
    z-index: -1;
}

.kong-team-item::after {
    top: auto;
    bottom: 0;
}

.kong-team-item:hover::before,
.kong-team-item:hover::after {
    background: var(--primary);
}

.kong-team-item h5,
.kong-team-item p {
    transition: .5s;
}

.kong-team-item:hover h5,
.kong-team-item:hover p {
    color: #FFFFFF;
=======
}

.kong-team-item::before,
.kong-team-item::after {
    position: absolute;
    content: "";
    width: 100%;
    height: 40%;
    top: 0;
    left: 0;
    border-radius: 5px;
    background: #FFFFFF;
    box-shadow: 0 0 45px rgba(0, 0, 0, .07);
    transition: .5s;
    z-index: -1;
}

.kong-team-item::after {
    top: auto;
    bottom: 0;
}

.kong-team-item:hover::before,
.kong-team-item:hover::after {
    background: var(--primary);
}

.kong-team-item h5,
.kong-team-item p {
    transition: .5s;
}

.kong-team-item:hover h5,
.kong-team-item:hover p {
    color: #FFFFFF;
}

.kong-team-item img {
	
    padding: 10px;
    
    
    
}
.kong-pagination > a, #kongpage: hover {
	color:orange;
}


.kong-container-xxl{display:flex;flex-wrap:inherit;align-items:center;}

.kong-team-item img {
   
    padding: 10px;
    
    
    
}
.kong-pagination > a, #kongpage: hover {
   color:orange;
}


.kong-container-xxl{display:flex;flex-wrap:inherit;align-items:center;}

.box-radio-input input[type="radio"] {
   display: none;
}



.box-radio-input input[type="radio"]+span {
   display: inline-block;
   background: none;
   border: 2px solid pink;
   padding: 0px 10px;
   text-align: center;
   height: 35px;
   line-height: 33px;
   font-weight: 500;
   cursor: pointer;
    margin-bottom:10px;
    border-radius:20%;
}

.box-radio-input input[type="radio"]:checked+span {
   border: 1px solid white;
   background: white;
   color: black;
 
  
}

.kong-profile-photo-lg {
	width:18em;
	height:18em;
	border-radius: 50%;
	

}

.col-md-6{flex:0 0 auto;width:80%}


#custom-search-input {
   padding: 3px;
   border: solid 1px #E4E4E4;
   border-radius: 6px;
   background-color: #fff;
   width: 40%
}
.kong-pagination{display:flex;padding-left:0;list-style:none}

.kong-pagination:hover::before, a{

   color:black;
}

.kong-pagination > .active > a{
   color: pink;


}


#custom-search-input input {
   border: 0;
   box-shadow: none;
}
.kong-4, .gy-4 {

   --bs--gutter-y: 1.5rem;
}

.kong-4, .gx-4 {
   --bs--gutter-y: 1.5rem;
}
.kongrow {
   display:flex;
   flex-wrap: wrap;
   margin-right: calc(var(--bs-gutter-x) / -2);
   margin-left: calc(var(--bs-gutter-x) /-2);
}
*, *::before, *::after {
   box-sizing: border-box;

}
.kong-col-lg-3{flex:0 0 auto;width:25%}

.kong-col-md-6{flex:0 0 auto;width:50%}

.kong-col-md-3{flex:0 0 auto;width:25%}


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

.kongbigframe  {margin-right:auto !important;margin-left:auto !important}

.kong-col-sm-3{flex:0 0 auto;width:25%}

</style>

</head>

<body>
<!-- navbar 추가해줘야할 것 -->
   <div class="container-xxl bg-white p-0">
      <%@ include file="navbar.jsp"%>
      <div class="container-xxl bg-primary page-header">
         <div class="container text-center">
            <h1 class="text-white animated zoomIn mb-3">플래너찾기</h1>
            <nav aria-label="breadcrumb">
               <ol class="breadcrumb justify-content-center">
                  <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                  <li class="breadcrumb-item"><a class="text-white" href="#">내 채팅방</a></li>
                  <li class="breadcrumb-item text-white active" aria-current="page">Contact</li>
               </ol>
            </nav>
         </div>
      </div>
   </div>
   <!-- 추가해 줘야할 것 끝 -->
      <!-- 검색뷰 시작 -->
<section class="search-section">
   <div align="center">
<form method="post" action="<c:url value='/search/planner' />" accept-charset="utf-8">
    <label class="box-radio-input" style = "font-family: 'Cafe24Simplehae'; ">
        <input type="radio" name="type" value="area" <c:if test="${type eq 'area'}">checked="checked"</c:if>>
        <span>지역</span>
    </label>
    <label class="box-radio-input" style = "font-family: 'Cafe24Simplehae';">
        <input type="radio" name="type" value="name" <c:if test="${type eq 'name'}">checked="checked"</c:if>>
        <span>이름</span>
    </label>
    <label class="box-radio-input" style = "font-family: 'Cafe24Simplehae';">
        <input type="radio" name="type" value="group" <c:if test="${type eq 'group'}">checked="checked"</c:if>>
        <span>소속</span>
    </label>




         <div id="custom-search-input" style = "width: 20em;">
            <div class="input-group col-md-12">
               <input type="text" class="form-control input-lg" placeholder="검색어를 입력하세요." name="search"  value = "${searchKeyword }"/>
               <span class="input-group-btn">
                  <button class="searchbutton" type="submit" style="margin-left:2em; margin-top:7px;">

                  	<i class="bi bi-search"></i>

                  </button>
               </span>
            </div>
         </div>
      </form>
   </div>
</section>

<!-- 검색 끝 -->

   

  
       <!-- 중앙 정렬을 위해 justify-content-center 클래스 추가 -->
   <div class="kong-container-xxl py-6" >     
      <c:forEach items="${PlannerAll}" var="planner">
       
            <div class="kong-container" style = "margin-left:3.5em;">
                <div class="kongrow kong-4">
            <div class="kong-col-lg-3 kong-col-md-6 wow fadeInUp" data-wow-delay="0.7s">
                   <div class = "kong-team-item" >
                    <a href="#" class="heart-button" onclick="handleFavoriteClick(event, ${planner._id})" style = "margin-left:15em;">
  <img id="heartImage-${planner._id}" src="${pageContext.request.contextPath}/images/prev_heart.png" alt="이미지 버튼" class="kongimg-fluid" style = "width:70px;  margin-left:3em; ">
  
</a>
                           <img src="${pageContext.request.contextPath}/images/${planner._id }.png"
                              alt="user" class="kong-profile-photo-lg" onclick="goToPlannerDetail(${ planner._id })">
                       
                        <div class="kong-flex justify-content-center"
                                    class="profile-link" style = "font-size: 1.1em; font-weight:500;">
                           <h5>
                                ${planner.name }
                              </h5><br>
                           <p>${planner.agency_name }</p>
                           <p>${planner.intro }</p>
                        </div>
                        <div class="kong-col-md-3 kong-col-sm-3" >
  
                       

    <div style="text-align: center; margin-top: 10px;">
   <!-- 각 항목의 고유 ID를 data-planner-id 속성으로 전달 -->






<script>
function handleFavoriteClick(event,plannerId,isFavorite) {
  event.preventDefault(); // 기본 동작 방지

  var heartImage = event.currentTarget.querySelector('img');
  var isFavorite = heartImage.getAttribute('src') === '${pageContext.request.contextPath}/images/prev_heart.png';

  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
      if (isFavorite) {
        heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/next_heart.png');
      } else {
        heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/prev_heart.png');
      }
    }
  };

  xhttp.open('POST', '${pageContext.request.contextPath}/updateFavorite', true);
  xhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
  xhttp.send('planner_id=' + plannerId + '&isFavorite=' + !isFavorite); // 눌릴 때마다 isFavorite 값을 반전시킴 (!isFavorite)

  console.log("isFavorite", isFavorite);
}




function goToPlannerDetail(planner_id) {
    var contextPath = "${pageContext.request.contextPath}";
    location.href = contextPath + '/search/planner/detail?planner_id=' + planner_id;
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
<div class="pagination-container" style="margin-left: 60em;align-items:center;">
    <ul id = "kongpage" class="kong-pagination" style="font-size:20px; font-weight: 1000;letter-spacing:5px; " >
        <c:if test="${currentPage > 1}">
            <li><a href="<c:url value='/search/planner?page=${currentPage - 1}&type=${type}&search=${searchKeyword}'/>" ><i class="bi bi-chevron-double-left"></i></a></li>
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
            <li><a href="<c:url value='/search/planner?page=${currentPage + 1}&type=${type}&search=${searchKeyword}'/>"><i class="bi bi-chevron-double-right"></i></a></li>
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