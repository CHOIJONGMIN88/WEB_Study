<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		String url = request.getRequestURL().toString();
		//System.out.println(url);
		Cookie cookie = new Cookie("B",url);
		
		//Persistant Cookie
		cookie.setMaxAge(3600*24);// 1일
		
		response.addCookie(cookie);

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 #recent_page{
 		position : absolute;
 		right:100px;
 		width:200px;
 		height:200px;
 		
 		top : 100px;
 		background-color:black;
 		color: yellow;
 }
 	a{
 		text-decoration:none;
 		color:blue;
 		font-size: 20pt;
 	}
 	a:hover {
	color : red;
}
 	
</style>
</head>
<body>
<div id="recent_page">
   <jsp:include page="cookie_list.jsp"/>
</div>

<a href="C.jsp">B page입니다..... </a>


</body>
</html>