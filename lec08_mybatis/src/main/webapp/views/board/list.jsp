<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판?보드?</title>
</head>
<body>
	<form action="<c:url value='/boardList'/>" id="searchFrm">
		<fieldset>
			<legend>검색하기</legend>
			<input type="text" name="board_title" placeholder="제목">
			<input type="text" name="board_content" placeholder="내용">
			<input type="text" name="member_name" placeholder="작성자">
			<input type="submit" value="조회">
		</fieldset>
		<fieldset>
			<legend>정렬하기</legend>
			<select name="order_type" id="order_type">
				<option value="-1">선택</option>
				<option value="1">최신순</option>
				<option value="2">오래된순</option>
			</select>
		</fieldset>
	</form>
	<table border="1" style="text-align: center">
		<caption>글 목록</caption>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<!-- 
			resultList가 비어있으면 -> 게시글이 없습니다. 
			그렇지 않으면 출력 -> 번호, 제목, 내용
			-->
			<c:choose>
				<c:when test="${not empty resultList }">
					<c:forEach var="list" varStatus="vs" items="${resultList }">
						<tr>
							<td>${vs.count }</td>
							<td>${list.boardTitle }</td>
							<td>${list.boardContent }</td>
							<%-- <c:out value="" escapeXml="false"><td>${list.boardNo }<td></c:out> --%>
							<%-- <c:out value="<td>${list.boardTitle }<td>" escapeXml="false"/>
							<c:out value="<td>${list.boardContent }<td>" escapeXml="false"/> --%>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="3">자료없음!</td>
						<%-- <c:out value="<td colspan="3">${없어용}<td>" escapeXml="false"/> --%>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	<!-- 순수 HTML -->
	<script>
		const orderType = document.getElementById('order_type');
		orderType.onchange = function(){
			document.getElementById('searchFrm').submit();
		}
	</script>
	
</body>
</html>