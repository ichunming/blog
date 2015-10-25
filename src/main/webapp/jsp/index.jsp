<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/head.jsp"%>
<%@ include file="common/nav.jsp"%>
<html lang="zh-CN">
<body>
	<!-- 主体 -->
	<div class="container">
		<section class="col-lg-8">
			<!-- article -->
			<c:forEach var="post" items="${requestScope.postList }">
				<article class="post" id=${post.id }>
					<c:if test="${post.featured == '1' }">
						<div class="featured" title="推荐文章">
							<span class="glyphicon glyphicon-star"></span>
						</div>
					</c:if>
					<div class="post-head">
						<h3 class="post-title">
							<a href="learn_article.html"><c:out value="${post.title }" /></a>
						</h3>
						<div class="post-meta">
							<span class="author">&bull;&nbsp;<c:out value="${post.dateTime }" />&nbsp;&nbsp;|&nbsp;&nbsp;<c:out value="${post.author }" /></span>
						</div>
					</div>
	
					<div class="post-content">
						<div>
							<p>${post.content }</p>
						</div>
					</div>
					<footer class="post-footer clearfix">
						<div class="pull-left tag-list">
							<span class="glyphicon glyphicon-link"></span>
							<c:forEach var="link" items="${post.linkList }">
								<a href="${link.href }"><c:out value="${link.content }" /></a>&nbsp;&nbsp;
							</c:forEach>
						</div>
					</footer>
				</article>
			</c:forEach>
		</section>
		<aside class="col-lg-4">
			<c:if test="${blockManager.blockEveryday != null }">
				<div class="widget">
					<h4 class="title">
						<c:choose>
							<c:when test="${blockManager.blockEveryday.href == '' }">
								<c:out value="${blockManager.blockEveryday.name }" />
							</c:when>
							<c:otherwise>
								<a href="${blockManager.blockEveryday.href }"><c:out value="${blockManager.blockEveryday.name }" /></a>
							</c:otherwise>
						</c:choose>
					</h4>
					<div class="news">
						<div class="news-container clearfix">
							<div class="news-container-content">
								<c:forEach var="link" items="${blockManager.blockEveryday.linkList }">
									<p>
										<a href="${link.href }">
											<c:out value="${link.content }"></c:out>
										</a>
									</p>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</c:if>

			<c:if test="${blockManager.blockPartLife != null }">
				<div class="widget">
					<h4 class="title">
						<c:choose>
							<c:when test="${blockManager.blockPartLife.href == '' }">
								<c:out value="${blockManager.blockPartLife.name }" />
							</c:when>
							<c:otherwise>
								<a href="${blockManager.blockPartLife.href }"><c:out value="${blockManager.blockPartLife.name }" /></a>
							</c:otherwise>
						</c:choose>
					</h4>
					<div class="part-life">
						<div class="part-life-container clearfix">
							<div class="part-life-container-content">
								<c:forEach var="link" items="${blockManager.blockPartLife.linkList }">
									<div class="thumbnail">
										<p>
											<a href="${link.href }">
												<c:out value="${link.content }"></c:out>
											</a>
										</p>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</c:if>

			<c:if test="${blockManager.blockTags != null }">
				<div class="widget">
					<h4 class="title">
						<c:choose>
							<c:when test="${blockManager.blockTags.href == '' }">
								<c:out value="${blockManager.blockTags.name }" />
							</c:when>
							<c:otherwise>
								<a href="${blockManager.blockTags.href }"><c:out value="${blockManager.blockTags.name }" /></a>
							</c:otherwise>
						</c:choose>
					</h4>
					<div class="content tag-cloud">
						<c:forEach var="link" items="${blockManager.blockTags.linkList }">
							<a href="${link.href }">
								<c:out value="${link.content }"></c:out>&nbsp;
							</a>
						</c:forEach>
					</div>
				</div>
			</c:if>
		</aside>
	</div>
	<%@ include file="common/foot.jsp"%>
</body>
</html>