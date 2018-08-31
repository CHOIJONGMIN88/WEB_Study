<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//현재 도메인이름에 저장된 쿠키정보를 모두 읽어오기(네이버는 네이버기준,다음이면 다음 도메인 기준으로 읽어온다.)

  Cookie[] cookies= request.getCookies(); //쿠키값을 배열로 받아온다.
  	StringBuffer sb = new StringBuffer("[최근 방문 사이트]<br>");
  if(cookies!=null){
  
  	for(Cookie cookie:cookies){
  		String name=cookie.getName();
  		String value=cookie.getValue();
  		if(name.equals("JSESSIONID")==false){//세션 아이디만 제외 후에 출력 쿠키는 [키:데이터] 구조로 되어있다. 
  			System.out.printf("[%s]:%s\n",name,value); 	
  		/* 	
  		sb.append("<a href='");
  			sb.append(value);
  			sb.append("'>");
  			sb.append(name);
  			sb.append("</a><br>"); */
  		
  			sb.append(String.format("<br><a href='%s'>%s</a><br>",value,name));
  		}
  	}	
  			response.setContentType("text/html; charset=utf-8");
  			response.getWriter().print(sb.toString()); 	
  	}




%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>