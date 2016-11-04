<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@page import="com.min.domain.LectureCategory"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	LectureCategory lectureCategory = (LectureCategory)request.getAttribute("lectureCategory");
%>
<jsp:include page="inc/header.jsp" flush="false">
	<jsp:param name="menu_name" value="lecture" />
</jsp:include>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>카테고리 수정</h1>
		<!-- 		<ol class="breadcrumb">
			<li><a href="#"><i class="fa fa-youtube-play"></i>강의</a></li>
			<li class="active">카테고리</li>
		</ol> -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-primary">
					<!-- /.box-header -->
					<!-- form start -->
					<form role="form" name="lectureCategoryDetailForm">
						<div class="box-body">
							<div class="form-group">
								<label for="">분류</label><br>
								<label class="col-md-6"> <input type="radio" name="sort" class="minimal" <%if(lectureCategory.getSort() == 0){%> checked <%}%> value="0">이론 강의</label>
								<label class="col-md-6"> <input type="radio" name="sort" class="minimal" <%if(lectureCategory.getSort() == 1){%> checked <%}%> value="1">프로젝트 강의</label>
							</div>
							<div class="form-group" id="lec_cat_title" style="display: none;">
								<input type="text" class="form-control" id="lectureCategory_id" name="lectureCategory_id" value="<%=lectureCategory.getLectureCategory_id()%>">
							</div>
							<div class="form-group" id="lec_cat_title">
								<label for="title">이름</label> <input type="text" class="form-control" id="title" name="title" placeholder="카테고리 이름을 입력해주세요" value="<%=lectureCategory.getTitle()%>">
							</div>
							<div class="form-group" id="lec_cat_instructor">
								<label for="instructor">강사</label> <input type="text" class="form-control" id="instructor" name="instructor" placeholder="강사 이름을 입력해주세요" value="<%=lectureCategory.getInstructor()%>">
							</div>
							<div class="form-group" id="lec_cat_content">
								<label for="content">설명</label>
								<textarea class="form-control" rows="3" id="content" name="content" placeholder="카테고리 설명을 입력주세요"><%=lectureCategory.getContent()%></textarea>
							</div>
							<div class="form-group" id="lec_cat_summary">
								<label for="summary">요약</label> <input type="text" class="form-control" id="summary" name="summary" placeholder="카테고리 요약을 입력주세요" value="<%=lectureCategory.getSummary()%>">
							</div>
							<div class="form-group" id="lec_cat_lang">
								<label for="lang">개발 언어</label> <input type="text" class="form-control" id="lang" name="lang" placeholder="개발 언어를 입력주세요" value="<%=lectureCategory.getLang()%>">
							</div>
							<div class="form-group" id="lec_cat_ide">
								<label for="ide">개발 환경</label> <input type="text" class="form-control" id="ide" name="ide" placeholder="개발 환경 입력주세요" value="<%=lectureCategory.getIde()%>">
							</div>
							<div class="form-group" id="lec_cat_price">
								<label for="price">가격</label> <input type="number" class="form-control" id="price" name="price" placeholder="가격을 입력해주세요" value="<%=lectureCategory.getPrice()%>">
							</div>
							<div class="form-group" id="lec_cat_img_file">
								<label>현재 강의 설명 이미지</label><input type=text style="display: none;" name="img" value="<%=lectureCategory.getImg()%>">
								<img src="/data/img/lec_cat/<%=lectureCategory.getImg()%>" width="100%" height="400px">
								<label for="imgFile">변경할 강의 설명 이미지</label> 
								<input width="100%" type="file" id="imgFile" name="imgFile">
								<p class="help-block">1000X400 크기에 최적화 되어있습니다.</p>
							</div>
							<div class="form-group" id="lec_cat_summary_img_file">
								<label>현재 강의 요약 이미지</label><input type=text style="display: none;" name="summaryimg" value="<%=lectureCategory.getSummaryimg()%>"><br>
								<img src="/data/img/lec_cat/<%=lectureCategory.getSummaryimg()%>" width="300px" height="300px"><br>
								<label for="summaryImgFile">변경할 강의 요약 이미지</label>
								<input width="100%" type="file" id="summaryImgFile" name="summaryImgFile">
								<p class="help-block">300X300 크기에 최적화 되어있습니다.</p>
							</div>
							<div class="form-group">
								<label for="">출력 방식 설정</label><br>
								<label class="col-md-6"><input type="radio" name="isSummary" class="minimal" <%if(lectureCategory.getIsSummary() == 0){%> checked <%}%> value="0">요약 이미지 + 요약 내용</label>
								<label class="col-md-6"> <input type="radio" name="isSummary" class="minimal" <%if(lectureCategory.getIsSummary() == 1){%> checked <%}%> value="1">설명 이미지</label>
							</div>
						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="button" class="btn btn-primary" onClick="modifyLectureCategory()">수정</button>
							<button type="button" class="btn btn-primary" onClick="goLectrueCategory()">목록</button>
							<button type="button" class="btn btn-primary" onClick="deleteOneLectureCategory(<%=lectureCategory.getLectureCategory_id()%>)">삭제</button>
						</div>
					</form>
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>

<!-- /.content-wrapper -->

<jsp:include page="inc/footer.jsp" flush="false">
	<jsp:param name="menu_name" value="lecture_category" />
</jsp:include>