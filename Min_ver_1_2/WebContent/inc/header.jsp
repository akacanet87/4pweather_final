<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" type="text/css" href="css/hyeon_style.css"> -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Carousel Theme -->
<link rel="stylesheet" type="text/css" href="../css/style.css">

<title>Insert title here</title>
</head>
<body>
<%@include file="/inc/modal.jsp"%>
<header>
	<div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#"><img alt="logo" src="/data/img/logo.png" ></a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li><a href="/lecture/index.do">온라인 강의</a></li>
                <li><a href="#">실전 프로젝트</a></li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">커뮤니티<span class="caret"></span></a>
                  <ul class="dropdown-menu" role="menu">
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">민쌤 엿보기</a></li>
                    <li><a href="#">과제 게시판</a></li>
                    <li><a href="#">프로젝트 경연</a></li>
                    <li><a href="#">IT 블로그</a></li>
                  </ul>
                </li>
                
             	</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#contact">고객센터</a></li>
					<li><a id="btnLogin">로그인</a></li>
				</ul>
			</div>
          </div>
        </nav>

      </div>
    </div>
</header>