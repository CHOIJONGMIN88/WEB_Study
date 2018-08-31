<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="vo.PersonVo" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//EL(Expression Language):표현언어
	//형식)  ${변수 or 수식}
	//1.변수는 각 Scope내에 저장된 변수만 사용할 수 있다. 
			//1.(pageContext,request,session,application)
			//2.파라메터변수도 사용할 수 있다. 
			//이렇게 선언하면 scope영역에 저장되않으므로 사용할 수없다.
	String msg = "반갑습니다."; 
	//저장:setAttribute("key",value);
	//읽기:getAttribute("key")
	//삭제:removeAttribute("key")
	//페이지 스코프로 선언해야 EL언어로 사용할수있다.(스코프 영역에 사용할 수 있으므로)
	//EL은 오직 읽기위한 언어이다. 가공이나 수정은 불가능하다.
	pageContext.setAttribute("msg",msg);
	//session.setAttribute("msg",msg); 세션영역에도 사용이 가능하다.
	
	
	
	//Map 방식
	Map map = new HashMap();
	
	map.put("driver","oracle.jdbc.driver.OracleDriver");
	map.put("url","jdbc:oracle:thin:@localhost:1521:xe");
	map.put("user","scott");
	map.put("pwd","tiger");
	
	
	
	//PerstonVo객체 생성
	PersonVo p = new PersonVo("일길동",33,"010-111-1234");
	//배열로 선언
	PersonVo [] p_array={
			 new PersonVo("일길동",33,"010-111-1234"),
			 new PersonVo("일길동",33,"010-111-1234")		
	};
	
	
	pageContext.setAttribute("msg,",msg);
	pageContext.setAttribute("map",map);
	pageContext.setAttribute("p",p);
	pageContext.setAttribute("p_array",p_array);
	
	
	
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	msg: ${pageScope.msg}<br>
	<!-- 정확한 표현 -->
	msg: ${msg}<br>
	<!-- 간결한 표현 -->

	msg:${msg}<br>
	
	<hr>
	DB접속정보(map data출력)
	<hr>
	Driver: ${ pageScope.map.driver }<br>	
	Url   : ${map['url']}<br>
	User  : ${map["user"]}<br>
	Pwd   : ${map.pwd}<br>
	//map 사용법의 4가지 표현법 

<hr>
	PersonVo's Data
<hr>

이름 : ${pageScope.p.name}<br><!-- p.getName() call을 내부적으로 호출한다. -->
나이 : ${p['age'] }<br>
전화 : ${p.tel}<br>

<hr>
	PersonVo's Array
<hr>
1번째 사람 정보 <br>
이름: ${p_array[0].name}<br>
나이: ${p_array[0].age }<br>	
전화: ${p_array[0].tel }<br>	



</body>
</html>