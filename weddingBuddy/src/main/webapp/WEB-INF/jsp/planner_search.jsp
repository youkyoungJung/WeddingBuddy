<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>WeddingBuddy - Consulting HTML Template</title>

<style>
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

@font-face {
	font-family: 'Cafe24Simplehae';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Simplehae.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

body {
	font-family: Cafe24Simplehae;
}
</style>
</head>

<body>
	<div class="container-xxl bg-white p-0">
		<%@ include file="navbar.jsp"%>
		<!-- 상황에 맞게 적어줘야함 -->
		<div class="container-xxl bg-primary page-header">
			<div class="container text-center">
				<h1 class="text-white animated zoomIn mb-3">플래너 찾기</h1>
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb justify-content-center">
						<li class="breadcrumb-item"><a class="text-white" href="#">Home</a></li>
						<li class="breadcrumb-item"><a class="text-white" href="#">스튜디오찾기</a></li>
						<li class="breadcrumb-item text-white active" aria-current="page">Contact</li>
					</ol>
				</nav>
			</div>
		</div>
		<!-- 끝 -->
	</div>
	<!-- Navbar & Hero End -->
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
										이름:<a href="<c:url value="/search/planner/detail" />"
											class="profile-link">${planner.name }</a>
									</h5>
									<p>소속:${planner.agency_name }</p>
									<p class="text-muted">소개: ${planner.intro }</p>
								</div>
								<div class="col-md-3 col-sm-3">
									<button class="btn btn-primary pull-right"
										onClick=location.href="<c:url value="#"/>" >고객후기:
										${planner.cnt }</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>





		<!-- About Start -->
		<div class="container-xxl py-6">
			<div class="container">
				<div class="row g-5 align-items-center">
					<div class="col-lg-6 wow zoomIn" data-wow-delay="0.1s">
						<img class="img-fluid" src="img/about.png">
					</div>
					<div class="col-lg-6 wow fadeInUp" data-wow-delay="0.1s">
						<div
							class="d-inline-block border rounded-pill text-primary px-4 mb-3">About
							Us</div>
						<h2 class="mb-4">Award Wining Consultancy Agency For Your
							Business</h2>
						<p class="mb-4">Tempor erat elitr rebum at clita. Diam dolor
							diam ipsum et tempor sit. Aliqu diam amet diam et eos labore.
							Clita erat ipsum et lorem et sit, sed stet no labore lorem sit.
							Sanctus clita duo justo et tempor eirmod</p>
						<div class="row g-3 mb-4">
							<div class="col-12 d-flex">
								<div
									class="flex-shrink-0 btn-lg-square rounded-circle bg-primary">
									<i class="fa fa-user-tie text-white"></i>
								</div>
								<div class="ms-4">
									<h6>Business Planning</h6>
									<span>Tempor erat elitr rebum at clita. Diam dolor ipsum
										amet eos erat ipsum lorem et sit sed stet lorem sit clita duo</span>
								</div>
							</div>
							<div class="col-12 d-flex">
								<div
									class="flex-shrink-0 btn-lg-square rounded-circle bg-primary">
									<i class="fa fa-chart-line text-white"></i>
								</div>
								<div class="ms-4">
									<h6>Financial Analaysis</h6>
									<span>Tempor erat elitr rebum at clita. Diam dolor ipsum
										amet eos erat ipsum lorem et sit sed stet lorem sit clita duo</span>
								</div>
							</div>
						</div>
						<a class="btn btn-primary rounded-pill py-3 px-5 mt-2" href="">Read
							More</a>
					</div>
				</div>
			</div>
		</div>
		<!-- About End -->


		<!-- Newsletter Start -->
		<div class="container-xxl bg-primary my-6 wow fadeInUp"
			data-wow-delay="0.1s">
			<div class="container px-lg-5">
				<div class="row align-items-center" style="height: 250px;">
					<div class="col-12 col-md-6">
						<h3 class="text-white">Ready to get started</h3>
						<small class="text-white">Diam elitr est dolore at sanctus
							nonumy.</small>
						<div class="position-relative w-100 mt-3">
							<input class="form-control border-0 rounded-pill w-100 ps-4 pe-5"
								type="text" placeholder="Enter Your Email" style="height: 48px;">
							<button type="button"
								class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2">
								<i class="fa fa-paper-plane text-primary fs-4"></i>
							</button>
						</div>
					</div>
					<div class="col-md-6 text-center mb-n5 d-none d-md-block">
						<img class="img-fluid mt-5" style="max-height: 250px;"
							src="img/newsletter.png">
					</div>
				</div>
			</div>
		</div>
		<!-- Newsletter End -->


		<!-- Service Start -->
		<div class="container-xxl py-6">
			<div class="container">
				<div class="mx-auto text-center wow fadeInUp" data-wow-delay="0.1s"
					style="max-width: 600px;">
					<div
						class="d-inline-block border rounded-pill text-primary px-4 mb-3">Our
						Services</div>
					<h2 class="mb-5">We Provide Solutions On Your Business</h2>
				</div>
				<div class="row g-4">
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
						<div class="service-item rounded h-100">
							<div class="d-flex justify-content-between">
								<div class="service-icon">
									<i class="fa fa-user-tie fa-2x"></i>
								</div>
								<a class="service-btn" href=""> <i class="fa fa-link fa-2x"></i>
								</a>
							</div>
							<div class="p-5">
								<h5 class="mb-3">Business Research</h5>
								<span>Erat ipsum justo amet duo et elitr dolor, est duo
									duo eos lorem sed diam stet diam sed stet lorem.</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
						<div class="service-item rounded h-100">
							<div class="d-flex justify-content-between">
								<div class="service-icon">
									<i class="fa fa-chart-pie fa-2x"></i>
								</div>
								<a class="service-btn" href=""> <i class="fa fa-link fa-2x"></i>
								</a>
							</div>
							<div class="p-5">
								<h5 class="mb-3">Stretagic Planning</h5>
								<span>Erat ipsum justo amet duo et elitr dolor, est duo
									duo eos lorem sed diam stet diam sed stet lorem.</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
						<div class="service-item rounded h-100">
							<div class="d-flex justify-content-between">
								<div class="service-icon">
									<i class="fa fa-chart-line fa-2x"></i>
								</div>
								<a class="service-btn" href=""> <i class="fa fa-link fa-2x"></i>
								</a>
							</div>
							<div class="p-5">
								<h5 class="mb-3">Market Analysis</h5>
								<span>Erat ipsum justo amet duo et elitr dolor, est duo
									duo eos lorem sed diam stet diam sed stet lorem.</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.1s">
						<div class="service-item rounded h-100">
							<div class="d-flex justify-content-between">
								<div class="service-icon">
									<i class="fa fa-chart-area fa-2x"></i>
								</div>
								<a class="service-btn" href=""> <i class="fa fa-link fa-2x"></i>
								</a>
							</div>
							<div class="p-5">
								<h5 class="mb-3">Financial Analaysis</h5>
								<span>Erat ipsum justo amet duo et elitr dolor, est duo
									duo eos lorem sed diam stet diam sed stet lorem.</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.3s">
						<div class="service-item rounded h-100">
							<div class="d-flex justify-content-between">
								<div class="service-icon">
									<i class="fa fa-balance-scale fa-2x"></i>
								</div>
								<a class="service-btn" href=""> <i class="fa fa-link fa-2x"></i>
								</a>
							</div>
							<div class="p-5">
								<h5 class="mb-3">legal Advisory</h5>
								<span>Erat ipsum justo amet duo et elitr dolor, est duo
									duo eos lorem sed diam stet diam sed stet lorem.</span>
							</div>
						</div>
					</div>
					<div class="col-lg-4 col-md-6 wow fadeInUp" data-wow-delay="0.6s">
						<div class="service-item rounded h-100">
							<div class="d-flex justify-content-between">
								<div class="service-icon">
									<i class="fa fa-house-damage fa-2x"></i>
								</div>
								<a class="service-btn" href=""> <i class="fa fa-link fa-2x"></i>
								</a>
							</div>
							<div class="p-5">
								<h5 class="mb-3">Tax & Insurance</h5>
								<span>Erat ipsum justo amet duo et elitr dolor, est duo
									duo eos lorem sed diam stet diam sed stet lorem.</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Service End -->


		<!-- Features Start -->
		<div class="container-xxl py-6">
			<div class="container">
				<div class="row g-5">
					<div class="col-lg-5 wow fadeInUp" data-wow-delay="0.1s">
						<div
							class="d-inline-block border rounded-pill text-primary px-4 mb-3">Features</div>
						<h2 class="mb-4">Why People Choose Us? We Are Trusted & Award
							Wining Agency</h2>
						<p>Clita nonumy sanctus nonumy et clita tempor, et sea amet ut
							et sadipscing rebum amet takimata amet, sed accusam eos eos
							dolores dolore et. Et ea ea dolor rebum invidunt clita eos. Sea
							accusam stet stet ipsum, sit ipsum et ipsum kasd</p>
						<p>Et ea ea dolor rebum invidunt clita eos. Sea accusam stet
							stet ipsum, sit ipsum et ipsum kasd</p>
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
									<h6 class="mb-0">Best In Industry</h6>
								</div>
								<span>Magna sea eos sit dolor, ipsum amet ipsum lorem
									diam eos diam dolor</span>
							</div>
							<div class="col-sm-6 wow fadeIn" data-wow-delay="0.2s">
								<div class="d-flex align-items-center mb-3">
									<div
										class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
										<i class="fa fa-percent text-white"></i>
									</div>
									<h6 class="mb-0">99% Success Rate</h6>
								</div>
								<span>Magna sea eos sit dolor, ipsum amet ipsum lorem
									diam eos diam dolor</span>
							</div>
							<div class="col-sm-6 wow fadeIn" data-wow-delay="0.3s">
								<div class="d-flex align-items-center mb-3">
									<div
										class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
										<i class="fa fa-award text-white"></i>
									</div>
									<h6 class="mb-0">Award Winning</h6>
								</div>
								<span>Magna sea eos sit dolor, ipsum amet ipsum lorem
									diam eos diam dolor</span>
							</div>
							<div class="col-sm-6 wow fadeIn" data-wow-delay="0.4s">
								<div class="d-flex align-items-center mb-3">
									<div
										class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
										<i class="fa fa-smile-beam text-white"></i>
									</div>
									<h6 class="mb-0">100% Happy Client</h6>
								</div>
								<span>Magna sea eos sit dolor, ipsum amet ipsum lorem
									diam eos diam dolor</span>
							</div>
							<div class="col-sm-6 wow fadeIn" data-wow-delay="0.5s">
								<div class="d-flex align-items-center mb-3">
									<div
										class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
										<i class="fa fa-user-tie text-white"></i>
									</div>
									<h6 class="mb-0">Professional Advisors</h6>
								</div>
								<span>Magna sea eos sit dolor, ipsum amet ipsum lorem
									diam eos diam dolor</span>
							</div>
							<div class="col-sm-6 wow fadeIn" data-wow-delay="0.6s">
								<div class="d-flex align-items-center mb-3">
									<div
										class="flex-shrink-0 btn-square bg-primary rounded-circle me-3">
										<i class="fa fa-headset text-white"></i>
									</div>
									<h6 class="mb-0">24/7 Customer Support</h6>
								</div>
								<span>Magna sea eos sit dolor, ipsum amet ipsum lorem
									diam eos diam dolor</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Features End -->


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


		<!-- Testimonial Start -->
		<div class="container-xxl py-6">
			<div class="container">
				<div class="mx-auto text-center wow fadeInUp" data-wow-delay="0.1s"
					style="max-width: 600px;">
					<div
						class="d-inline-block border rounded-pill text-primary px-4 mb-3">Testimonial</div>
					<h2 class="mb-5">What Our Clients Say!</h2>
				</div>
				<div class="owl-carousel testimonial-carousel wow fadeInUp"
					data-wow-delay="0.1s">
					<div class="testimonial-item rounded p-4">
						<i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
						<p>Dolor et eos labore, stet justo sed est sed. Diam sed sed
							dolor stet amet eirmod eos labore diam</p>
						<div class="d-flex align-items-center">
							<img class="img-fluid flex-shrink-0 rounded-circle"
								src="img/testimonial-1.jpg">
							<div class="ps-3">
								<h6 class="mb-1">Client Name</h6>
								<small>Profession</small>
							</div>
						</div>
					</div>
					<div class="testimonial-item rounded p-4">
						<i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
						<p>Dolor et eos labore, stet justo sed est sed. Diam sed sed
							dolor stet amet eirmod eos labore diam</p>
						<div class="d-flex align-items-center">
							<img class="img-fluid flex-shrink-0 rounded-circle"
								src="img/testimonial-2.jpg">
							<div class="ps-3">
								<h6 class="mb-1">Client Name</h6>
								<small>Profession</small>
							</div>
						</div>
					</div>
					<div class="testimonial-item rounded p-4">
						<i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
						<p>Dolor et eos labore, stet justo sed est sed. Diam sed sed
							dolor stet amet eirmod eos labore diam</p>
						<div class="d-flex align-items-center">
							<img class="img-fluid flex-shrink-0 rounded-circle"
								src="img/testimonial-3.jpg">
							<div class="ps-3">
								<h6 class="mb-1">Client Name</h6>
								<small>Profession</small>
							</div>
						</div>
					</div>
					<div class="testimonial-item rounded p-4">
						<i class="fa fa-quote-left fa-2x text-primary mb-3"></i>
						<p>Dolor et eos labore, stet justo sed est sed. Diam sed sed
							dolor stet amet eirmod eos labore diam</p>
						<div class="d-flex align-items-center">
							<img class="img-fluid flex-shrink-0 rounded-circle"
								src="img/testimonial-4.jpg">
							<div class="ps-3">
								<h6 class="mb-1">Client Name</h6>
								<small>Profession</small>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Testimonial End -->


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
							<h5>Full Name</h5>
							<p class="mb-4">Designation</p>
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
							<h5>Full Name</h5>
							<p class="mb-4">Designation</p>
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
							<h5>Full Name</h5>
							<p class="mb-4">Designation</p>
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
							<h5>Full Name</h5>
							<p class="mb-4">Designation</p>
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