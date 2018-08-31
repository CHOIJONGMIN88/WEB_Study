<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
#main_Box{
width: 800px;
margin: auto;
}

#main_box>h1{
 text-align:center;
 font-size:60pt;
 text-shdow:2px 2px 2px blue;
 color :pink;
}

.th{

margin: auto;
 text-align:center;
 background :sky;
 font-size:25pt;
 color:pink;
}

.td{
 text-align:center;
 font-size:15pt;
 color:green;
}

table{
width:100%
}

</style>



</head>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">


function modify(f,p){

	var idx=f;
	var pwd=p;
	
	
	location.href='update_form.do?idx=' + idx +'&pwd='+pwd;
	
	
	/* 
	$.ajax({ url:'update_form.do', 
		 data:{'idx':idx,'pwd':pwd}, 
		 success:function(data){
	
			 alert('에이잭스는일로 반환된다.');
			 포워드가 되지 않는다.
			 }
			 
		 });		 */	

	//	f.action = 'insert.do'; //VisitInsertAction 

	
}



</script>



<body>

<div id="main_box">
	<h1>:::::::회원목록:::::::</h1>
		<div> 
		<input type="button"  style="WIDTH: 120pt; 
							  HEIGHT: 60pt; 
							  background:yellow; 
							  font-size:30px; 
							  color:blue;"
 				
 				value="회원가입" onclick="location.href='insert_form.do'">
		사이즈다
		</div>
	<div>
		
		<table border="1">
			<tr class="th">
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>아이피</th>
				<th>주소</th>
				<th>우편번호</th>
				<th>가입일자</th>				
				<th>비고</th>
			</tr>
			
			<!--  회원목록이 없을경우 -->
			<c:if test="${empty list}">
				<tr>
					<td colspan ="7" align="center">가입된 회원정보가 없습니다.</td>	
				</tr>
			</c:if>
			
		<c:forEach var="vo" items="${list}">	
			<form> 
			
				<tr class="td">
				<td>${vo.idx}</td>			
				<td>${vo.name}</td>
				<td>${vo.id}</td>
				<td>${vo.pwd}</td>
				<td>${vo.ip}</td>
				<td>${vo.addr}</td>
				<td>${vo.zipcode}</td>
				<td>${vo.regdate}</td>
				<td>									
					<input type="button" value="수정하기" onclick="modify('${vo.idx}','${vo.pwd}');">
					<input type="button">
				</td>	
			</tr>				
				</form>	
			</c:forEach>
		
		
			</table>
	
		
	</div>
</div>




</body>
</html>