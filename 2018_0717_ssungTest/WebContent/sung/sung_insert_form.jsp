<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">

function send(f){
	//0~100 
	var reg_number = /^[1][0]{2}$|^[0-9]{1,2}$/;

	var name = f.name.value;
	var kor = f.kor.value;
	var eng = f.eng.value;
	var mat = f.mat.value;
	
	if(name==''){
		
		alert('이름을 입력하세요');
		f.name.value='';
		f.name.focus();
		return;
	}
	
	if(reg_number.test(kor)==false){
		alert('0~100사이의 숫자만 입력하세요!!');
		f.kor.focus();
		return;
	}

	if(reg_number.test(eng)==false){
		alert('0~100사이의 숫자만 입력하세요!!');
		f.eng.focus();
		return;
	}

	if(reg_number.test(mat)==false){
		alert('0~100사이의 숫자만 입력하세요!!');
		f.mat.focus();
		return;
	}

	f.action ="insert.do";
	f.submit(); //서버로 전송	
	

}

</script>


<form>
	<table border="1" align="center">
		<caption>::::::성적등록::::::::</caption>
	<tr> 
		<th>이름</th>
		<td><input name="name" value="">
	</tr>
	<tr> 
		<th>국어</th>
		<td><input name="kor" value="">
	</tr>
	<tr> 
		<th>영어</th>
		<td><input name="eng" value="">
	</tr>
	<tr> 
		<th>수학</th>
		<td><input name="mat" value="70">
	</tr>
	
	
	
	
	<tr>
	
		<td colspan="2" align="center">
			<input type="button"  value="등록하기" onclick="send(this.form);">
			<input type="button"  value="목록보기" onclick="location.href='list.do'">
		</td>
	
	
	</table>
</form>

</body>
</html>