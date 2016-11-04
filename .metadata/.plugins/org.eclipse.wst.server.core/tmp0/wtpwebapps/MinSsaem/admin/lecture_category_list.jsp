<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@page import="com.min.domain.LectureCategory"%>
<%@page import="com.min.common.PagingManager"%>
<%@page import="java.util.List"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<LectureCategory> list=(List)request.getAttribute("list");
	PagingManager pm=(PagingManager)request.getAttribute("pm");
%>
<jsp:include page="inc/header.jsp" flush="false">
	<jsp:param name="menu_name" value="lecture" />
</jsp:include>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>모든 카테고리</h1>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-primary">
					<!-- /.box-header -->
					<div class="box-body">
						<div class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-md-12">
									<table class="table table-bordered table-hover text-center" style="table-layout:fixed" role="grid">
										<thead>
											<tr role="row">
												<th rowspan="1" colspan="1" style="width:40px !important;"><input type="checkbox" name="checkAll"></th>
												<th rowspan="1" colspan="1">이름</th>
												<th rowspan="1" colspan="1">강사</th>
												<th rowspan="1" colspan="1">내용</th>
												<th rowspan="1" colspan="1">요약</th>
												<th rowspan="1" colspan="1">개발 언어</th>
												<th rowspan="1" colspan="1">개발 환경</th>
												<th rowspan="1" colspan="1">가격</th>
												<th rowspan="1" colspan="1">강의수</th>
												<th rowspan="1" colspan="1">판매수</th>
											</tr>
										</thead>
										<tbody>
											<%
												int curPos = pm.getCurPos();
												int num = pm.getNum();
											%>
											<%for(int i=1; i<=pm.getPageSize(); i++){%>
											<%if(num<1)break; %>
											<%LectureCategory lectureCategory = list.get(curPos++);num--;%> 
											<%if(i%2 == 1){ %>
											<tr role="row" class="odd">
											<%}else{ %>
											<tr role="row" class="even">
											<%} %> <!-- end of if -->
												<td style="width:40px !important;"><input type="checkbox" name="checkValue" value="<%=lectureCategory.getLectureCategory_id()%>"></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><a href="/admin/detailleccat.do?lecturecategory_id=<%=lectureCategory.getLectureCategory_id()%>"><%=lectureCategory.getTitle()%></a></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getInstructor()%></td>												
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getContent()%></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getSummary()%></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getLang()%></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getIde()%></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getPrice()%></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getNumOfLecture()%></td>
												<td style="text-overflow:ellipsis; overflow:hidden; white-space: nowrap;"><%=lectureCategory.getRank()%></td>
											</tr>											
											<%} %> <!-- end of for -->
										</tbody>
									</table>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-5">
									<button type="button" class="btn btn-primary" onClick="deleteSomeLectureCategory()">삭제</button>
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
									    		<%}else{ %>
									    		<a href="/admin/listleccat.do?currentPage=<%=pm.getLastPage()+1%>">Next</a>
									    		<%} %>
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
	<jsp:param name="menu_name" value="lecture_category" />
</jsp:include>