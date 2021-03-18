<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>계산기(calc2)</title>
	<style>
	</style>
</head>
<body>
	<h2>계산기(calc2)</h2>
		<div>
		<form action="calc2" method="post">
			<p>
			<label>값1:<br>
				<input type="text" name="a" placeholder="숫자를 입력하세요" value="${calc2.a}">
			</label>
			</p>
			<p>
			<select name="c">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
			</p>
			<p>
			<label>값2:<br>
				<input type="text" name="b" placeholder="숫자를 입력하세요" value="${calc2.b }">
			</label>
			
			<p>
			<label>값1(${calc2.a })+값2(${calc2.b })=<span class="result">결과(${calc2.sum})</span></label>
			</p>
			
			<input type="submit" value="계산하기">
		</form>
		</div>
</body>
</html>