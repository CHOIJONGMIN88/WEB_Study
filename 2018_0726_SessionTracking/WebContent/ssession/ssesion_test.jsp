<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//내장객체를 이용해서 세션 id를 가져온다. 	
String session_id = session.getId();
//request를 이용해서 Session id정보를 획득
HttpSession my_session = request.getSession();

//지속시간 설정	지속시간 1분설정. 1분후에 세션 자동 폐기 
session.setMaxInactiveInterval(60);

%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>