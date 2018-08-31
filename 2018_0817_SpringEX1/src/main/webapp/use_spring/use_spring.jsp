<%@page import="vo.PersonVo"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

 //1.Spring Container 정보를 구하기(bean이 등록된 영역정보)
 	//스프링이 어플리케이션 영역에서 빌려온 공간에 들어있는데 객체정보를 가져온다.
	WebApplicationContext  wc = 
     WebApplicationContextUtils.getWebApplicationContext(application);
  
	//등록된 PersonVo정보를 얻어오기
	//모든영역에는 자바의 모든객체를 저장할 수 있지만 읽어오는 경우에는 어떤타입인지 알 수 없으므로 오브젝트타입으로 반환하기때문에 캐스팅을 해주어야한다.
		PersonVo p1=(PersonVo)wc.getBean("p1");
		PersonVo p2=(PersonVo)wc.getBean("p2");
 
 		PersonVo p3= wc.getBean("p3",PersonVo.class);
		//해당방식으로도 사용할 수 있다. 
		 //현재 pageContext등록=>EL사용하려구?
 		pageContext.setAttribute("p1", p1);
  		pageContext.setAttribute("p2", p2);
%>

 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Spring이 생성해준 객체 정보를 출력할것이다.


<hr>
 Spring이 생성해준 객체정보 
<hr>    
p1's info
<hr>
name : ${ p1.name }<br>
age  : ${ p1.age }<br>
tel  : ${ p1['tel'] }<br>


<hr>    
p2's info
<hr>
name : ${ p2.name }<br>
age  : ${ p2.age }<br>
tel  : ${ p2['tel'] }<br>
   

</body>
</html>