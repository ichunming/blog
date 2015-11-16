<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/nav.jsp"%>
<html lang="zh-CN">
<body>
	<!-- 主体 -->
	<div class="container body-contain">
		<!-- information -->
		<c:if test="${info != null }">
			<div class="alert alert-info" role="alert">
				<c:out value="${info.message }" />
			</div>
		</c:if>
		
		<!-- about -->
		<c:if test="${aboutList != null }">
			<c:forEach var="about" items="${aboutList }">
				<div class="panel panel-success about">
					<div class="panel-heading">
						<h3 class="panel-title">${about.title }</h3>
					</div>
					<div class="panel-body tool-container">
						${about.content }
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>