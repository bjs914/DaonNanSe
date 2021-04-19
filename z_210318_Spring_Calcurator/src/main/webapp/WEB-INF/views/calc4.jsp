<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	<!-- jstl 태그를 사용하기 위해 임포트 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>계산기(calc4)</title>
	<style>
	</style>
</head>
<body>
	<h2> 계산기 (calc4)</h2>
		<div>
		<form action="calc4" method="post">
			<p>
			<label>값1:<br>
				<input type="text" name="a" placeholder="숫자를 입력하세요" value="${calc4.a}">
			</label>
			</p>
			
			<p>
			<select name="c">
				<c:forEach var="cName" items="${calc4.cList}">	
					<c:choose>
						<c:when test="${cName eq calc4.c}">
							<option value="${cName}" selected>${cName }</option>
						</c:when>
					<c:otherwise>
							<option value="${cName}">${cName}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			</p>
			<p>
			<label>값2:<br>
				<input type="text" name="b" placeholder="숫자를 입력하세요" value="${calc4.b }">
			</label>
			
			<p>
			<label>값1(${calc4.a })(${calc4.c})값2(${calc4.b })=<span class="result">결과(${calc4.sum})</span></label>
			</p>
			
			<input type="submit" value="계산하기">
		</form>
		</div>
</body>
</html>