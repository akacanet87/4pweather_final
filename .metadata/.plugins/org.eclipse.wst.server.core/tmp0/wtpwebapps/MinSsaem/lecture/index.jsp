<%@page import="com.min.domain.LectureCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<LectureCategory> list = (List) request.getAttribute("lecturecategorylist");
%>
<%@ include file="../inc/header.jsp"%>
<div class="container marketing" style="margin-top: 60px;">
	<section>
		<h2 style="margin-bottom: 20px; font-weight: 900;">강의 리스트</h2>

		<%
			for (int a = 0; a < list.size(); a++) {

				LectureCategory lectureCategory = list.get(a);
				if(lectureCategory.getSort() == 1) continue;
				String lectureCategoryTitle = lectureCategory.getTitle();
				int lectureCategory_id = lectureCategory.getLectureCategory_id();
		%>
		<div class="row">
			<div class="col-md-4" style="margin-bottom: 20px;" onClick="goList()">
				<a href="/lecture/list.do?lecturecategory_id=<%=lectureCategory_id%>">
					<img class="thumbnail" width="100%" height="100%" src="/data/img/lec_cat/<%=lectureCategory.getSummaryimg()%>">
				</a>
			</div>
			<div class="col-md-8" style="margin-bottom: 20px;">
				<div class="list-group">
						<a href="#" class="list-group-item active"><%=lectureCategoryTitle%></a>
						<a href="#" class="list-group-item">강의구성 : 총 <%=lectureCategory.getNumOfLecture()%>강</a>
						<a href="#" class="list-group-item">강      사 : <%=lectureCategory.getInstructor()%></a>
						<a href="#" class="list-group-item">개발언어 : <%=lectureCategory.getLang()%></a>
						<a href="#" class="list-group-item">개발환경 : <%=lectureCategory.getIde()%></a>
						<a href="#" class="list-group-item">강좌설명 : <%=lectureCategory.getContent()%></a>
						<a href="#" class="list-group-item">가      격 : <%=lectureCategory.getPrice()%></a>
				</div>
			</div>
		</div>
		<%
			}
		%>
	</section>
</div>
<%@ include file="../inc/footer.jsp"%>