<%@page import="com.sds.model.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	
	//	저장된 결과 꺼내보기
	Member member = (Member) request.getAttribute("member");

%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
결과
아이디 		: <%=member.getId() %>
비밀번호 	: <%=member.getPassword() %>
보유재산 	:
보유차량 	:
업로드 파일명 	: <%=member.getMyFile().getOriginalFilename() %>
<img src="/data/<%=member.getMyFile().getOriginalFilename()%>">
</pre>
</body>
</html>