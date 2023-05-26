<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dress Detail</title>
    <%@ include file="navbar.jsp" %>
    <style>
        /* 스타일 설정 */
    </style>
</head>
<body>
    <h2>Dress Detail</h2>

    <h3>${dressShop.name}</h3>
    <p>Price: ${dressShop.price_range}만원</p>

    <h4>Images</h4>
    <c:forEach var="imagePath" items="${dressImagesList}">
        <img src="${pageContext.request.contextPath}/${imagePath}" alt="Dress Image" />
    </c:forEach>

    <%@ include file="footer.jsp" %>
</body>
</html>
