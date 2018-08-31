<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//0.순위: 수신인코딩 설정
request.setCharacterEncoding("utf-8");

//<jsp:useBean id="p" class=vo.PersonVo/> == PersonVo p = new PersonVo(); 와 같은 의미이다.
//<jsp:SetProperty name="p" propery="*"/> 
//<jsp:SetProperty name="p" propery="name" param="name"/> param값의 name값을 객체  p 의 속성에 있는 name의 값에 넣어준다.
%>

<jsp:useBean id="p" class="vo.PersonVo"/>
<jsp:setProperty name="p" property="name" param="name"/>

<jsp:setProperty name="p" property="age" param="age"/>

<jsp:setProperty name="p" property="name"/>
<!-- param이 생각되면 기본적으로 property name과 동일한 parameter를 읽어온다. -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<caption>:::::: 객체로 수신된 정보 ::::::</caption>
	<tr> 
		<th> 이름 </th>
			<td><jsp:getProperty property="name" name="p"/></td>
	<tr>
	
	<tr> 
		<th> 나이 </th>
			<td><%=p.getAge()%></td>
	<tr>
	
	<tr> 
		<th> 전화번호 </th>
			<td><%=p.getTel()%></td>
	<tr>
	
	

</table>


</body>
</html>