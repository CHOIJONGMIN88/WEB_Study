<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
		//세션영역의 user에 데이터를 넣는다.
		session.setAttribute("user","개똥이");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="movie_play.jsp">로그인 했으니까 이용해도 가능합니다.</a>

</body>
</html>