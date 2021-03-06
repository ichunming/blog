<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- start header -->
<!--<header class="header_img">
	<div class="container"></div>
</header>-->
<!-- end header -->

<!-- start nav -->
<nav class="main-navigation navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#main-menu">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
		</div>
		<!-- /.navbar-header -->

		<div class="collapse navbar-collapse" id="main-menu">
			<ul class="menu">
				<c:forEach var="menu" items="${menuManager.menuList }" varStatus="s">
					<c:choose>
						<c:when test="${currentNav == s.index }">
							<li role="presentation" class="nav-current"><a href="${menu.href }">${menu.name }</a></li>
						</c:when>
						<c:otherwise>
							<li role="presentation"><a href="${menu.href }">${menu.name }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
		<!-- /.collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<!-- end nav -->