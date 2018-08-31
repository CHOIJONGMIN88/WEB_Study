<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<% 
	//쿠키생성 및 저장하기
	//페이지가 떠있는동안만 유효하다.(setMagAge()가 설정되지 않으면 )
	String msg="안녕하세요";
	msg = URLEncoder.encode(msg,"utf-8");
	

	
	Cookie cookie = new Cookie("mydata",msg);
	cookie.setMaxAge(60*5); //5분
	response.addCookie(cookie);

	System.out.printf("Encoding msg: %s\n",msg);
	String msg1 = URLDecoder.decode(msg,"utf-8");
	System.out.printf("DEcoding msg: %s\n",msg1);
	

%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<a href="cookie_test2.jsp">test2</a>




</body>
</html>