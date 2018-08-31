<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<link rel = "stylesheet" href="css/main.css">
<link rel = "stylesheet" href="css/menu.css">


</head>
<body>
회사소개 CUSTOMER 페이지.
	<div id= "main_box">

	<div id="header">
		<%@include file="header/header.jsp" %>
	</div>
	<div id="aside">
	<%@include file="menu/submenu_customer.jsp" %>
	</div>
	<div id="content">
	
	 <c:if test="${empty param.c ||param.c eq 'child'}">	
			<%@include file="contents/customer/child.jsp"%>
		
		</c:if>
		
		<c:if test="${param.c eq 'boy'}">	
			
			<%@include file="contents/customer/boy.jsp"%>
		</c:if>
		
		<c:if test="${param.c eq 'senier'}">	
	
			<%@include file="contents/customer/senier.jsp"%>
		</c:if>
	
	</div>
	
	
	<div id="footer"></div>
		<%@include file="footer/footer.jsp"%> 
	
	</div>

</body>
</html>