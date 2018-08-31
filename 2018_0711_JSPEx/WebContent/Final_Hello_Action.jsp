<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
    <%

//Next_Hellow_Action에서 받은 데이터 수신
   String final_result = (String)request.getAttribute("final_result");
   String final_test_result = (String)request.getAttribute("final_test_result"); 
   //object 타입으로 request에 넘어오므로 업캐스팅을 해줘야 한다.
   //request는 jsp의 내장객체이다.

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type = "text/css">
p{
 font-size: 25pt;
 color:blue;
 text-shadow: 2px 2px 2px black;
 
}


</style>

</head>
<body>

	
	  <p>${ result }</p><br> 
	 <p>${ test_result }</p><br>  
	
	<%--  <p>${ final_result }</p><br> 
	 <p>${ final_test_result }</p><br>   --%>

HellowAction 에서 넘어온 값과 Next_HellowAction에서 변경된 값이 Final_Hello_Action 으로 출력된다.<br>

<%-- <p><%=final_result %>   </p><br>

<p><%=final_test_result %>   </p><br> --%>


</body>
</html>