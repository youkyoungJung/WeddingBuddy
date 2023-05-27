<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        .plannerlike-item {
            cursor: pointer;
        }

        .plannerlike-item:hover {
            background-color: #F0F0F0;
            color: black;
        }
    </style>
    <script>
        function goToPlannerDetail(planner_id) {
            var contextPath = "${pageContext.request.contextPath}";
            location.href = contextPath + '/search/planner/detail?planner_id=' + planner_id;
        }
    </script>
</head>
<body>
    <form method="post" action="<c:url value='/updateFavorite' />" accept-charset="utf-8">
        <input type="hidden" name="plannerId" value="${plannerId}">
    </form>

    <div class="card" style="width: 20rem;">
        <div class="card-body">
            <c:forEach items="${returnPlanner}" var="planner">
                <div class="plannerlike-item" onclick="goToPlannerDetail(${planner.planner_id})">
                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="card-img-top" alt="jisoo">
                    <p>이름: ${planner.name}</p>
                    <p>이메일: ${planner.email}</p>
                    <p>연락처: ${planner.phone}</p>
                    <a href="<c:url value='/search/planner/detail'/>?planner_id=${planner.planner_id}" class="btn btn-primary"></a>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
