<%@page import="vo.PersonVo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
		//Java Code insert
		List<PersonVo> p_list =new ArrayList<PersonVo>();

		p_list.add(new PersonVo("일길동",22,"010-111-1111"));
		p_list.add(new PersonVo("이길동",32,"010-211-1111"));
		p_list.add(new PersonVo("삼길동",42,"010-311-1111"));
		p_list.add(new PersonVo("사길동",52,"010-411-1111"));
		p_list.add(new PersonVo("오길동",62,"010-511-1111"));

%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border = "1" align="center" width="400">
	<caption>:::::개인정보 목록::::::</caption>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>전화</th>
	
	</tr>
	<!-- 데이터  -->
	<% 
	for(int i=0; i<p_list.size();i++){
	
		PersonVo p = p_list.get(i);
	%>
	
	
	<tr>
		<td><%= i+1 %></td>
		<td><%= p.getName() %></td>
		<td><%= p.getAge() %></td>
		<td><%= p.getTel() %></td>
	</tr>
	<% 
	}//end for
	%>

</table>


</body>
</html>