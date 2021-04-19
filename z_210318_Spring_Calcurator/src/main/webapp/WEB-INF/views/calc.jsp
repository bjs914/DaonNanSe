<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>덧셈 계산기</title>
	<style>
	</style>
</head>
<body>
	<h2>덧셈 계산기</h2>
		<div>
		<form action="calc" method="post">
			<p>
			<label>값1:<br>
				<input type="text" name="calca" placeholder="숫자를 입력하세요" value="${calca}">
			</label>
			</p>
			
			<p>
			<label>값2:<br>
				<input type="text" name="calcb" placeholder="숫자를 입력하세요" value="${calcb }">
			</label>
			
			<p>
			<label>값1(${calca })+값2(${calcb })=<span class="result">결과(${calcsum})</span></label>
			</p>
			
			<input type="submit" value="계산하기">
		</form>
		</div>
</body>
</html>