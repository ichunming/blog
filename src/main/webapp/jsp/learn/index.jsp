<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/nav.jsp"%>
<html lang="zh-CN">
<body>
	<!-- 主体 -->
	<div class="container body-contain">
		<section class="col-lg-8">
			<!-- information -->
			<c:if test="${info != null }">
				<div class="alert alert-info" role="alert">
					<c:out value="${info.message }" />
				</div>
			</c:if>
			
			<!-- article -->
			<c:forEach var="post" items="${requestScope.postList }">
				<article class="post">
					<c:if test="${post.featured == '1' }">
						<div class="featured" title="推荐文章">
							&nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span>&nbsp;
						</div>
					</c:if>
					<div class="post-head">
						<h3 class="post-title">
							<a href="${appPath }/learn/article.sp?postId=${post.id }&recommend=${recommend }"><c:out value="${post.title }" /></a>
						</h3>
						<div class="post-meta">
							<span class="author">&bull;<c:out value="${post.dateTime }" />&nbsp;|&nbsp;<c:out value="${post.author }" /></span>
						</div>
					</div>
	
					<div class="post-content">
						${post.introduce }
					</div>
					<c:if test="${post.tagList != null && fn:length(post.tagList) > 0 }">
						<footer class="post-footer clearfix">
							<div class="sold-line"></div>
							<div class="pull-left tag-list">
								<span class="glyphicon glyphicon-link"></span>
								<c:forEach var="tag" items="${post.tagList }">
									<a href="${appPath }/learn/tag.sp?tagId=${tag.id }"><c:out value="${tag.content }" /></a>
								</c:forEach>
							</div>
						</footer>
					</c:if>
				</article>
			</c:forEach>
			
			<c:if test="${page.totalNumber > 0 }">
				<nav class="pagenav" role="navigation">
					<c:if test="${page.currentPage != 1 }">
						<a class="newer-posts" href="${appPath }/learn.sp?currentPage=${page.currentPage - 1 }&recommend=${recommend }"><span class="glyphicon glyphicon-menu-left"></span></a>
					</c:if>
	   				<span class="page-number">第 ${page.currentPage } 页 &frasl; 共 ${page.totalPage } 页</span>
					<c:if test="${page.currentPage != page.totalPage }">
						<a class="older-posts" href="${appPath }/learn.sp?currentPage=${page.currentPage + 1 }&recommend=${recommend }"><span class="glyphicon glyphicon-menu-right"></span></a>	
					</c:if>	
				</nav>
			</c:if>
		</section>
		<%@ include file="../common/learn_aside.jsp"%>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>