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
	<%-- <c:if test="${not empty writeResult }">
		<script>
			opener.location.href = '${conPath}/list.do';
			window.close();
		</script> 
	</c:if>--%>
	<script>
		$(document).ready(function() {
			/* $('#writeForm').click(function(){
				window.open('${conPath }/writeForm.do','','width=600, height=700, left=100');
			}); */
		});
		function trClicked(bno){
			location.href='${conPath}/detail.do?bno='+bno+'&pageNum='+${paging.currentPage};
		}
	</script>
</head>
<body oncontextmenu="return false" ondragstart="return false" onselectstart="return false">
	<c:if test="${not empty successMsg }">
		<script>
			alert('${successMsg}');
		</script>
	</c:if>
	<c:if test="${not empty failMsg }">
		<script>
			alert('${failMsg}');
		</script>
	</c:if>
	<div class="paging">
	<form action="${conPath }/list.do">
		<select name="schItem">
			<option value="">검색조건</option>
			<option value="btitle"
				<c:if test="${param.schItem=='btitle' }">selected="selected"</c:if>
			>제목</option>
			<option value="bcontent"
				<c:if test="${param.schItem=='bcontent' }">selected="selected"</c:if>
			>내용</option>
			<option value="all"
				<c:if test="${param.schItem=='all' }">selected="selected"</c:if>
			>제목+내용</option>
		</select>
		<input type="text" name="schWord" class="btn" value="${param.schWord }">
		<input type="submit" value="검색" class="btn">
	</form>
	</div>
	<table>
		<tr><td colspan="2"><a href="${conPath }/writeForm.do"><span id="writeForm">글쓰기</span></a></td></tr>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
		</tr>
		<c:forEach var="dto" items="${list }">
			<tr onclick="trClicked('${dto.bno}')">
				<td>${dto.bno }</td>
				<td>${dto.btitle } <c:if
						test="${dto.bfile!=null and dto.bfile!='' }">
						<!-- 첨부파일이 있으면 파일이미지 나타남 -->
						<img src="${conPath }/img/file.gif">
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="paging">
		<c:if test="${paging.startPage>paging.blockSize}">
			<a href="${conPath }/list.do?pageNum=${paging.startPage-1}&schItem=${param.schItem }&schWord=${param.schWord}">&nbsp;〈〈&nbsp;</a>
		</c:if>
		<c:forEach var="i" begin="${paging.startPage}"
			end="${paging.endPage }">
			<c:if test="${paging.currentPage==i }">
				<b>&nbsp;${i }&nbsp;</b>
			</c:if>
			<c:if test="${paging.currentPage != i }">
				<a href="${conPath }/list.do?pageNum=${i }&schItem=${param.schItem }&schWord=${param.schWord}">&nbsp;${i }&nbsp;</a>
			</c:if>
		</c:forEach>
		<c:if test="${paging.endPage<paging.pageCnt }">
			<a href="${conPath }/list.do?pageNum=${paging.endPage + 1}&schItem=${param.schItem }&schWord=${param.schWord}">&nbsp;〉〉&nbsp;</a>
		</c:if><br><br>
		이 화면은 드레그 해서 복사가 안 되요
	</div>
</body>
</html>