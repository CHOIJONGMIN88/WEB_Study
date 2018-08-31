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
회사소개 메인페이지
	<div id= "main_box">
	<div id="header">
		<%@include file="header/header1.jsp"%>
	</div>
	<div id="aside">
		<%@include file="menu/submenu_company.jsp" %> </div>
	<div id="content">
		<c:if test="${empty param.m ||param.m == 'intro'}">	
			<%@include file="contents/company/intro.jsp"%>
		
		</c:if>
		
		<c:if test="${param.m == 'history'}">	
			
			<%@include file="contents/company/history.jsp"%>
		</c:if>
		
		<c:if test="${param.m == 'location'}">	
	
			<%@include file="contents/company/location.jsp"%>
		</c:if>
	
	</div>
	
	
	
	<div id="footer"></div>
		<%@include file="footer/footer.jsp" %> 
	
	</div>

</body>
</html>