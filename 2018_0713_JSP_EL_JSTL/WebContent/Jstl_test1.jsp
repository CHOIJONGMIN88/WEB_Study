<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- JSTL을 이용하기 위해 아래와 같이 첫번째로 연결해준다 -->
<!-- libraries에  taglibs-standard-impl.2.5가 안에 있어야 한다.-->
<!-- prefix=는 마음대로 사용하면 안되고 c는 core lib이고ㅗ fmt는 format기능을 의미한다.-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%

	int money =123000000;
	
	
	Date today  = new Date();
	
	pageContext.setAttribute("money",money);
	pageContext.setAttribute("today",today);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

내가 갖고싶은 돈:<fmt:formatNumber value="${money}"/><br>
현재 날짜 : <fmt:formatDate value="${today}" pattern="YYYY년MM월 dd일"/><br>

<!-- for(int i=1;i<=5;i++) 이와같이 동작한다. -->
<c:forEach var="i" begin="1" end="5" step="2">
	<!-- 홀수면 빨강 짝수면 그린 -->
	<c:if test="${i%2==1}">	
	
	<font color=red>
	안녕<br>
	</font>
	</c:if>
	
	<c:if test="${i%2==1}">	
	<font color=green>
	안니용<br>
	</font>
	</c:if>

</c:forEach>

<c:forEach var ="i" begin ="1" end="5">

	<c:choose>
		<c:when test="${ i mod 2 eq 1 }">
			<font color=red>안녕(${ i })</font>
		</c:when>
	
		<c:when test="${ i mod 2 eq 0 }">
			<font color=green>안녕(${ i })</font>
		</c:when>
	</c:choose>
</c:forEach>



</body>
</html>