<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.min.domain.LectureCategory"%>
<%@page import="com.min.domain.Lecture"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<Lecture> lecturelist = (List) request.getAttribute("lecturelist");
	HashMap<String, String> categoryValues = (HashMap) request.getAttribute("categoryvalues");

	out.print(lecturelist);
	out.print(categoryValues);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
.lectureTitle1 {
	width: 200px;
}

.lectureTitle2 {
	width: 500px;
}

.stamp {
	width: 50px;
}
</style>

</head>
<body>

	<section>
		<a href="/lecture/index.do"><input type="button" value="Back"
			id="btnBack"></a>
		<h1><%=categoryValues.get("title")%></h1>
	</section>
	<section>
		<div>
			<div>
				<img class="lectureTitle1"
					src="http://cfile209.uf.daum.net/image/26738E4455545EB41B36EA">
			</div>
			<div>
				<img class="lectureTitle2"
					src="http://cfile27.uf.tistory.com/image/111B683E4D9BC94F3AC3D4">
			</div>
		</div>
	</section>

	<section>

		<%
			for (int a = 0; a < lecturelist.size(); a++) {

				Lecture lecture = lecturelist.get(a);
				int lecture_id = lecture.getLecture_id();
				int lectureNum = a + 1;
		%>
		<div>
			<div>
				<a
					href="/lecture/player.do?lecture_id=<%=lecture_id%>&title=<%=categoryValues.get("title")%>&lectureNum=<%=lectureNum%>"><img
					class="lectureTitle1"
					src="http://wearehacker.com/files/attach/images/42791/661/013/b09f88835e80326583d424da366bb040.gif"></a>
			</div>
			<div>
				<ul>
					<li>목차 : <%=lectureNum%>강
					</li>
					<li>주제 : <%=lecture.getTitle()%></li>
					<li>개발환경 : <%=categoryValues.get("ide")%></li>
					<li>내용 : <%=lecture.getContent()%></li>
					<%-- <li>관련 태그 : <%=lecture.get %></li> --%>
				</ul>
			</div>
			<div>
				<div>
					<img class="stamp"
						src="http://image.shutterstock.com/display_pic_with_logo/450076/141568954/stock-vector-vector-completed-stamp-141568954.jpg">
				</div>
				<div>취득점수(7/10)</div>
			</div>
		</div>
		<%
			}
		%>

	</section>
</body>
</html>