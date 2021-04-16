<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>고객 목록</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>고객 목록</h1>
				<p>모든 고객 목록</p>
			</div>
		</div>
	</section>
	<section class="container">
		<a href="/210408_shoppingmall">홈으로</a>
		<hr>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${customers}" var="customer">	
			<!-- model에 저장되어있는 customers의 이름으로 값을 불러오는 의미 -->
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<div class="caption">
							<h3>${customer.name}</h3>
							<h3>${customer.address}</h3>
							<h3>${customer.customerId}</h3>
							<p>주문건수 : ${customer.noOfOrdersMade}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>