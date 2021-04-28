<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="product.form.title" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code="product.form.serach"/></h1>
			</div>
		</div>
	</section>
	<section class="container">
		<a href="/210408_shoppingmall"><spring:message code="home.label"/></a>
		<hr>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-md-5">
			<!-- 상세 페이지 내, 사용자가 지정한 제품 사진 출력 -->
				<img src="<c:url value='/img/${product.productId}.png'></c:url>"
					alt="제품 사진" style="width: 100%" />
			</div>
			<div class="col-md-5">
				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>상품ID : </strong> <span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>제조사</strong> : ${product.manufacturer}
				</p>
				<p>
					<strong>상품범주</strong> : ${product.category}
				</p>
				<p>
					<strong>재고 수량 </strong> : ${product.unitsInStock}
				</p>
				<p>
					<strong><a href="/210408_shoppingmall/pdf/${product.productId}.pdf">
							[설명서 내려받기(${product.productId}.pdf)]</a></strong>
				</p>
				<h4>${product.unitPrice}원</h4>		
				<p>
				<a href="<spring:url value='/market/products' />"
						class="btn btn-default"> <span
						class="glyphicon-hand-left glyphicon"></span>뒤로 가기
					</a>
					<a href="#" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"></span>주문하기
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>