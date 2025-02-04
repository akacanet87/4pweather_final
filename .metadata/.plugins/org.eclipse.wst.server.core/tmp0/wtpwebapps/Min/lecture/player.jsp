<%@page import="com.min.domain.MyQuestion"%>
<%@page import="java.util.List"%>
<%@page import="com.min.domain.Lecture"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Lecture lecture = (Lecture) request.getAttribute("lecture");
	HashMap<String, String> lectureValues = (HashMap) request.getAttribute("lecturevalues");

	List<MyQuestion> questionList = (List) request.getAttribute("questionList");

	String title = request.getParameter("title");
	int lecture_id = Integer.parseInt(request.getParameter("lecture_id"));
	int lectureNum = Integer.parseInt(request.getParameter("lectureNum"));
	out.print(lecture+"<br>");
	out.print(lectureValues+"<br>");
	out.print(title+"<br>");
	out.print(lecture_id+"<br>");
	out.print(lecture.getTitle()+"<br>");
	out.print(lecture.getLecture_id()+"<br>");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://player.vimeo.com/api/player.js"></script>
<script>

	$(function() {
		
		$("#form1.sendQuestion").click( function() {
			
			if (!confirm('등록하시겠습니까?'))
			
				return;
		
			var myquestion_content = $('#form1.content').val();
			var lecture_id = $('#form1.lecture_id').val();
			var member_id = $('#form1.member_id').val();
			var json = {
					
				"content" : myquestion_content,
				"lecture_id" : lecture_id,
				"member_id" : member_id

			}
					
			$.ajax({
				
				url : '/myquestion/registQuestion.do',
				type : 'post',
				contentType : 'application/json; charset=utf-8',
				dataType : 'json',
				data : JSON.stringify(json),
				success : function(data) {
					
					alert(JSON.stringify(data));
				
					$('#form1.showQList').prepend(

						'<li><div><h3>나의 질문내용 </h3><p>'+ data.content
						+ '</p></div><div style="display:none;"><h3>답변</h3><p id="reply_'+data.myquestion_id+'"></p></div></li>');
							
					$('#form1.content').val('');
				
				}
				
			});

		})
		
	})

	$(function() {

		$("#form1.registHomework").click(function() {
			
			if (!confirm('등록하시겠습니까?'))
				
				return;
			
			var formData = new FormData();
			var file = this.files[0];                      //multiple 속성이 있으면 files 에는 다수의 객체가 할당됨
			formData.append("homework", file);

			$.ajax({

				async : true,
				method : 'post',
				url : '/member/sendHomework.do',
				processData : false,
				data : formData,
				contentType : false,
				success : function(data) {
					
					alert("일단 요까지 "+data);
				
				}

			});
			
		})
		
	})

	function registHomework() {

		form1.encoding = "multipart/form-data";
		form1.action = "/";

	}
</script>

</head>
<body oncontextmenu="return false">
	<form enctype="multipart/form-data" name="form1" method=post>
		<section>
			<h1><%=title%>
				<%=lectureNum%>강
			</h1>
		</section>
		<section>

			<div>
				<iframe name="player" id="player"
					src="http://player.vimeo.com/video/79750862?fullscreen=1&autoplay=1&loop=0'"
					width="100%" height="100%" frameborder="0" webkitallowfullscreen
					mozallowfullscreen allowfullscreen hidefocus="true"></iframe>
			</div>

		</section>
		<section>
			<div>
				<a>자료 다운 받는 곳</a>
			</div>
			<div>
				<input type="file" name="lectureFile" placeholder="과제 첨부하는 곳"> <input
					type="button" value="등록" id="registHomework" name="myFile">
			</div>
		</section>
		<section>
			<div>나의 질문 게시판</div>
			<div>
				<input type="text" id="content" name="content"
					placeholder="강사님께 드릴 질문을 입력하세요"> <input type="button"
					value="등록" id="sendQuestion"> <input type="hidden"
					id="lecture_id" value="<%=lecture_id%>"> <input
					type="hidden" id="member_id" value="1">
			</div>
		</section>
		<section>
			<ul id="showQList">

				<%
					for (int a = 0; a < questionList.size(); a++) {
				%>
				<li>
					<%
						MyQuestion myQuestion = questionList.get(a);
							int myQuestion_id = myQuestion.getMyquestion_id();
							String content = myQuestion.getContent();
							String replyer = myQuestion.getReplyer();
							String reply = myQuestion.getReply();
					%>
					<div>
						<h3>나의 질문내용</h3>
						<p><%=content%></p>
					</div> <%
								 	if (replyer == null) {
								 %>
					<div style="display: none;">
						<%
							} else {
						%>
						<div style="display: block;">
							<h3>답변</h3>
							<p id="reply_<%=myQuestion_id%>"><%=reply%></p>
						</div>
						<%
							}
						%>
					
				</li>
				<%
					}
				%>
			</ul>
		</section>
	</form>
</body>
</html>