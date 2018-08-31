<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
부서별 사원별 고객 목록
<hr>
<ul>
   <c:forEach var="dept" items="${ list }">
   		<li>
   		      ${dept.deptno} : ${ dept.dname }
   		      <ul>
   		         <c:forEach var="sawon" items="${ dept.sa_list }">
   		            <li>
   		               ${sawon.deptno} : ${ sawon.saname }(${ sawon.sabun })
   		                <ul>
   		                   <c:forEach var="gogek" items="${ sawon.go_list }">
   		                       <li>${ gogek.goname }(${ gogek.godam })</li>
   		                   </c:forEach>
   		                </ul> 
   		            </li>
   		         </c:forEach>
   		      </ul>
   		</li>
   </c:forEach>
   
</ul>


</body>
</html>