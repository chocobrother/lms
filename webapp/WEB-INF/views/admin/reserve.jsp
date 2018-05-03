<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>lms</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/admin/rent.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/admin/include/header.jsp" />
		<div id="wrapper">
			<div id="content">
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>대여일</th>
						<th>반납일</th>
					</tr>
					<c:set var = "count" value="${fn:length(map.list.content) }"/>
		      		<c:forEach items="${map.list.content}" var="list" varStatus="status">				
					<tr>
						<td>${count-status.index}</td>
						<td>${list.title }</td>
						<td>${list.categoryName }</td>
						<td>
							${list.reserveDate }
						</td>
						<td>
							${list.returnDate }
						</td>
					</tr>
					</c:forEach>	
				
	
				<tr>
						<td colspan ="6" align = "center">
							<c:if test="${map.startPage > 3 }">
							[<a id = "paging" href = "${pageContext.servletContext.contextPath }/admin/reserve?pg=${map.startPage -1}">이전</a>]	
							</c:if>	
						<c:forEach var="i" begin="${map.startPage }" end="${map.endPage }" step="1">
							<c:if test="${i eq map.pg }">
								[<a id="currentPaging" href="${pageContext.servletContext.contextPath }/admin/reserve?pg=${i}">${i}</a>]
							</c:if>
							
							<c:if test="${i ne map.pg }">
								[<a id="paging" href="${pageContext.servletContext.contextPath }/admin/reserve?pg=${i}">${i}</a>]
							</c:if>
							</c:forEach>
							<c:if test="${map.endPage < map.totalP }">
								[<a id = "paging"
								href="${pageContext.servletContext.contextPath }/admin/reserve?pg=${map.endPage+1 }">다음</a>]
							</c:if>
					</td>
				</tr> 
				
				
				
				</table>
			</div>
			<c:import url="/WEB-INF/views/admin/include/navigation.jsp" />
		</div>
	</div>
</body>
</html>