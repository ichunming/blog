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
							<a href="learn/article.sp?postId=${post.id }"><c:out value="${post.title }" /></a>
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
									<a href="learn/tag.sp?tagId=${tag.id }"><c:out value="${tag.content }" /></a>&nbsp;&nbsp;
								</c:forEach>
							</div>
						</footer>
					</c:if>
				</article>
			</c:forEach>
			
			<c:if test="${page.totalNumber > 0 }">
				<nav class="pagenav" role="navigation">
					<c:if test="${page.currentPage != 1 }">
						<a class="newer-posts" href="learn?currentPage=${page.currentPage - 1 }"><span class="glyphicon glyphicon-menu-left"></span></a>
					</c:if>
	   				<span class="page-number">第 ${page.currentPage } 页 &frasl; 共 ${page.totalPage } 页</span>
					<c:if test="${page.currentPage != page.totalPage }">
						<a class="older-posts" href="learn?currentPage=${page.currentPage + 1 }"><span class="glyphicon glyphicon-menu-right"></span></a>	
					</c:if>	
				</nav>
			</c:if>
		</section>
		<%@ include file="../common/learn_aside.jsp"%>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>