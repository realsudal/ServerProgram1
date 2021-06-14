<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		List<MemberDTO> list = MemberDAO.getInstance().selectAll();
		pageContext.setAttribute("list", list);
	%>
	<h1>회원 목록</h1>
	<br>
	<table>
	<thead>
		<tr>
			<td>회원번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>등급</td>
			<td>포인트</td>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.no}</td>
						<td>${dto.id}</td>
						<td>${dto.name}</td>
						<td>${dto.grade}</td>
						<td>${dto.point}</td>
					</tr>
				</c:forEach>
		</tbody>
		
		
		
		
	</table>
</body>
</html>