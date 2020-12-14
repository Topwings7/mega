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
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#all').click(function(){
				if($('#all').is(":checked")){
					$('input[name=deptno]').prop('checked', true);
				}else{
					$('input[name=deptno]').prop('checked', false);
				}
			});
		});
	</script>
</head>
<body>
	<input type="checkbox" id="all">전부
	<form action="list.do">
		<c:forEach items="${deptList }" var="dept">
			<input type="checkbox" name="deptno" value="${dept.deptno }">${dept.dname }
		</c:forEach>
		<input type="submit">
	</form>
</body>
</html>