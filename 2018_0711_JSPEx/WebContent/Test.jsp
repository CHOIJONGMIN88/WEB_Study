<%@ page import = "java.util.Calendar,java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! 
//선언부 :클래스전환시 멤버변수 or 멤버메소드
int count=0;
%>    
    
<%
//script let=> 여기에 자바코드를 작성할 수 있다.
//jsp->servlet변환과정에 _jspservice()내에 포함되어 실행된다.
// script let내에 코드는 servlet의 jspService() 변환되서 실행된다. 
// contentType="text/heml";charset=UTF-8 <---servlet에 의해 jsp가 class로 변환될때 인코딩값이 이값으로 들어간다.
// import의 crtl+space 기능이 jsp에서는 먹질 않는다.

Calendar c = Calendar.getInstance();
Random rand=new Random();
String ip=request.getRemoteAddr(); //요청자 IP
out.println("요청자IP:"+ ip);
count++;

out.println(String.format("[%d]번째 방문자입니다.",count));

%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

th{
	background-color :black;
	color :white;
}

td{
	background-color: #aaaacc;
	color: blue;

}

</style>

</head>
<body>

	<table border='1'>
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="30%">작성자</th>
			<th width="20%">조회수</th>
		</tr>
	
		<tr>
			<td>1</td>
			<td>JSP란?</td>
			<td>홍길동</td>
			<td>1</td>
		</tr>
		
			<tr>
			<td>2</td>
			<td>JSP가 Servlet이라며?</td>
			<td>이길동</td>
			<td>10</td>
		
		</tr>
	
	
	
	</table>



</body>
</html>