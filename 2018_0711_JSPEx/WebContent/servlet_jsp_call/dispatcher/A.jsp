<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	System.out.println("--Dispatcher : a.jsp Call--");
	// Dispatcher할 대상지정
	RequestDispatcher disp=request.getRequestDispatcher("B.jsp");
	//지정된 Dispatcher로 foward시킨다.
	//현재 객체가 전달받은 request,response를 그대로 넘겨줍니다.
	disp.forward(request,response);


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