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
	
	
	var title = f.title.value;
	var photo = f.photo.value;
	if(title=''){
		
		alert('제목을 입력하세요');
		f.title.focus();
		return;
	}
	
	if(photo==''){
		alert('업로드할 화일을 선택하세요');
		return;
	}
	
	f.action='upload.do'; //FileUploadAction
	f.submit(); //지정된 action으로 전송
	
	
}

</script>

<body>
<!-- 파일 업로드 방식은 무조건 post이고   enctype="multipart/form-data" 오타가 나게되면 업로드가 되지 않는다.-->
<form method="POST" enctype="multipart/form-data">
	제목:<input name="title"><br>
	포토:<input type="file" name="photo"><br>
		<input type="button" value="올리기" onclick="send(this.form);">
	
</form>

</body>
</html>