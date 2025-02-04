<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.min.domain.LectureCategory"%>
<%@page import="com.min.domain.Lecture"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Lecture> lecturelist = (List) request.getAttribute("lecturelist");
	LectureCategory lectureCategory = (LectureCategory) request.getAttribute("lectureCategory");
%>
<%@ include file="../inc/header.jsp"%>
<div class="container marketing">
	<section>
		<h1>
			<span class="label label-default"><%=lectureCategory.getTitle()%></span>
		</h1>
	</section>
	<section>
		<div>
			<%
				if (lectureCategory.getIsSummary() == 0) {
			%>
			<div class="media">
				<div class="media-left media-middle">
					<a href="#"> <img class="thumbnail" height="200px"
						src="/data/img/lec_cat/<%=lectureCategory.getSummaryimg()%>"
						alt="...">
					</a>
				</div>
				<div class="media-body media-middle">
					<h4 class="media-middle"><%=lectureCategory.getSummary()%></h4>
				</div>
			</div>
			<%
				} else {
			%>
			<div class="col-md-12" style="margin-bottom: 20px;">
				<div class="page-header">
					<img height="200px" class=""
						src="/data/img/lec_cat/<%=lectureCategory.getImg()%>" alt="...">
				</div>
			</div>
			<%
				}
			%>
		</div>
	</section>

	<section>
		<%
			for (int a = 0; a < lecturelist.size(); a++) {
				Lecture lecture = lecturelist.get(a);
				int lecture_id = lecture.getLecture_id();
				int lectureNum = a + 1;
		%>

		<div class="row">
			<div class="col-md-3" style="margin-bottom: 20px;" onClick="goList()">
				<a
					href="/lecture/player.do?lecture_id=<%=lecture_id%>&title=<%=lectureCategory.getTitle()%>&lectureNum=<%=lectureNum%>">
					<img width="100%" class="lectureTitle1" src="<%=lecture.getThumbnail()%>">
				</a>
			</div>
			<div class="col-md-8" style="margin-bottom: 20px;">
				<div class="list-group">
					<a href="#" class="list-group-item active">목차 : <%=lectureNum%>강
					</a> <a href="#" class="list-group-item">주제 : <%=lecture.getTitle()%></a>
					<a href="#" class="list-group-item">내용 : <%=lecture.getContent()%></a>
					<a href="#" class="list-group-item">개발환경 : <%=lectureCategory.getIde()%></a>
				</div>
			</div>
			<div class="col-md-1" style="margin-bottom: 20px;">
				<div>
					<img width="50px" height="50px" class="stamp"
						src="http://image.shutterstock.com/display_pic_with_logo/450076/141568954/stock-vector-vector-completed-stamp-141568954.jpg">
				</div>
				<div>취득점수(7/10)</div>
			</div>
		</div>
		<%
			}
		%>
	</section>
</div>

<%@ include file="../inc/footer.jsp"%>