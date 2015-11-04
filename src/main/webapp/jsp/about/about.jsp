<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/nav.jsp"%>
<html lang="zh-CN">
<body>
	<!-- 主体 -->
	<div class="container">
		<div class="panel panel-success about">
			<div class="panel-heading">
				<h3 class="panel-title">关于我</h3>
			</div>
			<div class="panel-body tool-container">
				张春明，90后，IT男。
			</div>
		</div>
		
		<div class="panel panel-success about">
			<div class="panel-heading">
				<h3 class="panel-title">关于本站</h3>
			</div>
			<div class="panel-body tool-container">
				<p>前端技术：<a href="http://v3.bootcss.com/">bootstrap</a></p>
				<p>后端技术：<a href="http://projects.spring.io/spring-framework/">SpringMVC</a> + <a href="http://ibatis.apache.org/">MyBatis</a> + <a href="http://www.eclipse.org/jetty/">Jetty</a></p>
			</div>
		</div>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>