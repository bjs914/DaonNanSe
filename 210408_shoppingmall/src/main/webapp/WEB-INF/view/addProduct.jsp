<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
	<section>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?language=ko">한글</a>|<a href="?language=en">English</a>
			<p />
			<a href="<c:url value="/logout" />">로그아웃</a>
		</div>
	</section>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>제품 추가페이지</h1>
				<p>새로운 제품추가를 위한 정보를 입력하세요</p>
			</div>
		</div>
	</section>
	<section class="container">
		<a href="/210408_shoppingmall"><spring:message code="home.label"/></a>
		<hr>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="newProduct"
			class="form-horizontal" enctype="multipart/form-data">	<!-- enctype 이미지추가 관련 -->
			<fieldset>
				<legend><spring:message code="product.form.productInfo.label" /></legend>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2 col-lg-2" for="productId">
						상품 ID </label> -->
					<!-- 외부파일로 추출한 메시지를 spring:message태그를 이용하여 불러오는 방법 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.productId.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2 col-lg-2" for="name">
						상품명</label> -->
						<!-- spring:message 태그 활용 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.prodName.label" />
					</label>	
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2 col-lg-2" for="unitPrice">
						단위 가격</label> -->
						<!-- spring:message 태그 활용 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.unitPrice.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="unitPrice" path="unitPrice" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2 col-lg-2" for="manufacturer">
						제조사</label> -->
						<!-- spring:message 태그 활용 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.manufacturer.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="manufacturer" path="manufacturer" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2 col-lg-2" for="category">
						상품 범주</label> -->
						<!-- spring:message 태그 활용 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.category.label" />
					</label>	
					<div class="col-lg-10">
						<form:input id="category" path="category" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2 col-lg-2" for="unitsInStock">
						재고 수량</label> -->
						<!-- spring:message 태그 활용 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.unitsInStock.label" />
					</label>	
					<div class="col-lg-10">
						<form:input id="unitsInStock" path="unitsInStock" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2 col-lg-2" for="unitsInOrder">
						주문 수량</label> -->
						<!-- spring:message 태그 활용 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.unitsInOrder.label" />
					</label>	
					<div class="col-lg-10">
						<form:input id="unitsInOrder" path="unitsInOrder" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2" for="description"> 상품
						설명</label> -->
						<!-- spring:message 태그 활용 -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.description.label" />
					</label>	
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2" for="discontinued">
						생산 중단됨</label> -->
						<!-- spring:message 태그 활용 -->						
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.discontinued.label" />
					</label>	
					<div class="col-lg-10">
						<form:checkbox id="discontinued" path="discontinued" />
					</div>
				</div>
				<div class="form-group">
					<!-- <label class="control-label col-lg-2" for="condition"> 상품
						상태</label> -->
					<label class="control-label col-lg-2 col-lg-2" for="productId">
						<spring:message code="addProduct.form.condition.label" />
					</label>
					<div class="col-lg-10">
						<!-- checkbok 내용도 spring:message 활용 -->
						<spring:message code="addProduct.form.condition.option1"/>
						<form:radiobutton path="condition" value="New" />
						
						<!-- checkbok 내용도 spring:message 활용 -->
						<spring:message code="addProduct.form.condition.option2"/>
						<form:radiobutton path="condition" value="Old" />
						
						<!-- checkbok 내용도 spring:message 활용 -->
						<spring:message code="addProduct.form.condition.option3"/>
						<form:radiobutton path="condition" value="Refurbished" />
					</div>
				</div>
				<div class="form-group"><!-- 제품 이미지 삽입관련 태그 -->
					<label class="control-label col-lg-2" for="productImage">
						<spring:message code="addProduct.form.productImage.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productImage" path="productImage" type="file" 
							class="form:input-large"/>
					</div>
				</div>
				<div class="form-group"><!-- 제품 메뉴얼 삽입관련 태그 -->
					<label class="control-label col-lg-2" for="productManual">
						<spring:message code="addProduct.form.productManual.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productManual" path="productManual"
							type="file" class="form:input-large" />
					</div>							
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>