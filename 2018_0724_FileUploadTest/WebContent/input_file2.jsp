<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function send(f){
	
	//4가지가 전부 입력내용 확인 
	var title1 = f.title1.value;
	var photo1 = f.photo1.value;
	var title2 = f.title2.value;
	var photo2 = f.photo2.value;
	
	if(title1=''){
		
		alert('제목을 입력하세요');
		f.title.focus();
		return;
	}
	
	if(photo1==''){
		alert('업로드할 화일을 선택하세요');
		return;
	}
	
	if(title2=''){
		
		alert('제목을 입력하세요');
		f.title.focus();
		return;
	}
	
	if(photo2==''){
		alert('업로드할 화일을 선택하세요');
		return;
	}
	
	f.action='upload2.do'; //FileUploadAction2 =>upload_result2.jsp(출력) 두개 이미지 
	f.submit(); //지정된 action으로 전송

}

</script>

<body>
<!-- 파일 업로드 방식은 무조건 post이고   enctype="multipart/form-data" 오타가 나게되면 업로드가 되지 않는다.-->
<form method="POST" enctype="multipart/form-data">
	
		제목1:<input name="title1"><br>
		포토1:<input type="file" name="photo1"><br>
		제목2:<input name="title2"><br>
		포토2:<input type="file" name="photo2"><br>	
	
		<input type="button" value="올리기" onclick="send(this.form);">
</form>

</body>
</html>