<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="800">

	<tr> 
		<th>번호</th>
		<th>제목</th>
		<th>이미지</th>		
		<th>작가</th>
		<th>설명</th>
		<th>가격</th>
		<th>총합</th>
	</tr>
<!-- for(ProductVo p : list) -->
<c:forEach var="p" items="${list}" varStatus="i">
	<tr>
		<td>${i.index}</td>
		<td><a href="">${p.title}</a></td>
		<td>
			<img width = "120" height ="80" src="${p.image}">
		</td>		
		<td>${p.author}</td>
		<td>${p.description}</td>
		<td>${p.price}</td>
		<td>${p.total}</td>

		
	</tr>
</c:forEach>

</table>




</body>
</html>