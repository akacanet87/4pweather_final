<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@page import="com.min.domain.LectureCategory"%>
<%@page import="java.util.List"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List listLecCat = (List)request.getAttribute("list");
%>
<jsp:include page="inc/header.jsp" flush="false">
	<jsp:param name="menu_name" value="lecture" />
</jsp:include>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>강의 올리기</h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-primary">
					<!-- form start -->
					<form role="form" name="lectureForm">
						<div class="box-body">
							<div class="form-group" id="lec_category_id">
								<label for="lecturecategory_id">카테고리</label>
								<select class="form-control input-sm" id="lecturecategory_id" name="lecturecategory_id" style="width: auto;">
									<option value="-1">선택</option>
									<%for(int i=listLecCat.size()-1; i>=0; --i){%>
									<% LectureCategory lectureCategory = (LectureCategory)listLecCat.get(i);%>
									<option value="<%=lectureCategory.getLectureCategory_id()%>"><%=lectureCategory.getTitle()%></option>
									<%}%>
								</select>
							</div>
							<div class="form-group" id="lec_title">
								<label for="title">제목</label>
								<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력해주세요">
							</div>
							<div class="form-group" id="lec_content">
								<label for="content">설명</label>
								<textarea class="form-control" rows="3" id="content" name="content" placeholder="강의 설명을 입력주세요"></textarea>
							</div>
							<div class="form-group" id="lec_link">
								<label for="link">URL</label>
								<div class="input-group input-group-sm" style="border-radius:0; !important">
								<input type="text" class="form-control" id="link" name="link" placeholder="강의 동영상 URL을 입력주세요" style="height:34px; font-size: 14px; border-radius:0;">
								<span class="input-group-btn" >
                     				 <button type="button" class="btn btn-info btn-flat" onClick="checkVideoUrl()" style="font-size: 14px; border-color: #367fa9; background-color: #3c8dbc; height:34px; border-radius:0; !important">확인</button>
                    			</span>
                    			</div>
								<p class="help-block">Vimeo에 등록된 동영상만 확인할 수 있습니다.</p>
							</div>
							<div class="form-group" id="lec_thumbnail">
								<label for="thumbnail">썸네일 이미지</label> <input type="text" class="form-control" id="thumbnail" name="thumbnail" placeholder="동영상 URL 확인 시 자동으로 입력됩니다." readonly>
							</div>
							<div class="form-group" id="lec_lecturefile">
								<label for="lectureSlideFile">강의자료</label> <input type="file" id="lectureSlideFile" name="lectureSlideFile">
							</div>
							<div class="form-group" id="lec_homework">
								<label for="homeworkFile">과제</label> <input type="file" id="homeworkFile" name="homeworkFile">
							</div>
						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="button" class="btn btn-primary" id="lec_btn" disabled="disabled" onClick="addLecture()">추가</button>
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
	<jsp:param name="menu_name" value="lecture" />
</jsp:include>