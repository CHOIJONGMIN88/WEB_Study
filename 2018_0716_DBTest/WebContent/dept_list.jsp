<%@page import="vo.DeptVo"%>
<%@page import="java.util.List"%>
<%@page import="dao.SawonDao"%>
<%@page import="service.DBService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	//부서목록 가져오기
	List<DeptVo>dept_list = SawonDao.getInstance().selectList();
	//List<DeptVo> dept_list=new DeptDao().selectList();
	System.out.println(dept_list.size());
	out.print(dept_list.get(0).getDeptno() + " " + dept_list.get(0).getDname());
	
	//detp_list를 EL로 표현=>Scope 내에 있어야....
	pageContext.setAttribute("dept_list",dept_list);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" align="center" width="400">
<caption> :::::::::부서목록 ::::::::::::</caption>
 <tr>
 	<th>부서번호 </th>
 	<th>부서명</th>
 	<th>위치</th>
 	</tr>
 	
 	<!--  데이터 	-->
 	<!--  for(DeptVo dept:dept_list) -->
 	<c:forEach var="dept" items="${dept_list}">
 	<tr>
 		<td>${dept.deptno}</td>
 		<td>${dept.dname}</td>
 		<td>${dept.loc}</td>
 	</tr>
 	</c:forEach>

</table>



</body>
</html>