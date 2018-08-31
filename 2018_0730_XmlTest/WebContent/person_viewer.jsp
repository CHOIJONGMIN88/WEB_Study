<%@page import="vo.PersonVo"%>
<%@page import="util.PersonXMLParser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<%
    List<PersonVo> list = PersonXMLParser.getPersonList();
	pageContext.setAttribute("list",list);
	//pageContext가 어떻게해서 html 페이지로 넘어오는지??
%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" align="center">
	<caption>::::::XML Parsing할 결과(Person목록:::::</caption>
	<tr>
		<th>이름</th>
		<th>별명</th>
		<th>나이</th>
		<th>휴대전화</th>
		<th>집전화</th>
	</tr>

<c:forEach var="vo" items="${list}">
	<tr>
		<td>${vo.name}</td>
		<td>${vo.nickname}</td>
		<td>${vo.age}</td>
		<td>${vo.tel}</td>
		<td>${vo.hometel}</td>
	
	</tr>
</c:forEach>



</table>

</body>
</html>