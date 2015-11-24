<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/nav.jsp"%>
<html lang="zh-CN">
<body>
	<!-- 主体 -->
	<div class="container life-everyday body-contain">
		<!-- warning -->
		<c:if test="${info != null }">
			<div class="alert alert-info" role="alert">
				<c:out value="${info.message }" />
			</div>
		</c:if>
		
		<c:if test="${statusList != null }">
			<c:forEach var="status" items="${statusList }">
				<div class="panel">
					<div class="panel-body life-everyday-container">
						<div class="life-everyday-container-content">
							<p>${status.content }</p>
						</div>
					</div>
					<div class="panel-footer life-everyday-datetime">
						<span>${status.dateTime } | ${status.note }</span>
					</div>
				</div>
			</c:forEach>
		</c:if>

		<c:if test="${page.totalNumber > 0 }">
			<nav class="pagenav" role="navigation">
				<c:if test="${page.currentPage != 1 }">
					<a class="newer-posts" href="${appPath }/learn.sp?currentPage=${page.currentPage - 1 }"><span class="glyphicon glyphicon-menu-left"></span></a>
				</c:if>
   				<span class="page-number">第 ${page.currentPage } 页 &frasl; 共 ${page.totalPage } 页</span>
				<c:if test="${page.currentPage != page.totalPage }">
					<a class="older-posts" href="${appPath }/life.sp?currentPage=${page.currentPage + 1 }"><span class="glyphicon glyphicon-menu-right"></span></a>	
				</c:if>	
			</nav>
		</c:if>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>