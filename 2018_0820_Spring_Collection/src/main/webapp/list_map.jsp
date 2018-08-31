<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="myutil.MyProp"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
   //Spring  Container(Spring이 생성한 객체 저장소정보)
	WebApplicationContext wc 
	  = WebApplicationContextUtils.getWebApplicationContext(application);
 
    MyProp myPropBean = wc.getBean("myPropBean",MyProp.class);
    
    Properties  prop = myPropBean.getProp();
    //Properties or Map으로부터 Set읽어온다(key집합)
    
    
    Set set  = prop.keySet();
    //속성들의 키 값을 읽어와서 set에다가 등록한다.
    
    Set set1 = new TreeSet(set);//정렬되서 출력

    pageContext.setAttribute("set", set1);
    pageContext.setAttribute("prop", prop);
    
    
%>

<hr>
  MyProp's prop info
<hr>

<c:forEach var="key"  items="${ set }">
   ${ key } : ${ prop[key] } <br>
</c:forEach>









    
    
