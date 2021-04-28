<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>상품 ID 오류</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">이 아디디를 가진 상품은 없습니다. : ${invalidProductId}</h1>				
			</div>
		</div>
	</section>
	
	<section>
		<div class="container">
			<p>${uri}</p>
			<p>${exception}</p>
		</div>
		<div class="container">
			<p>
				<a href="<spring:url value="/market/products"/>"
					class="btn btn-primary">
					<span class="glyphicon-hand-left glyphicon"></span>
					제품목록으로 돌아가기	
				</a>
		</div>
	</section>
</body>
</html>