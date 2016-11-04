<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<jsp:include page="inc/header.jsp" flush="false">
        <jsp:param name="menu_name" value="file"/>
</jsp:include> 
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        file insert
        <small>Optional description</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
      </ol>
    </section>
 
    <!-- Main content -->
    <section class="content">
 
      <!-- Your Page Content Here -->
 
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  
<jsp:include page="inc/footer.jsp" flush="false">
	<jsp:param name="menu_name" value="file" />
</jsp:include>