<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
</head>
<body>
	<!-- Footer Start -->
	<div class="container-fluid bg-dark text-light footer pt-5 wow fadeIn"
		data-wow-delay="0.1s" style="margin-top: 6rem;">
		<div class="container py-5">
			<div class="row g-5">
				<div class="col-md-6 col-lg-3">
					<h5 class="text-white mb-4">Get In Touch</h5>
					<p>
						<i class="fa fa-map-marker-alt me-3"></i>123 Street, New York, USA
					</p>
					<p>
						<i class="fa fa-phone-alt me-3"></i>+012 345 67890
					</p>
					<p>
						<i class="fa fa-envelope me-3"></i>info@example.com
					</p>
					<div class="d-flex pt-2">
						<a class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-twitter"></i></a> <a
							class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-facebook-f"></i></a> <a
							class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-youtube"></i></a> <a
							class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-instagram"></i></a> <a
							class="btn btn-outline-light btn-social" href=""><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
				<div class="col-md-6 col-lg-3">
					<h5 class="text-white mb-4">Quick Link</h5>
					<a class="btn btn-link" href="">About Us</a> <a
						class="btn btn-link" href="">Contact Us</a> <a
						class="btn btn-link" href="">Privacy Policy</a> <a
						class="btn btn-link" href="">Terms & Condition</a> <a
						class="btn btn-link" href="">Career</a>
				</div>
				<div class="col-md-6 col-lg-3">
					<h5 class="text-white mb-4">Popular Link</h5>
					<a class="btn btn-link" href="">About Us</a> <a
						class="btn btn-link" href="">Contact Us</a> <a
						class="btn btn-link" href="">Privacy Policy</a> <a
						class="btn btn-link" href="">Terms & Condition</a> <a
						class="btn btn-link" href="">Career</a>
				</div>
				<div class="col-md-6 col-lg-3">
					<h5 class="text-white mb-4">Newsletter</h5>
					<p>Lorem ipsum dolor sit amet elit. Phasellus nec pretium mi.
						Curabitur facilisis ornare velit non vulpu</p>
					<div class="position-relative w-100 mt-3">
						<input class="form-control border-0 rounded-pill w-100 ps-4 pe-5"
							type="text" placeholder="Your Email" style="height: 48px;">
						<button type="button"
							class="btn shadow-none position-absolute top-0 end-0 mt-1 me-2">
							<i class="fa fa-paper-plane text-primary fs-4"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="copyright">
				<div class="row">
					<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
						&copy; <a class="border-bottom" href="#">Your Site Name</a>, All
						Right Reserved.

						<!--/*** This template is free as long as you keep the footer authorâs credit link/attribution link/backlink. If you'd like to use the template without the footer authorâs credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
						Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML
							Codex</a>
					</div>
					<div class="col-md-6 text-center text-md-end">
						<div class="footer-menu">
							<a href="">Home</a> <a href="">Cookies</a> <a href="">Help</a> <a
								href="">FQAs</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->


	<!-- Back to Top -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
		class="bi bi-arrow-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="<c:url value = "/lib/wow/wow.min.js" />"></script>
	<script src="<c:url value = "/lib/easing/easing.min.js" />"></script>
	<script src="<c url value = "/lib/waypoints/waypoints.min.js" />"></script>
	<script src="<c:url value = "/lib/owlcarousel/owl.carousel.min.js"/>"></script>

	<!-- Template Javascript -->
	<script src="<c:url value = "/js/main.js" />"></script>
</body>
</html>