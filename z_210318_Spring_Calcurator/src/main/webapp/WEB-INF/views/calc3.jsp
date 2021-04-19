<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>계산기(calc3)</title>
	<script>
	<%--  3번 행 : <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %> : jstl 태그를 사용하기 위해 임포트 --%>
	
	<%-- 
	36번행 
	<c:choose>	
	<c:when test="${calc3.c=='+' }">
		<option value="+" selected>더하기</option>
	</c:when>
	<c:otherwise>
		<option value="+">더하기</option>
	</c:otherwise>
	jstl 태그 사용, choose : c:when을 사용하기 위해 사용해야함(if문처럼 활용하기 때문)
	--%> 
	</script>
</head>
<body>
	<h2>계산기(calc3)</h2>
		<div>
		<form action="calc3" method="post">
			<p>
			<label>값1:<br>
				<input type="text" name="a" placeholder="숫자를 입력하세요" value="${calc3.a}">
			</label>
			</p>
			<p>
			<select name="c">
				<c:choose>	
				<c:when test="${calc3.c=='+' }">
					<option value="+" selected>더하기</option>
				</c:when>
				<c:otherwise>
					<option value="+">더하기</option>
				</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${calc3.c=='-'}">
						<option value="-" selected>빼기</option>
					</c:when>
					<c:otherwise>
						<option value="-">빼기</option>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${calc3.c=='*'}">
						<option value="*" selected>곱하기</option>
					</c:when>
					<c:otherwise>
						<option value="*">곱하기</option>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${calc3.c=='/'}">
						<option value="/" selected>나누기</option>
					</c:when>
					<c:otherwise>
						<option value="/">나누기</option>
					</c:otherwise>
				</c:choose>
			</select>
			</p>
			<p>
			<label>값2:<br>
				<input type="text" name="b" placeholder="숫자를 입력하세요" value="${calc3.b }">
			</label>
			
			<p>
			<label>값1(${calc3.a })(${calc3.c})값2(${calc3.b })=<span class="result">결과(${calc3.sum})</span></label>
			</p>
			
			<input type="submit" value="계산하기">
		</form>
		</div>
</body>
</html>