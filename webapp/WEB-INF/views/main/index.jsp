<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="./jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">



</script>

<head>
<title>LMS</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath }" method="get">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
				
					<tr>
						<th>번호</th>
						<th>타이틀</th>
						<th>카테고리</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var = "count" value="${fn:length(map.list.content) }"/>
		      		<c:forEach items="${map.list.content}" var="list" varStatus="status">
					<tr>
						<td>${count-status.index}</td>
						<td>${list.name }</td>
						<td>${list.categoryname}</td>
						<td>
							<c:choose>
								<c:when test = "${empty authUser }">
									<a href="#" class="btn">대여</a>
									<a href="#" class="btn">예약</a>
								</c:when>
								
								<c:otherwise>
									<a href="${pageContext.servletContext.contextPath }/user/rent/${list.id}/${authUser.no}" class="btn" onclick="changeText(this)">대여</a>
									<a href="${pageContext.servletContext.contextPath }/user/reverse/${list.id}/${authUser.no}" class="btn">예약</a>
								</c:otherwise>
								
							</c:choose>
							
						</td>
					</tr>
					</c:forEach>
					
				
			<%-- 	<div class="pager">
					<ul>
						<li><a href="${pageContext.servletContext.contextPath }/rent">◀</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/rent">6</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/rent">7</a></li>
						<li class="selected">8</li>
						<li>9</li>
						<li>10</li>
						<li>▶</li>
					</ul>
				</div>	 --%>			
				
				
				<!-- 페이징	-->
					<tr>
						<td colspan ="6" align = "center">
							<c:if test="${map.startPage > 3 }">
							[<a id = "paging" href = "${pageContext.servletContext.contextPath }/?pg=${map.startPage -1}">이전</a>]	
							</c:if>	
						<c:forEach var="i" begin="${map.startPage }" end="${map.endPage }" step="1">
							<c:if test="${i eq map.pg }">
								[<a id="currentPaging" href="${pageContext.servletContext.contextPath }/?pg=${i}">${i}</a>]
							</c:if>
							
							<c:if test="${i ne map.pg }">
								[<a id="paging" href="${pageContext.servletContext.contextPath }/?pg=${i}">${i}</a>]
							</c:if>
							</c:forEach>
							<c:if test="${map.endPage < map.totalP }">
								[<a id = "paging"
								href="${pageContext.servletContext.contextPath }/?pg=${map.endPage+1 }">다음</a>]
							</c:if>
					</td>
				</tr> 
				
				</table>
				
				<div class="bottom">
				</div>
			</div>
		</div>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>