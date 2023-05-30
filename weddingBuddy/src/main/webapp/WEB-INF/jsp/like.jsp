<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>

    <style>
    

    
	
      
    	.rectangle14{
    		font-family: 'Cafe24Simplehae';
    		background: #FDE6E6;
    		font-weight:900;
    		color:#808080;
    		justify-content: center;
    		font-size:1.8em;
    		text-align:center;
    		
    		
    		
    	
    	}

        .plannerlike-item {
        	
        	font-family: 'Cafe24Simplehae';
        	font-weight: 600;
        	align-items:center;
        	font-size:1em;
            cursor: pointer;
            
            text-align:center;
           	margin-top:3em;
            border: 10px double #FDE6E6;
            border-radius: 10px;
            
            
            
        }
        .plannerlike-item img {
        	margin-top:20px;
        
        }
        .card-img-top {
        	border-radius:10px;
        
        }
        
  
   

        .plannerlike-item:hover {
            background-color: #F0F0F0;
            color: black;
        }
        
        
        .btnplanner {
        	color:#ffff;
        
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

<!-- navbar 추가해줘야할 것 -->
   <div class="container-xxl bg-white p-0">
      <%@ include file="navbar.jsp"%>
      <div class="container-xxl bg-primary page-header">
         <div class="container text-center">
            <h1 class="text-white animated zoomIn mb-3">찜</h1>
            <nav aria-label="breadcrumb">
               <ol class="breadcrumb justify-content-center">
                  <li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
                  <li class="breadcrumb-item"><a class="text-white" href="#">플래너찾기</a></li>
                  <li class="breadcrumb-item text-white active" aria-current="page">Contact</li>
               </ol>
            </nav>
         </div>
      </div>
   </div>
   <!-- 추가해 줘야할 것 끝 -->


    <form method="post" action="<c:url value='/updateFavorite' />" accept-charset="utf-8">
        <input type="hidden" name="plannerId" value="${plannerId}">
    </form>
   

    <div class="card" style="width: 100%;">
        <div class="card-body" style = "width:50em; margin-left:34em; margin-bottom:3em;">
            <c:forEach items="${returnPlanner}" var="planner">
                <div class="plannerlike-item" onclick="goToPlannerDetail(${planner.planner_id})">
                    <img src="${pageContext.request.contextPath}/images/${planner.planner_id }.png" class="card-img-top" alt="jisoo" p style = "text-align: center; width: 100px;">
                    
                    <p></p>
                    <br>
                    <p>이름: ${planner.name}</p>
                  
                    <p>이메일: ${planner.email}</p>
                   
                   <p>연락처: ${planner.phone}</p>
                    
                    <a href="<c:url value='/search/planner/detail'/>?planner_id=${planner.planner_id}" class="btn btnplanner"></a>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
<jsp:include page="footer.jsp" />
</html>
