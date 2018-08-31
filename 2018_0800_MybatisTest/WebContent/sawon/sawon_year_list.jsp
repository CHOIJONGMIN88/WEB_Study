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
<hr>
입사년도별 사원목록
<hr>
<ol>
   <c:forEach var="sa2" items="${ list }">
		   <li>${ sa2.hire_year }
		       <ul>
		          <c:forEach var="sa" items="${ sa2.sa_list }">
		             <li>${ sa.sabun } : ${ sa.saname }(${ sa.sahire })</li>
		          </c:forEach>
		       </ul>
		   </li> 
   </c:forEach>
</ol>




</body>
</html>