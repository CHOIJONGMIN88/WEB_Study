<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- javabean : 아래와 같은방법으로 생성된 객체  -->


<!--  p.setName("일길동"); -->
<!--  아래와같이 property 속성을 호출하게 되면 getter,setter를 호출하게 되어있다. -->

<jsp:useBean id="p" class="vo.PersonVo"></jsp:useBean><!-- PersonVo vo=new PersonVo()와같다 -->
<jsp:setProperty property="name" name="p" value="일길동 "/><!-- PersonVo의객체의 name에 일길동을 넣는다. -->
<jsp:setProperty name="p" property="age" value="20"></jsp:setProperty>
<jsp:setProperty name="p" property="tel" value="010-22-1111"></jsp:setProperty>

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