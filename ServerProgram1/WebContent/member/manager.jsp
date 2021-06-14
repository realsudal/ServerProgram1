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
		const updateMember_btn=$('#updateMember_btn');
		const deleteMember_btn=$('#deleteMember_btn');
		const id=$('#id');
		const name=$('#name');
		const f=$('#f');
		
		updateMember_btn.click(function(){
			if ( id.val() == '${loginDTO.id}' && name.val() == '${loginDTO.name}') {
				alert('변경할 정보가 없습니다.');
				return;
			}
			f.attr('action', '/ServerProgram1/update.do');
			f.submit();
		})
		
		
	
		deleteMember_btn.click(function(){
			if (confirm('탈퇴하겠습니까?')) {
				location.href = '/ServerProgram1/deleteMember.do';
			}
		})
		
		
		
	})
	

</script>


</head>
<body>

<h1>회원 관리 시스템</h1>
<a href="/ServerProgram1/index.jsp">로그아웃</a>
<hr>
<form id="f" method="post">
<table>
	<thead>
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>등급</td>
			<td>포인트</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${loginDTO.id}</td>
			<td> <input type="text" value="${loginDTO.name }" id="name" name="name"></td>
			<td> ${loginDTO.grade}</td>
			<td><input type="text" value="${loginDTO.point}" id="point" name="point"> </td>
		</tr>
	</tbody>
	<tfoot>
			<tr>
				<td colspan="4">
					<input type="button" value="수정하기" id="updateMember_btn"> 
					<input type="button" value="탈퇴하기" id="deleteMember_btn"> 
				</td>
			</tr>
	</tfoot>
</table>
</form>
</body>
</html>