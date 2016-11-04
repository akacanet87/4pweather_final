<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String menuName = (String)request.getParameter("menu_name");
%>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Min Admin</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <!-- DataTables -->
  <link rel="stylesheet" href="../resources/plugins/datatables/dataTables.bootstrap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="../resources/dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="../resources/plugins/iCheck/flat/blue.css">
  <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
  <link rel="stylesheet" href="../resources/dist/css/skins/skin-blue.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">


  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="index2.html" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>MS</b>A</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>MS</b>Admin</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
          <li class="dropdown messages-menu">
          <!-- Notifications Menu -->
          <li class="dropdown notifications-menu">
            <!-- Menu toggle button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <i class="fa fa-bell-o"></i>
              <span class="label label-warning">10</span>
            </a>
            <ul class="dropdown-menu">
              <li class="header">You have 10 notifications</li>
              <li>
                <!-- Inner Menu: contains the notifications -->
                <ul class="menu">
                  <li><!-- start notification -->
                    <a href="#">
                      <i class="fa fa-users text-aqua"></i> 5 new members joined today
                    </a>
                  </li>
                  <!-- end notification -->
                </ul>
              </li>
              <li class="footer"><a href="#">View all</a></li>
            </ul>
          </li>
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" >
              <!-- The user image in the navbar-->
              <img src="../resources/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">User Name</span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="../resources/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  Alexander Pierce - Web Developer
                  <small>Member since Nov. 2012</small>
                </p>
              </li>
              
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Profile</a>
                </div>
                <div class="pull-right">
                  <a href="#" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
      	<%if(menuName.equals("dash_board")){%>
      	<li class="active">
      	<%}else{ %>
      	<li class="">
      	<%} %>
      	<a href="dash_board.jsp"><i class="fa fa-dashboard"></i> <span>알림판</span></a></li>
      	<%if(menuName.equals("main")){%>
      	<li class="treeview active">
      	<%}else{ %>
      	<li class="treeview">
      	<%} %>
          <a href="#"><i class="fa fa-home"></i> <span>메인</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="main_package.jsp">패캐지 상품</a></li>
            <li><a href="main_theory.jsp">이론 상품</a></li>
            <li><a href="main_project.jsp">프로젝트 상품</a></li>
          </ul>
        </li>
        <%if(menuName.equals("lecture")){%>
      	<li class="treeview active">
      	<%}else{ %>
      	<li class="treeview">
      	<%} %>
          <a href="#"><i class="fa fa-youtube-play"></i> <span>강의</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="/admin/listleccat.do">모든 카테고리</a></li>
            <li><a href="lecture_category_insert.jsp">카테고리 추가</a></li>
            <li><a href="/admin/listlec.do?select=0">모든 강의</a></li>
            <li><a href="/admin/insertlec.do">강의 올리기</a></li>
            <li><a href="lecture_question.jsp">질문</a></li>
          </ul>
        </li>
        <%if(menuName.equals("post")){%>
      	<li class="treeview active">
      	<%}else{ %>
      	<li class="treeview">
      	<%} %>
          <a href="#"><i class="fa fa-pencil"></i> <span>글</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="post_category.jsp">카테고리</a></li>
            <li><a href="post_all.jsp">모든 글</a></li>
            <li><a href="post_insert.jsp">새 글쓰기</a></li>
          </ul>
        </li>
        <%if(menuName.equals("file")){%>
      	<li class="treeview active">
      	<%}else{ %>
      	<li class="treeview">
      	<%} %>
          <a href="#"><i class="fa fa-file"></i> <span>파일</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="file_picture.jsp">사진</a></li>
            <li><a href="file_homework.jsp">과제</a></li>
            <li><a href="file_insert.jsp">파일 올리기</a></li>
          </ul>
        </li>
        <%if(menuName.equals("comments")){%>
      	<li class="active">
      	<%}else{ %>
      	<li class="">
      	<%} %>
        <a href="comments.jsp"><i class="fa fa-comments"></i> <span>댓글</span></a></li>
        <%if(menuName.equals("user")){%>
      	<li class="treeview active">
      	<%}else{ %>
      	<li class="treeview">
      	<%} %>
          <a href="#"><i class="fa fa-users"></i> <span>사용자</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="/admin/listuser.do?select=0">모든 사용자</a></li>
            <li><a href="user_payment.jsp">결제 대기 중인 사용자</a></li>
          </ul>
        </li>
        <%if(menuName.equals("admin")){%>
      	<li class="treeview active">
      	<%}else{ %>
      	<li class="treeview">
      	<%} %>
          <a href="#"><i class="fa fa-lock"></i> <span>관리자</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="admin_all.jsp">모든 관리자</a></li>
            <li><a href="admin_profile.jsp">나의 프로필</a></li>
            <li><a href="admin_insert.jsp">관리자 추가</a></li>
          </ul>
        </li>
      </ul>
      <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
  </aside>