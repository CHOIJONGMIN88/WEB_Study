<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
 <% 
 
 	//배열
 	String[] sido_array ={"서울","경기","인천","강원","대전"};
 	//JSTL내에서 데이터 표현형식은 EL
 	//EL은 각 Scope or parameter에 있는 값만 표현
 	
 	List<PersonVo> p_list = new ArrayList<PersonVo>();
 	p_list.add(new PersonVo("일길동",11,"010-111-222"));
 	p_list.add(new PersonVo("이길동",22,"010-111-222"));
 	p_list.add(new PersonVo("삼길동",22,"010-111-222"));
 	pageContext.setAttribute("sido_array",sido_array);
 	pageContext.setAttribute("p_list",p_list);
 
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<hr>
 배열 출력하기
<hr>
<ul>
<!--  	forEach는 개선된 for문처럼 동작한다. -->
<c:forEach var="sido" items="${pageScope.sido_array}">

	<li>${sido}</li>

</c:forEach>
</ul>

<hr>
ArrayList 출력하기
<hr>
<table border ="1"><caption>

:::::::::개인정보:::::::::
</caption>

<!--  타이틀   -->

<tr>
	<th>번호</th>
	<th>이름</th>
	<th>나이</th>
	<th>전화</th>
</tr>
<!--  for(PersonVo p:p_list) 와 같다 -->
<!--  varStatus 객체 : 반복 index정보를 관리하는 객체  객체로 되어있으며 한번 순환할때마다 1씩 증가한다.-->
<c:forEach var="p" items="${p_list}" varStatus="i">
	<tr>
		<td>${i.index+1}</td>
		<td>${p.name}</td>
		<td>${p['age']}</td>
		<td>${p.tel}</td>
	</tr>
</c:forEach>





</table>







</body>
</html>