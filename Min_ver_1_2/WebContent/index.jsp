<%@page import="com.min.domain.LectureCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List listLecCat = (List)request.getAttribute("listLecCat");
%>
<%@ include file="inc/header_main.jsp"%>
<!-- Marketing messaging and featurettes
    ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

	<!-- Three columns of text below the carousel -->
	<section>
	<h2 style="margin-top: 0; margin-bottom: 20px; font-weight: 900;">패키지 동영상 강의</h2>
	<div class="row">
		<div class="col-md-3" style="margin-bottom: 30px;">
			<img class="thumbnail"
				src="http://www.justexam.in/assets/blog/comments/default.jpg"
				width="100%" height="100%" style="cursor:pointer;">
			<h3 style="text-align: center; cursor:pointer;">Heading</h3>
		</div>
		<!-- /.col-lg-4 -->
		<div class="col-md-3" style="margin-bottom: 30px;">
			<img class="thumbnail"
				src="http://www.justexam.in/assets/blog/comments/default.jpg"
				width="100%" height="100%" style="cursor:pointer;">
			<h3 style="text-align: center; cursor:pointer;">Heading</h3>
		</div>
		<!-- /.col-lg-4 -->
		<div class="col-md-3" style="margin-bottom: 30px;">
			<img class="thumbnail"
				src="http://www.justexam.in/assets/blog/comments/default.jpg"
				width="100%" height="100%" style="cursor:pointer;">
			<h3 style="text-align: center; cursor:pointer;">Heading</h3>
		</div>
		<!-- /.col-lg-4 -->	
		<div class="col-md-3" style="margin-bottom: 30px;">
			<img class="thumbnail"
				src="http://www.justexam.in/assets/blog/comments/default.jpg"
				width="100%" height="100%" style="cursor:pointer;">
			<h3 style="text-align: center; cursor:pointer;">Heading</h3>
		</div>
		<!-- /.col-lg-4 -->	
	</div><!-- /.row -->
	</section>
	
	<section>
	<h2 style="margin-bottom: 20px; font-weight: 900;">이론 동영상 강의</h2>
	<div class="row">
		<%for(int i=0; i<listLecCat.size(); ++i){%>
		<%LectureCategory lectureCategory = (LectureCategory)listLecCat.get(i); %>
		<%if(lectureCategory.getSort()==1) continue; %>
		<div class="col-md-3" style="margin-bottom: 30px;">
			<img class="thumbnail"
				src="/data/img/lec_cat/<%=lectureCategory.getSummaryimg()%>"
				width="100%" height="100%" style="cursor:pointer;">
			<h3 style="text-align: center; cursor:pointer;"><%=lectureCategory.getTitle()%></h3>
		</div>
		<%}%>
	</div><!-- /.row -->
	</section>
	
	<section>
	<h2 style="margin-bottom: 20px; font-weight: 900;">프로젝트 동영상 강의</h2>
	<div class="row">
		<%for(int i=0; i<listLecCat.size(); ++i){%>
		<%LectureCategory lectureCategory = (LectureCategory)listLecCat.get(i); %>
		<%if(lectureCategory.getSort()==0) continue; %>
		<div class="col-md-3" style="margin-bottom: 30px;">
			<img class="thumbnail"
				src="/data/img/lec_cat/<%=lectureCategory.getSummaryimg()%>"
				width="100%" height="100%" style="cursor:pointer;">
			<h3 style="text-align: center; cursor:pointer;"><%=lectureCategory.getTitle()%></h3>
		</div>
		<%}%>
	</div><!-- /.row -->
	</section>
	
	<section>
	<h2 style="margin-bottom: 20px; font-weight: 900;">커뮤니티</h2>
	<div class="row">
		<div class="col-md-6" style="margin-bottom: 20px;">
			<div class="list-group">
				<a href="#" class="list-group-item active">공지사항</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Morbi leo risus</a> 
				<a href="#" class="list-group-item">Porta ac consectetur ac</a>
				<a href="#" class="list-group-item">Vestibulum at eros</a>
			</div>
		</div>
		<div class="col-md-6" style="margin-bottom: 20px;">
			<div class="list-group">
				<a href="#" class="list-group-item active">민쌤 엿보기</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Morbi leo risus</a> 
				<a href="#" class="list-group-item">Porta ac consectetur ac</a>
				<a href="#" class="list-group-item">Vestibulum at eros</a>
			</div>
		</div>
		<div class="col-md-6" style="margin-bottom: 20px;">
			<div class="list-group">
				<a href="#" class="list-group-item active">프로젝트 경연</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Morbi leo risus</a> 
				<a href="#" class="list-group-item">Porta ac consectetur ac</a>
				<a href="#" class="list-group-item">Vestibulum at eros</a>
			</div>
		</div>
		<div class="col-md-6" style="margin-bottom: 20px;">
			<div class="list-group">
				<a href="#" class="list-group-item active">IT 블로그</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Dapibus ac facilisis in</a>
				<a href="#" class="list-group-item">Morbi leo risus</a> 
				<a href="#" class="list-group-item">Porta ac consectetur ac</a>
				<a href="#" class="list-group-item">Vestibulum at eros</a>
			</div>
		</div>
	</div>
	</section>
</div>
<%@ include file="inc/footer_main.jsp"%>