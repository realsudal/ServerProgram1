<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		const f = $('#f');
		const login_btn = $('#login_btn');
		const id = $('#id');
		const name = $('#name');
		
		
		login_btn.click(function(){
			if(id.val()=='' || name.val()==''){
				alert('아이디와 이름은 필수 입니다.');
				return false;
			}
			f.attr('action','/ServerProgram1/login.do')
			f.submit();
		})
		
		
	})
	
	
</script>
</head>
<body>
<div style="text-align: center;">
	<h1>회원 관리 프로그램</h1>
	<br>
	<form id="f">
	<input type="text" value="scott" name="id" id="id"><br>
	<input type="text" value="스캇" name="name" id="name"><br><br>
	<input type="button" value="로그인" id="login_btn"> 	<a href="ServerProgram1/join.do">회원가입</a>
	</form>
</div>
</body>
</html>