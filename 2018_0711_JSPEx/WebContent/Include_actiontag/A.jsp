<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">

p{

color :red;

}

</style>



</head>
<body>
####################<br>
<p>여기는 A영역입니다.</p>
####################<br>
<!-- 아래방식의 jsp 생성은 별개 클래스로 생성되서 작업되므로 A와 B가 같은 변수를 공유해서 사용할 수 없으나 directive방식은 변수를 공유해서 쓸수있다. -->
<!-- 두개의 서블릿으로 생성된다. -->

<jsp:include page="B.jsp"></jsp:include>


</body>
</html>