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

<table border="1">
   <caption>::::사원목록::::</caption>
   <!-- 타이틀 -->
   <tr>
   		<th>사번</th>
   		<th>이름</th>
   		<th>직위</th>
   		<th>성별</th>
   		<th>부서번호</th>
   		<th>입사일자</th>
   		<th>상사번호</th>
   		<th>년봉</th>
   </tr>   
   
   <!-- 데이터 -->
   <c:forEach var="vo"  items="${ list }">
	   <tr>
	   		<td>${ vo.sabun }</td>
	   		<td>${ vo.saname }</td>
	   		<td>${ vo.sajob }</td>
	   		<td>${ vo.sasex }</td>
	   		<td>${ vo.deptno }</td>
	   		<td>${ vo.sahire }</td>
	   		<td>${ vo.samgr }</td>
	   		<td>${ vo.sapay }</td>
	   </tr>
	</c:forEach>
	
</table>


</body>
</html>






