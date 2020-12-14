<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath}/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {

	});
</script>
</head>
<body>
	<table>
		<tr>
			<th>사번</th><th>이름</th><th>직책</th><th>상사</th><th>입사일</th><th>급여</th><th>상여</th><th>부서번호</th>
		</tr>
		<c:forEach var="emp" items="${empList }">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.ename }</td>
				<td>${emp.job }</td>
				<td>${emp.mgr }</td>
				<td><fmt:formatDate value="${emp.hiredate }" pattern="yy/MM/dd(E)"/> </td>
				<td>${emp.sal }</td>
				<td>${emp.comm }</td>
				<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>