<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Page</title>

<!-- 부트스트랩 -->
<link href="css/bootstrap.min.css" rel="stylesheet">


<jsp:include page="navbar.jsp" />
</head>
<body>
	<!-- login form  -->
	<div class="py-4 text-center">
		<h2 id="logo">로그인</h2>
	</div>
	<div class="container"
		style="display: flex; justify-content: center; align-items: center;">
		<div>
			<form name="form" method="POST"
				action="<c:url value='/login' />">
				<div class="row">
					<div class="col-md-12">
						<label for="id" id="menu">아이디</label>
					</div>
					<div class="col-md-12 mb-3">
						<input type="text" class="form-control" name="account_id" value=""
							id="account_id" placeholder="아이디">
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<label for="password" id="menu">비밀번호 <span
							class="text-muted"></span></label>
					</div>
					<div class="col-md-12 mb-3">
						<input type="password" class="form-control" placeholder="비밀번호"
							id="password" value="" name="password" required>
					</div>
				</div>
				<c:if test="${loginFailed}">
					<br>
					<font color="red"><c:out value="${exception.getMessage()}" /></font>
					<br>
				</c:if>

				<hr class="mb-4">
				<div style="text-align: center;">
					<button class="btn btn-primary btn-dark" id="btn" type="submit"
						style="width: 30%">로그인</button>
					&nbsp; &nbsp;

					<button class="btn btn-primary btn-dark" id="buttons" type="button"
						style="width: 35%" onClick="location.href='/join'">회원가입</button>
				</div>
			</form>
		</div>
	</div>

</body>
<jsp:include page="footer.jsp" />
</html>