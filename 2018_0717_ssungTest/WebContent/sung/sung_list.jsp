<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

	caption{
	
		font-size: 20pt;
		font-weight:bold;
		text-shadow: 1px 1px 1px black;
		color:green;
	}
	
	td{
	text-align : center;
	
	}
	
	div{
	width:500px;
	border:1px solid blue;
	
	}
	table{
	width:100%;
	}
	

</style>
<script type="text/javascript">
function del(idx){
	alert(idx+'삭제');
	if(confirm('정말 삭제하시겠습니까?')==false)return;
	
	location.href='delete.do?idx=' + idx;
	
}
//
function modify_form(idx){
	//수정폼 띄우기
	
	location.href='modify_form.do?idx=' + idx;
	
	
}






</script>


</head>
<body>
<div>
<span><input type="button" value="등록하기" onclick="location.href='sung_insert_form.jsp'"></span>
	<table border="1" align="center">
		<caption>:::::성적관리::::::		</caption>
		<!-- 타이틀 -->
		<tr>
			<th>번호 </th>
			<th>이름 </th>	
			<th>국어 </th>	
			<th>영어 </th>	
			<th>수학 </th>	
			<th>총점 </th>	
			<th>평균 </th>		
			<th>등수 </th>	
			<th>비고 </th>	
		</tr>
	
		<!-- 데이터 -->
		<!--  for(Sungvo sung:list) 동일 -->
		<c:forEach var="sung"  items="${list}">
		<tr>
			<td>${sung.idx}</td>
			<td>${sung.name}</td>
			<td>${sung.kor}</td>
			<td>${sung.eng}</td>
			<td>${sung.mat}</td>
			<td>${sung.tot}</td>
			<td>${sung.avg}</td>
			<td>${sung.rank}</td>
			<td>
				<input type="button" value = "수정" onclick ="modify_form('${sung.idx}');">
				<input type="button" value = "삭제" onclick="del('${sung.idx}');">
			
			</td>
		
		</tr>
		</c:forEach>
	</table>
</div>


</body>
</html>