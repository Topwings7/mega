<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(document).ready(function() {
			$('.sub').css('display','none');
			
			/* $('.no').each(function(index, item){
				$(this).click(function(){
					$('#sub'+index).toggle();
				});
			}); */

			$('.no').each(function(index, item){
				$(this).click(function(){
					$(this).siblings('.sub').toggle();
				});
			});
		});
	</script>
</head>
<body>
	<c:set var="i" value="0"/>
	<c:forEach items="${list }" var="p">
		<div>
			<div class="no">${p.bNo }</div>
			<div class="sub" id="sub${i }">${p.bNo } - ${p.bTitle }</div>
			<c:set var="i" value="${i+1 }"/>
		<br><br><br>
		</div>
	</c:forEach>
</body>
</html>