<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%-- 
<c:set var="plannerId" value="${param.planner_id}" />
<c:set var="isFavorite" value="${param.isFavorite}" /> --%>

<!-- 여기에서 plannerId와 isFavorite 값을 활용하여 원하는 작업을 수행합니다. -->

<!DOCTYPE html>
<html>
<head>
    <title>Like</title>
</head>
<body>
    <h1>Like Page</h1>
    
    <form action="/addLikedPlanner" method="POST">
        <input type="hidden" name="plannerId" value="${plannerId}">
        <input type="submit" value="Add to Liked List">
    </form>
    
    <p>Planner ID: ${plannerId}</p>
    <p>Is Favorite: ${isFavorite}</p>
    
    <a href="/likedPlanners">View Liked Planners</a>
</body>
</html>