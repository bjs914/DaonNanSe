<%@ page language="java" contentType="text/html;
charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl 태그를 사용하기 위해 선언 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,
initial-scale=1">
<title>Welcome</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<h1>${greeting}</h1>
			<p>${tagline}</p>
		</div>
	</section>
	<section class="container">
	<ul>
		<li><a href="market/product.xml?id=P1235">상품 XML 방식 요청</a>
		<li><a href="market/product.json?id=P1235">상품 Json 방식 요청</a>
		<li><a href="market/product?id=P10000">없는 상품 에러표시 보기</a>
		<li><a href="market/products/specialOffer?promo=OFF3R">판촉코드-성공(목록표시)</a></li>
		<li><a href="market/products/specialOffer?promo=OFFER">판촉코드-오류</a></li>
		<li><a href="market/customers/">고객목록</a></li>
		<li><a href="market/customers/add">고객 추가</a></li>
		<li><a href="market/products/add">상품 추가</a></li>
		<li><span><a href="market/products/">상품목록</a></span> 
		( <span>
			<a href="market/products/laptop">랩탑</a> &nbsp;</span>,
			<span><a href="market/products/tablet">태블릿</a></span>,
			<span><a href="market/products/smartphone">스마트폰</a></span> )
		</li>
		<li><a href="market/update/stock/">재고 확인</a></li>
	</ul>
	</section>
</body>
</html>