<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

JSP 내에서만 사용가능

<hr>
역슬러시를 앞에 선언해줄경우 계산식으로 인식하지 않는다.
\${1+2} = ${ 1+2 } <br>
\${1-2} = ${ 1-2 } <br>
\${1*2} = ${ 1*2 } <br>
\${1/2} = ${ 1/2 } <br>
\${1%2} = ${ 1%2 } <br>
\${10/2} = ${10/2} or ${10 div 2}<br>
\${10/3} = ${10%3} or ${10 mod 3}<br>

##비교연산자##
\${2==2} = ${2==2} or ${ 2 eq 2 }<br>
\${3>2} = ${3>2} <br> 
\${3>=2} =${3>=2}<br>
\${3>=2} =<%=3>=2%> 

</body>
</html>