<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<aside class="col-lg-4">
			<c:if test="${blockManager.blockRecommend != null }">
				<div class="widget">
					<h4 class="title">
						<a href="learn.sp"><c:out value="${blockManager.blockRecommend.name }" /></a>
					</h4>
					<div class="content">
						<c:forEach var="post" items="${blockManager.blockRecommend.postList }">
							<p>
								<a href="learn/article.sp?postId=${post.id }">
									<c:out value="${post.title }"></c:out>
								</a>
							</p>
						</c:forEach>
					</div>
				</div>
			</c:if>
			
			<c:if test="${blockManager.blockDownload != null }">
				<div class="widget">
					<h4 class="title">
						<a href="learn/download.sp"><c:out value="${blockManager.blockDownload.name }" /></a>
					</h4>
					<div class="content">
						<c:forEach var="download" items="${blockManager.blockDownload.downloadList }">
							<p>
								<a href="learn/download.sp?downloadId=${download.id }">
									<c:out value="${download.content }"></c:out>
								</a>
							</p>
						</c:forEach>
					</div>
				</div>
			</c:if>
			
			<c:if test="${blockManager.blockTags != null }">
				<div class="widget">
					<h4 class="title">
						<a href="learn/tag.sp"><c:out value="${blockManager.blockTags.name }" /></a>
					</h4>
					<div class="content tag-cloud">
						<c:forEach var="tag" items="${blockManager.blockTags.tagList }">
							<a href="learn/tag.sp?tagId=${tag.id }">
								<c:out value="${tag.content }"></c:out>
							</a>
						</c:forEach>
					</div>
				</div>
			</c:if>
		</aside>