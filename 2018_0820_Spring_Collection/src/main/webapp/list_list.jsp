<%@page import="myutil.MyList"%>
<%@page import="java.util.List"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
WebApplicationContext wc = 
	WebApplicationContextUtils.getWebApplicationContext(application);

 	

	MyList mylist = wc.getBean("myListBean",MyList.class);

	List list= mylist.getList();
	
 	
 	pageContext.setAttribute("list",list);
	


%>



 MySet's set정보
  <hr>
  <ul>
  	<c:forEach var="sido" items="${list}">
  		
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