<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Searching Planner</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/chat.css">


<style>


body{
    margin-top:20px;
    background:#FAFAFA;    
}
/*==================================================
  Nearby People CSS
  ==================================================*/

  
 .header-avatar{
    pointer-events: none;
    
 } 


.people-nearby .google-maps{
  background: #f8f8f8;
  border-radius: 4px;
  border: 1px solid #f1f2f2;
  padding: 20px;
  margin-bottom: 20px;

}

.people-nearby .google-maps .map{
  height: 300px;
  width: 100%;
  border: none;
}

.people-nearby .nearby-user{
  padding: 20px 0;
  border-top: 1px solid #f1f2f2;
  border-bottom: 1px solid #f1f2f2;
  margin-bottom: 20px;
}

img.profile-photo-lg{
  height: 80px;
  width: 80px;
  border-radius: 50%;
}


#header{
   margin-left:30px;
}
.chat-icon img {
  width: 60px;
  height: 60px;
}


 #tlkio {
        display: none;
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
                              이름:<a href="<c:url value="/search/planner/detail" />?planner_id=${ planner._id }"
                                 class="profile-link">${planner.name }</a>
                           </h5>
                           <p>소속:${planner.agency_name }</p>
                           <p class="text-muted">소개: ${planner.intro }</p>
                        </div>
                        <div class="col-md-3 col-sm-3">
                           <button class="btn btn-primary pull-right"
                              onClick=location.href='<c:url value="#"/>' >고객후기:
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