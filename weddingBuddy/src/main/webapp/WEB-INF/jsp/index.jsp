<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WeddingBuddy - Consulting HTML Template</title>

<style>
body {

   margin-top: 20px;
   background: #FAFAFA;
}

develop /*==================================================
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
   height: 100px;
   width: 100px;
   border-radius: 50%;
}
</style>
</head>

<body>
   <div class="container-xxl bg-white p-0">
      <%@ include file="navbar.jsp"%>
      <div class="container-xxl bg-primary hero-header">
         <div class="container">
            <div class="row g-5 align-items-center">
               <div class="col-lg-6 text-center text-lg-start">
                  <h1 class="text-white mb-4 animated zoomIn"
                     style="margin-left: 50px; font-size: 3em">

                     "고객들의 &nbsp솔직한 &nbsp의견을&nbsp통해 <br> 플래너들의 강점을 파악하고<br>
                     최고의 선택을 해보세요"
                  </h1>
                  <p class="text-white pb-3 animated zoomIn"
                     style="margin-left: 50px">
                     &nbsp&nbspIdentify the strengths and characteristics of planners
                     <br>&nbsp&nbsp and make the best choice with honest feedback
                     from your customers
                  </p>
                  <a href=""
                     class="btn btn-outline-light rounded-pill border-2 py-3 px-5 animated slideInRight"
                     style="margin-left: 50px">Learn More</a>
               </div>
               <div class="col-lg-6 text-center text-lg-start">
                  <img class="img-fluid animated zoomIn"
                     src="<c:url value = "/images/logo.png"/>" alt=""
                     style="margin-right: 100px">
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- Navbar & Hero End -->

   <!-- Testimonial Start -->
   <div class="container-xxl py-6">
      <div class="container">
         <div class="mx-auto text-center wow fadeInUp" data-wow-delay="0.1s"
            style="max-width: 600px;">
            <div
               class="d-inline-block border rounded-pill text-primary px-4 mb-3">Testimonial</div>
            <h2 class="mb-5">What Our Planners Say!</h2>
         </div>
         <!-- 전체 후기 작성 -->

         <div class="owl-carousel testimonial-carousel wow fadeInUp"
            data-wow-delay="0.1s">
            <c:forEach items="${PlannerAll}" var="planner">
               <div class="testimonial-item rounded p-4">
                  <i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
                  <p>${planner.intro }</p>
                  <div class="d-flex align-items-center">
                     <img class="img-fluid flex-shrink-0 rounded-circle"
                        src="img/testimonial-1.jpg">
                     <div class="ps-3">
                        <h6 class="mb-1">${planner.name }</h6>
                        <small>${planner.agency_name }</small>
                     </div>
                  </div>
               </div>
            </c:forEach>
         </div>
      </div>
   </div>
   <!-- Testimonial End -->

   <!-- 기존에 있던거 -->

   <div class="container-xxl py-6">
      <div class="container">
         <div class="mx-auto text-center wow fadeInUp" data-wow-delay="0.1s">
            <div
               class="d-inline-block border rounded-pill text-primary px-4 mb-3">Testimonial</div>
            <h2 class="mb-5">Best Planner Top 3</h2>
         </div>
         <div class="row justify-content-center">
            <!-- 중앙 정렬을 위해 justify-content-center 클래스 추가 -->
            <c:forEach items="${plannerTop3}" var="planner">
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
                                 이름:<a
                                    href="<c:url value="/search/planner/detail" />?planner_id=${ planner._id }"
                                    class="profile-link">${planner.name }</a>
                              </h5>
                              <p>소속:${planner.agency_name }</p>
                              <p class="text-muted">소개: ${planner.intro }</p>
                           </div>
                           <div class="col-md-3 col-sm-3">
                              <button class="btn btn-primary pull-right"
                                 onclick="redirectToReviewDetail(${planner._id})">
                                 고객후기: ${planner.cnt}</button>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </c:forEach>
         </div>
      </div>
   </div>
   <script>
      
    function redirectToReviewDetail(plannerId) {
        var url = '/weddingBuddy/review/detail?planner_id=' + plannerId;
        location.href = url;
    }
   </script>

   <!-- Client Start -->
   <div class="container-xxl bg-primary my-6 py-5 wow fadeInUp"
      data-wow-delay="0.1s">
      <div class="container">
         <div class="owl-carousel client-carousel">
            <a href="#"><img class="img-fluid" src="img/logo-1.png" alt=""></a>
            <a href="#"><img class="img-fluid" src="img/logo-2.png" alt=""></a>
            <a href="#"><img class="img-fluid" src="img/logo-3.png" alt=""></a>
            <a href="#"><img class="img-fluid" src="img/logo-4.png" alt=""></a>
            <a href="#"><img class="img-fluid" src="img/logo-5.png" alt=""></a>
            <a href="#"><img class="img-fluid" src="img/logo-6.png" alt=""></a>
            <a href="#"><img class="img-fluid" src="img/logo-7.png" alt=""></a>
            <a href="#"><img class="img-fluid" src="img/logo-8.png" alt=""></a>
         </div>
      </div>
   </div>
   <!-- Client End -->
   
   <!-- Features Start -->
   <div class="container-xxl py-6">
      <div class="container">
         <div class="row g-5">
            <div class="col-lg-5 wow fadeInUp" data-wow-delay="0.1s">
               <div
                  class="d-inline-block border rounded-pill text-primary px-4 mb-3">Features</div>
               <h2 class="mb-4">웨딩플래너 비대면 상담 서비스</h2>
               <p>무거운 브로셔 없이, 직접 찾아갈 필요 없이 웨딩 플래너와의 비대면 상담을 체험해보세요! 이전 상담 기록과
                  내역을 통해 만족스러운 결혼을 준비할 수 있습니다.</p>
               <br>
               <br>
               <h2 class="mb-4">내가 직접 고르고 평가하는 웨딩플래너</h2>
               <p>검색과 리뷰에 익숙한 MZ 신혼부부들에게 넓은 선택의 폭을 제공하는 웨딩 버디를 사용해보세요! 업체에서
                  선정해주는 플래너가 아니라 직접 플래너를 고를 수 있습니다.</p>
               <a class="btn btn-primary rounded-pill py-3 px-5 mt-2" href="">Read
                  More</a>
            </div>
            <div class="col-lg-7">
               <div class="row g-5">
                  <div class="col-sm-6 wow fadeIn" data-wow-delay="0.1s">
                     <div class="d-flex align-items-center mb-3">
                        <div
                           class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
                           <i class="fa fa-cubes text-white"></i>
                        </div>
                        <h6 class="mb-0">분할화면 실시간 상담</h6>
                     </div>
                     <span>상담을 진행하는 동시에 상품을 둘러볼 수 있습니다.</span>
                  </div>
                  <div class="col-sm-6 wow fadeIn" data-wow-delay="0.2s">
                     <div class="d-flex align-items-center mb-3">
                        <div
                           class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
                           <i class="fa fa-percent text-white"></i>
                        </div>
                        <h6 class="mb-0">플래너 성향 비교</h6>
                     </div>
                     <span>후기를 통해 플래너와의 성향을 맞춰본 후에 플래너를 고를 수 있습니다.</span>
                  </div>
                  <div class="col-sm-6 wow fadeIn" data-wow-delay="0.3s">
                     <div class="d-flex align-items-center mb-3">
                        <div
                           class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
                           <i class="fa fa-award text-white"></i>
                        </div>
                        <h6 class="mb-0">고객 만족도 최상</h6>
                     </div>
                     <span>힘든 결혼 준비 비대면 상담 서비스가 짐을 덜어드립니다.</span>
                  </div>
                  <div class="col-sm-6 wow fadeIn" data-wow-delay="0.4s">
                     <div class="d-flex align-items-center mb-3">
                        <div
                           class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
                           <i class="fa fa-smile-beam text-white"></i>
                        </div>
                        <h6 class="mb-0">제휴 업체 최다</h6>
                     </div>
                     <span>스드메, 웨딩홀 등 국내 최다 제휴 업체 보유 중인 웨딩 업체와 함께하세요</span>
                  </div>
                  <div class="col-sm-6 wow fadeIn" data-wow-delay="0.5s">
                     <div class="d-flex align-items-center mb-3">
                        <div
                           class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
                           <i class="fa fa-user-tie text-white"></i>
                        </div>
                        <h6 class="mb-0">전문적인 플래너</h6>
                     </div>
                     <span>다년간의 경력으로 쌓인 노하우를 비교해보세요!</span>
                  </div>
                  <div class="col-sm-6 wow fadeIn" data-wow-delay="0.6s">
                     <div class="d-flex align-items-center mb-3">
                        <div
                           class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
                           <i class="fa fa-headset text-white"></i>
                        </div>
                        <h6 class="mb-0">24/7 상담 가능</h6>
                     </div>
                     <span>고객님을 위한 상담은 항상 열려있습니다</span>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- Features End -->


   <!-- Team Start -->
   <div class="container-xxl py-6">
      <div class="container">
         <div class="mx-auto text-center wow fadeInUp" data-wow-delay="0.1s"
            style="max-width: 600px;">
            <div
               class="d-inline-block border rounded-pill text-primary px-4 mb-3">Our
               Team</div>
            <h2 class="mb-5">Meet Our Team Members</h2>
         </div>
         <div class="row g-4">
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
               <div class="team-item">
                  <h5>정유경</h5>
                  <p class="mb-4">회원 및 채팅관리 시스템</p>
                  <img class="img-fluid rounded-circle w-100 mb-4"
                     src="img/team-1.jpg" alt="">
                  <div class="d-flex justify-content-center">
                     <a class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-facebook-f"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-twitter"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-linkedin-in"></i></a>
                  </div>
               </div>
            </div>
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
               <div class="team-item">
                  <h5>김준환</h5>
                  <p class="mb-4">플래너 상세보기 & 채팅예약 시스템</p>
                  <img class="img-fluid rounded-circle w-100 mb-4"
                     src="img/team-2.jpg" alt="">
                  <div class="d-flex justify-content-center">
                     <a class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-facebook-f"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-twitter"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-linkedin-in"></i></a>
                  </div>
               </div>
            </div>
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.5s">
               <div class="team-item">
                  <h5>이정은</h5>
                  <p class="mb-4">후기 작성 & 스/드/메 시스템</p>
                  <img class="img-fluid rounded-circle w-100 mb-4"
                     src="img/team-3.jpg" alt="">
                  <div class="d-flex justify-content-center">
                     <a class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-facebook-f"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-twitter"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-linkedin-in"></i></a>
                  </div>
               </div>
            </div>
            <div class="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay="0.7s">
               <div class="team-item">
                  <h5>이경원</h5>
                  <p class="mb-4">좋아요 & 검색 시스템</p>
                  <img class="img-fluid rounded-circle w-100 mb-4"
                     src="img/team-4.jpg" alt="">
                  <div class="d-flex justify-content-center">
                     <a class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-facebook-f"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-twitter"></i></a> <a
                        class="btn btn-square text-primary bg-white m-1" href=""><i
                        class="fab fa-linkedin-in"></i></a>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- Team End -->


   <%@ include file="footer.jsp"%>

</body>

</html>