<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#main_box{
	width: 800px;
	margin: auto;
}

#main_box > h1{
    text-align: center;
    font-size: 20pt;
    text-shadow: 1px 1px 1px black;
    color:white;
}

table{
   width: 100%;
}


</style>


<script type="text/javascript">
function del(idx){

	if(confirm('정말삭제 하시겠습니까')==false)return;
	
	//삭제
	location.href = 'delete.do?idx=' + idx;
	
	
}

function modify(idx){
	
	//수정
	location.href = 'modify_form.do?idx=' + idx;
	
	
}



</script>

</head>
<body>
<div id="main_box">
   <h1>::::회원목록::::</h1>
   <div>
        <input type="button" value="회원가입"  
               onclick="location.href='insert_form.do'">
        <input type="button" value="회원가입2"  
               onclick="location.href='insert_form2.do'">       
   </div>
   <div>
       <table border="1">
           <tr>
           	  <th>번호</th>
           	  <th>이름</th>
           	  <th>아이디</th>
           	  <th>비번</th>
           	  <th>아이피</th>
           	  <th>가입일자</th>
           	  <th>비고</th>
           </tr>
           
           <!-- 회원목록이 없을경우 -->
           <c:if test="${ empty list }">
           		<tr>
           		   <td colspan="7" align="center">가입된 회원정보가 없습니다</td>
           		</tr>
           </c:if>
           
           <!-- 데이터 -->
           <c:forEach var="vo"  items="${ list }">
	           <tr>
	               <td>${ vo.idx }</td>
	               <td>${ vo.name }</td>
	               <td>${ vo.id }</td>
	               <td>${ vo.pwd }</td>
	               <td>${ vo.ip }</td>
	               <td>${ vo.regdate }</td>
	               <td align="center">
	                   <input type="button" value="수정" onclick="modify('${ vo.idx}');">
	                   <input type="button" value="삭제" onclick="del('${ vo.idx}');">
	               </td>
	           </tr>
	       </c:forEach>    
           
           
           
           
       </table>
   </div>

</div>




</body>
</html>