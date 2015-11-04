<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/nav.jsp"%>
<html lang="zh-CN">
<body>
	<!-- 主体 -->
	<div class="container">
		<section class="col-lg-8">
			<!-- article -->
			<c:forEach var="post" items="${requestScope.postList }">
				<article class="post">
					<c:if test="${post.featured == '1' }">
						<div class="featured" title="推荐文章">
							<span class="glyphicon glyphicon-star"></span>
						</div>
					</c:if>
					<div class="post-head">
						<h3 class="post-title">
							<a href="learn.sp?postId=${post.id }"><c:out value="${post.title }" /></a>
						</h3>
						<div class="post-meta">
							<span class="author">&bull;&nbsp;<c:out value="${post.dateTime }" />&nbsp;&nbsp;|&nbsp;&nbsp;<c:out value="${post.author }" /></span>
						</div>
					</div>
	
					<div class="post-content">
						${post.introduce }
					</div>
					<c:if test="${post.tagList != null && fn:length(post.tagList) > 0 }">
						<footer class="post-footer clearfix">
							<div class="pull-left tag-list">
								<span class="glyphicon glyphicon-link"></span>
								<c:forEach var="tag" items="${post.tagList }">
									<a href="tag.sp?tagId=${tag.id }"><c:out value="${tag.content }" /></a>&nbsp;&nbsp;
								</c:forEach>
							</div>
						</footer>
					</c:if>
				</article>
			</c:forEach>
			
			<nav class="pagenav" role="navigation">
       			<a class="newer-posts" href="learn_article.html">
					<span class="glyphicon glyphicon-menu-left"></span></a>
   				<span class="page-number">第 2 页 &frasl; 共 7 页</span>
       			<a class="older-posts" href="#">
					<span class="glyphicon glyphicon-menu-right"></span></a>				
			</nav>
		</section>
		<%@ include file="../common/learn_aside.jsp"%>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>