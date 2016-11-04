<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@page import="com.min.domain.Lecture"%>
<%@page import="com.min.common.PagingManager"%>
<%@page import="com.min.domain.LectureCategory"%>
<%@page import="java.util.List"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List listLec= (List)request.getAttribute("listLec");
	List listLecCat = (List)request.getAttribute("listLecCat");
	PagingManager pm=(PagingManager)request.getAttribute("pm");
	int selectValue = (Integer)request.getAttribute("select");
%>
<jsp:include page="inc/header.jsp" flush="false">
	<jsp:param name="menu_name" value="lecture" />
</jsp:include>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>모든 강의</h1>
		<!--       <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol> -->
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12" style="margin-bottom: 5px;">
				<div class="dataTables_length">
					<select id="list_lec_cat_id" name="lecturecategory_id" class="form-control input-sm" style="width: auto;">
						<option value="0">모든 카테고리</option>
						<%for(int i=0; i<listLecCat.size(); ++i){%>
						<%LectureCategory lectureCategory = (LectureCategory)listLecCat.get(i);%>
						<%if(lectureCategory.getLectureCategory_id() == selectValue){%>
						<option value="<%=lectureCategory.getLectureCategory_id()%>" selected><%=lectureCategory.getTitle()%></option>
						<%}else{%>
						<option value="<%=lectureCategory.getLectureCategory_id()%>"><%=lectureCategory.getTitle()%></option>
						<%}%>
						<%}%>
					</select>
				</div>
			</div>
			<div class="col-md-12">
				<div class="box box-primary">
					<div class="box-body">
						<div class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-md-12">
									<table class="table table-bordered table-hover text-center" style="table-layout: fixed" role="grid" aria-describedby="example2_info">
										<thead>
											<tr role="row">
												<th rowspan="1" colspan="1" style="width: 40px !important;"><input type="checkbox" name="checkAll"></th>
												<th rowspan="1" colspan="1">카테고리</th>
												<th rowspan="1" colspan="1">제목</th>
												<th rowspan="1" colspan="1">설명</th>
												<th rowspan="1" colspan="1">등록일</th>
												<th rowspan="1" colspan="1">조회수</th>
											</tr>
										</thead>
										<tbody>
											<%
												int curPos = pm.getCurPos();
												int num = pm.getNum();
											%>
											<%for(int i=1; i<=pm.getPageSize(); i++){%>
											<%if(num<1)break; %>
											<%Lecture lecture = (Lecture)listLec.get(curPos++); num--;%>
											<%
												String categoryName = null;
												String regDate = lecture.getRegdate().substring(0, 11);
												
											%>
											<%
												for(int j=0; j<listLecCat.size(); ++j){
													LectureCategory lectureCategory = (LectureCategory)listLecCat.get(j);
													if(lecture.getLecturecategory_id() == lectureCategory.getLectureCategory_id()){
														categoryName = lectureCategory.getTitle();
														break;
													}
												}
											%>
											<%if(i%2 == 1){ %>
											<tr role="row" class="odd">
											<%}else{ %>
											<tr role="row" class="even">
											<%} %> <!-- end of if -->
												<td style="width: 40px !important;"><input type="checkbox" name="checkValue" value="<%=lecture.getLecture_id()%>"></td>
												<td style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><%=categoryName%></td>
												<td style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><a href="/admin/detaillec.do?lecture_id=<%=lecture.getLecture_id()%>"><%=lecture.getTitle()%></a></td>
												<td style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><%=lecture.getContent()%></td>
												<td style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><%=regDate%></td>
												<td style="text-overflow: ellipsis; overflow: hidden; white-space: nowrap;"><%=lecture.getHit()%></td>
											</tr>
											<%} %> <!-- end of for -->
										</tbody>
									</table>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5">
									<button type="button" class="btn btn-primary" onClick="deleteSomeLecture(<%=selectValue%>)">삭제</button>
								</div>
								<div class="col-sm-7">
									<div class="dataTables_paginate paging_simple_numbers">
										<ul class="pagination">											
											<li class="paginate_button previous">
												<%if(pm.getFirstPage()-1<1){ %>
													<a style="pointer-events: none; cursor: not-allowed;">이전</a>
												<%}else{ %>
													<a href="/admin/listleccat.do?currentPage=<%=pm.getFirstPage()-1%>">Previous</a>
												<%} %>
											</li>
											<%for(int i=pm.getFirstPage(); i<pm.getLastPage(); ++i){%>
    										<%if(i>pm.getTotalPage())break; %>
											<%if(i==pm.getCurrentPage()){%>
											<li class="paginate_button active">
											<%}else{%>
											<li class="paginate_button">
											<%}%> 
												<a href="/admin/listleccat.do?currentPage=<%=i%>"><%=i%></a>
											</li>
									    	<%}%>
									    	<li class="paginate_button previous">
									    		<%if(pm.getLastPage()+1>=pm.getTotalPage()){ %>
									    		<a style="pointer-events: none; cursor: not-allowed;">다음</a>
									    		<%}else{%>
									    		<a href="/admin/listleccat.do?currentPage=<%=pm.getLastPage()+1%>">Next</a>
									    		<%}%>
									    	</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<jsp:include page="inc/footer.jsp" flush="false">
	<jsp:param name="menu_name" value="lecture" />
</jsp:include>