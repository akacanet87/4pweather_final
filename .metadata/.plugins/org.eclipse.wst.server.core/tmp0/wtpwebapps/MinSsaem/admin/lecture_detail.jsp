<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@page import="com.min.domain.Lecture"%>
<%@page import="com.min.domain.LectureCategory"%>
<%@page import="java.util.List"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List listLecCat = (List)request.getAttribute("listLecCat");
	Lecture lecture = (Lecture)request.getAttribute("lecture");
%>
<jsp:include page="inc/header.jsp" flush="false">
	<jsp:param name="menu_name" value="lecture" />
</jsp:include>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>강의 수정</h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-primary">
					<!-- form start -->
					<form role="form" name="lectureDetailForm">
						<div class="box-body">
							<div class="form-group" id="lec_category_id">
								<label for="lecturecategory_id">카테고리</label>
								<select class="form-control input-sm" id="lecturecategory_id" name="lecturecategory_id" style="width: auto;">
									<%for(int i=listLecCat.size()-1; i>=0; --i){%>
									<% LectureCategory lectureCategory = (LectureCategory)listLecCat.get(i);%>
									<%if(lectureCategory.getLectureCategory_id() == lecture.getLecturecategory_id()){%>
									<option value="<%=lectureCategory.getLectureCategory_id()%>" selected><%=lectureCategory.getTitle()%></option>
									<%}%>
									<%}%>
								</select>
							</div>
							<input type="text" style="display: none;" name="lecture_id" value="<%=lecture.getLecture_id()%>">
							<div class="form-group" id="lec_title">
								<label for="title">제목</label>
								<input type="text" class="form-control" id="title" name="title" placeholder="제목을 입력해주세요" value="<%=lecture.getTitle()%>">
							</div>
							<div class="form-group" id="lec_content">
								<label for="content">설명</label>
								<textarea class="form-control" rows="3" id="content" name="content" placeholder="강의 설명을 입력주세요"><%=lecture.getContent()%></textarea>
							</div>
							<div class="form-group" id="lec_link">
								<label for="link">URL</label>
								<div class="input-group input-group-sm" style="border-radius:0; !important">
								<input type="text" class="form-control" id="link" name="link" placeholder="강의 동영상 URL을 입력주세요" style="height:34px; font-size: 14px; border-radius:0;" value="<%=lecture.getLink()%>">
								<span class="input-group-btn" >
                     				 <button type="button" class="btn btn-info btn-flat" onClick="checkVideoUrl()" style="font-size: 14px; border-color: #367fa9; background-color: #3c8dbc; height:34px; border-radius:0; !important">확인</button>
                    			</span>
                    			</div>
								<p class="help-block">Vimeo에 등록된 동영상만 확인할 수 있습니다.</p>
							</div>
							<div class="form-group">
								<label for="link">현재 등록된 동영상</label>
								<iframe src="<%=lecture.getLink()%>" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen style="width: 100%; height: 500px;"></iframe>
							</div>
							<div class="form-group" id="lec_thumbnail">
								<label for="thumbnail">썸네일 이미지</label><br>
								<input type="hidden" class="form-control" id="thumbnail" name="thumbnail" placeholder="강의 시간" value="<%=lecture.getThumbnail()%>" readonly>
								<img src="<%=lecture.getThumbnail()%>">
							</div>
							
							<div class="form-group">
								<label>현재 등록된 강의 자료</label><br>
								<a href="/data/file/lec/<%=lecture.getLecturefile()%>" download><%=lecture.getLecturefile()%></a><br>
								<input name="lecturefile" value="<%=lecture.getLecturefile()%>" style="display: none;">
							</div>
							<div class="form-group" id="lec_lecturefile">
								<label for="lectureSlideFile">변경할 강의 자료</label>
								<input type="file" id="lecturefile" name="lectureSlideFile">
							</div>
							<div class="form-group" id="lec_homework">
								<label>현재 등록된 과제</label><br>
								<a href="/data/file/lec/<%=lecture.getHomework()%>" download><%=lecture.getHomework()%></a><br>
								<input name="homework" value="<%=lecture.getHomework()%>" style="display: none;">
							</div>
							<div class="form-group" id="lec_homework">
								<label for="homeworkFile">변경할 과제</label>
								<input type="file" id="homework" name="homeworkFile">
							</div>
						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="button" class="btn btn-primary" onClick="modifyLecture()" disabled="disabled" id="lec_btn">수정</button>
							<button type="button" class="btn btn-primary" onClick="goLectrueAll()">목록</button>
							<button type="button" class="btn btn-primary" onClick="deleteOneLecture(<%=lecture.getLecture_id()%>, <%=lecture.getLecturecategory_id()%>)">삭제</button>
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