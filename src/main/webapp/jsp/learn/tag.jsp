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
			<!-- warning -->
			<c:if test="${info != null }">
				<div class="alert alert-warning" role="alert">
					<c:out value="${info.message }" />
				</div>
			</c:if>
			
			<c:if test="${tagList != null }">
				<article class="post">
					<div class="content tag-cloud">
						<c:forEach var="tag" items="${tagList }">
							<a class="${tag.id == tagId ? 'current' : 'default' }" href="${appPath }/learn/tag.sp?tagId=${tag.id }"><c:out value="${tag.content }" /></a>
						</c:forEach>
					</div>
				</article>
			</c:if>
			
			<c:if test="${postList != null }">
				<c:forEach var="post" items="${postList }">
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
					</article>
				</c:forEach>
			</c:if>
		</section>
		<%@ include file="../common/learn_aside.jsp"%>
	</div>
	<%@ include file="../common/foot.jsp"%>
</body>
</html>