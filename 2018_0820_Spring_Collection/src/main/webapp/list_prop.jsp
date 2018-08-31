<%@page import="java.util.Properties"%>
<%@page import="myutil.MyProp"%>
<%@page import="java.util.Set"%>
<%@page import="myutil.MySet"%>

<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%

	WebApplicationContext wc= 
		WebApplicationContextUtils.getWebApplicationContext(application);
	//톰캣상의 application 영역의 일부를 spring이 사용하여 공간을 가져온다.
	
	//MySet 객체 정보 얻어오기
	MyProp myprop = wc.getBean("myPropBean",MyProp.class);
	//생성된 mysetbean을 MySet.class로 형변환 해서 얻어온다
	Properties prop = myprop.getProp();
	
	pageContext.setAttribute("prop",prop);
	//EL을 사용하기 위한 바인딩
	
	
%>    
    
  MySet's set정보
  <hr>
  <ul>
  	<c:forEach var="sido" items="${prop}">
  		
  		<li>${sido}</li>
  		 	 	
  	</c:forEach>
  </ul>
  
  
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>