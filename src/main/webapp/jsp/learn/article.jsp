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
			<article class="post">
				<c:if test="${article.post.featured == '1' }">
					<div class="featured" title="推荐文章">
						&nbsp;<span class="glyphicon glyphicon-star" aria-hidden="true"></span>&nbsp;
					</div>
				</c:if>
				<div class="post-head">
					<h2 class="post-title"><c:out value="${article.post.title }" /></h2>
					<div class="post-meta">
        				<span class="author">&bull;&nbsp;<c:out value="${article.post.dateTime }" />&nbsp;&nbsp;|&nbsp;&nbsp;<c:out value="${article.post.author }" /></span>
					</div>
				</div>
				<div class="post-content">
					${article.post.content }
				</div>

				<footer class="post-footer clearfix">
					<c:if test="${article.post.tagList != null && fn:length(article.post.tagList) > 0 }">
						<div class="pull-left tag-list">
							<span class="glyphicon glyphicon-link"></span>
							<c:forEach var="tag" items="${article.post.tagList }">
								<a href="${appPath }/learn/tag.sp?tagId=${tag.id }"><c:out value="${tag.content }" /></a>
							</c:forEach>
						</div>
					</c:if>
				
					<c:if test="${article.preId != null }">
						<div class="pull-left tag-list">
							<p><span class="glyphicon glyphicon-backward"></span><a title="上一篇" href="${appPath }/learn/article?postId=${article.preId }"><c:out value="${article.preTitle }" /></a></p>
						</div>
					</c:if>
					<c:if test="${article.nextId != null }">
						<div>
							<p><span class="glyphicon glyphicon-forward"></span><a title="下一篇" href="${appPath }/learn/article?postId=${article.nextId }"><c:out value="${article.nextTitle }" /></a></p>
						</div>
					</c:if>
				</footer>
			</article>
		</section>
		<%@ include file="../common/learn_aside.jsp"%>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>