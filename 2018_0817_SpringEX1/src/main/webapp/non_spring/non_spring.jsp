<%@page import="vo.PersonVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	//객체생성 방법1
	PersonVo p1 = new PersonVo("일길동",30,"010-111-1111"); 

	//객체 생성 방법 
	PersonVo p2 = new PersonVo();
	p2.setName("이길동");
	p2.setAge(22);
	p2.setTel("010-222-1234");

	pageContext.setAttribute("p1",p1);
	pageContext.setAttribute("p2",p2);
%>

스프링이 제일먼저 web.xml이 가장먼저 시작된다.

 listener-class 태그 내의 인터페이스가 context-param 내의 경로의 xml 파일을 가지고 객체를 생성한다.
(param-value태그내의 환경설정파일 경로가 존재 하지 않을경우 listener-class 태그내의 인터페이스가
 /web-inf/applicationContext.xml 파일을 자동으로 찾는다. 	)



p1's info
<hr>
name:${p1.name}<br>
age:${p1.age}<br>
tel:${p1['tel']}<br>
<hr>
name:${p2.name}<br>
age:${p2.age}<br>
tel:${p2['tel']}<br>


