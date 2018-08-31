<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" align="center">
   <caption>::::부서목록::::</caption>
   <tr>
   		<th>부서번호</th>
   		<th>부서명</th>
   		<th>위치</th>
   </tr>
   
   <c:forEach var="vo" items="${ list }">
	   <tr>
	   		<td>${ vo.sabun }</td>
	   		<td>${ vo.saname }</td>
	   		<td>${ vo.sajob }</td>
	   </tr>
	</c:forEach>   
   
</table>


</body>
</html>