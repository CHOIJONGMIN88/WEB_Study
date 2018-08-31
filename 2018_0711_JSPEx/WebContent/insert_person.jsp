<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
 //Insert here : Java Code
 //0.순위 : 수신인코딩 설정,post방식을 사용할 경우 무조건 인코딩을 설정해주어야 한다.
 //request,response,out,session
 //pageContext,application,out <---서블릿에 사용하지만 jsp에도 내장객체로 가지고있다.
 request.setCharacterEncoding("utf-8");


//parameter 수신
//insert_person.jsp?name=홍길동&age=20&tel=010-111-1111
 String name    = request.getParameter("name");
 String str_age = request.getParameter("age");
 int age        = Integer.parseInt(str_age);
 String tel 	= request.getParameter("tel");
 
 
 PersonVo vo = new PersonVo(name,age,tel);
 

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<caption>::::::입력된 정보::::::</caption>
	<tr> 
		<th> 이름 </th>
			<td><%=name%></td>
	<tr>
	
	<tr> 
		<th> 나이 </th>
			<td><%=age%></td>
	<tr>
	
	<tr> 
		<th> 전화번호 </th>
			<td><%=tel%></td>
	<tr>
	
	

</table>


</body>
</html>