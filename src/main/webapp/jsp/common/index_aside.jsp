<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<aside class="col-lg-4">
			<c:if test="${blockManager.blockEveryday != null }">
				<div class="widget">
					<h4 class="title">
						<a href="everyday.sp"><c:out value="${blockManager.blockEveryday.name }" /></a>
					</h4>
					<div class="news">
						<div class="news-container clearfix">
							<div class="news-container-content">
								<c:if test="${blockManager.blockEveryday.status != null }">
									<p>
										<a href="everyday.sp">
											${blockManager.blockEveryday.status.content }
										</a>
									</p>
								</c:if>
							</div>
						</div>
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