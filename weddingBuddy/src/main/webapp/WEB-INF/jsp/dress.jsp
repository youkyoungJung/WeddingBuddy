<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>dress.jsp</title>
    <%@ include file="navbar.jsp" %>
    <style>
        .dress-item {
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            cursor: pointer;
            position: relative;
        }
        
        .dress-item:hover {
            background-color: #f0f0f0;
        }
        
        .dress-item h3 {
            margin-top: 0;
        }
        
        .dress-item p {
            margin: 0;
        }
        
        .dress-item .heart-container {
            position: absolute;
            top: 10px;
            right: 10px;
            z-index: 1;
        }
        
        .dress-item .heart-button {
            width: 30px;
            height: 30px;
            background-color: transparent;
            border: none;
            padding: 0;
            margin: 0;
            cursor: pointer;
        }
        
        .dress-item .heart-button img {
            width: 100%;
            height: 100%;
        }
        
        .dress-item .image-container {
            text-align: center;
            margin-bottom: 10px;
        }
        
        .dress-item img {
            max-width: 100%;
            height: auto;
        }
    </style>
    <script>
        function goToDressDetail(dress_shop_id) {
            var contextPath = "${pageContext.request.contextPath}";
            location.href = contextPath + '/dress_detail?dress_shop_id=' + dress_shop_id;
        }
        
        function handleFavoriteClick(event) {
            event.preventDefault(); // 기본 동작 방지
            
            var heartImage = event.currentTarget.querySelector('img');
            var isFavorite = heartImage.getAttribute('src') === '${pageContext.request.contextPath}/images/prev_heart.png';
            
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    if (isFavorite) {
                        heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/next_heart.png');
                    } else {
                        heartImage.setAttribute('src', '${pageContext.request.contextPath}/images/prev_heart.png');
                    }
                }
            };
            // 추가적인 로직이 필요한 경우 여기에 작성합니다.
        }
    </script>
</head>
<body>
    <h2>dress 보기</h2>
    
    <c:forEach var="dress" items="${dressShops}">
        <div class="dress-item" onclick="goToDressDetail(${dress.dress_shop_id})">
            <div class="heart-container">
                <a href="#" class="heart-button" onclick="handleFavoriteClick(event)">
                    <img class="heart-image" src="${pageContext.request.contextPath}/images/prev_heart.png" alt="하트 이미지" style = "width: 30px; height:30px;">
                </a>
            </div>
            <h3>${dress.name}</h3>
            <p>${dress.price_range}만원~</p>
            <!-- dressImageList에서 해당 company_unique_id에 맞는 이미지만 표시 -->
            <c:forEach var="dressImage" items="${dressImagesList}">
                <c:if test="${dressImage.company_unique_id == dress.company_unique_id}">
                    <div class="image-container">
                    <!-- 첫 번째 이미지만 표시하고 나머지 이미지는 숨김 -->
                        <c:choose>
                            <c:when test="${dressImage eq dressImagesList[0]}">
                                <img src="<c:url value='${dressImage.image}' />" alt="Dress Image" />
                            </c:when>
                            <c:otherwise>
                                <img src="<c:url value='${dressImage.image}' />" alt="Dress Image" style="display: none;" />
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
    
    <%@ include file="footer.jsp" %>
</body>
</html>
