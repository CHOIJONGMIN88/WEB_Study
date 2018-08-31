<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

//초기화 이벤트
window.onload=function(){
	
	
	setTimeout("error_msg();",300);
	
};

function error_msg(){
	//member/login_form.do?reason=fail_id
	if('${ param.reason }'=='fail_id'){
		alert('아이디가 틀립니다zzzzz');
	}
	
	//member/login_form.do?reason=fail_pwd
	if('${ param.reason }'=='fail_pwd'){
		alert('비밀번호가 틀립니다zzzz');
	}
}






function send(f){
	
	var id  = f.id.value;
	var pwd = f.pwd.value;
	
	if(id==''){
		alert('아이디를 입력하세요');
		f.id.focus();
		return;
	}
	
	if(pwd==''){
		alert('비밀번호를 입력하세요');
		f.pwd.focus();
		return;
	}
	
	f.method='POST';
	f.action = 'login.do';// MemberLoginAction
	//          login.do?id=hong&pwd=1234
	f.submit();

	
}


</script>

</head>
<body>
<!-- 여기에 로그인 폼 작성(테이블) -->
<form>
	<input type="hidden"  name="url" value="${ param.url }">
	<table border="1" align="center">
	    <caption>::::로그인::::</caption>
		<tr>
			<th>아이디</th>
			<td><input name="id"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button"  value="로그인" 
				       onclick="send(this.form);">
				<input type="button"  value="회원가입" 
				       onclick="location.href='insert_form.do'">
			</td>
		</tr>
		
	</table>
</form>

</body>
</html>

