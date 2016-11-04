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
<link rel="stylesheet" type="text/css" href="css/style_main.css">

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
    
    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img class="first-slide" src="http://cfile5.uf.tistory.com/image/27750E4C5741FC630B817B" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <!-- 
              <h1>Example headline.</h1>
              <p>Note: If you're viewing this page via a <code>file://</code> URL, the "next" and "previous" Glyphicon buttons on the left and right might not load/display properly due to web browser security rules.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
              -->
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="http://cfile26.uf.tistory.com/image/26138341560173C2072B7B" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <!-- 
              <h1>Another example headline.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
              -->
            </div>
          </div>
        </div>
        <div class="item">
          <img class="third-slide" src="http://www6.pcmag.com/media/images/506605-ios-10-generic.jpg?thumb=y&width=740&height=426" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <!-- 
              <h1>One more for good measure.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
              -->
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->	
</header>

	