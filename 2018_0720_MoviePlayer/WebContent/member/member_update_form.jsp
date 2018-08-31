<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">


	


function update(f){
	
	
	//전송객체 지정
	f.action ="update.do"; //MemberInsertAction => url ='/member/insert.do'
	f.submit(); //전송

}

</script>

</head>
<body>

	<form>
	<input name="idx" value="${vo.idx}" type="hidden">
		<table border="1" align="center" width="700">
			<caption> ::::정보 수정::::::</caption>
			
			
			<tr>
				<th>이름</th>
				<td><input name="name" value="${vo.name}"></td>
			</tr>
		
			<tr>
				<th>아이디</th>
				<td>
					<input name="id" id="id">
					<input type="button" value="${vo.id}">
				</td>
			</tr>				
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" value="${vo.pwd}"></td>
				
			</tr>

			<tr>
				<th>우편번호</th>
				<td>
					<input name="zipcode" id="zipcode" type="text"  value="${vo.zipcode}">
					 
			</td>	
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input name="addr" id="addr" value="${vo.addr}"style="width:98%"></td>			
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="bt_reg" value="수정하기"  onclick="update(this.form)">
					<input type="button"  value="목록보기" onclick="location.href='list.do'">
				</td>	
					
			
			</tr>
		
		
		
		</table>
	
	</form>




</body>
</html>