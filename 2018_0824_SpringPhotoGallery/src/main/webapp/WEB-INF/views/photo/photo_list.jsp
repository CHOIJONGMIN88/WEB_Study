<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  
      href="${ pageContext.request.contextPath }/resources/css/photo.css">
      
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

/*  
    ### 자바스크립트 인코딩 ###
    ① encodeURI() / decodeURI()
    - 최소한의 문자만 인코딩합니다.
    - ; / ? : @ & = + $ , - _ . ! ~ * ' ( ) # (이런 문자들은 인코딩하지 않습니다.)
    - http:// ... 등은 그대로 나옵니다.

    ② encodeURIComponent() / decodeURIComponent()
    - 알파벳과 숫자 Alphanumeric Characters 외의, 대부분의 문자를 모두 인코딩합니다.
      %20=> 0x20 => 32(ASCII) => ' '  
    
    - http:// ... 가 http%3A%2F%2F 로 됩니다.

    ③ escape() / unescape()

    - 예전부터 있던 오래된 함수입니다.
    - encodeURIComponent() 의 중간 정도의 범위로 문자를 인코딩합니다.


*/


function download(filename){
	//현재 작업경로 :  /photo/list.do
	//파일다운로드 기능을 갖는 서블릿 호출
	//location.href="${ pageContext.request.contextPath }/FileDownload.do?dir=/image/&filename=" + filename;
	location.href="../FileDownload.do?dir=/upload/&filename=" + encodeURIComponent(filename);
}

var g_idx;
function del(idx){
	
	g_idx = idx;
	
	var pwd_window = document.getElementById("pwd_window");
	
	pwd_window.style.display = 'block';//보여지는 속성
	//위치지정(브라우져 정중앙에 배치)
	var pwd_width = 300;
	var pwd_height = 70;
	pwd_window.style.left = (window.innerWidth/2 - pwd_width/2) +  "px";
	pwd_window.style.top  = (window.innerHeight/2 -pwd_height)+ "px";
	//입력창에 포커스 지정
	document.getElementById("c_pwd").focus();
	
}     
   
function pwd_close(){
	var pwd_window = document.getElementById("pwd_window");
	pwd_window.style.display = 'none';//숨김 속성
	
	//이전에 입력되어 있는 값  clear
	document.getElementById("c_pwd").value='';
	
}

function pwd_confirm(){
	//입력되 비번 얻기
	var c_pwd = document.getElementById("c_pwd").value;
	if(c_pwd==''){
		alert('게시물 비밀번호를 입력하세요');
		return;
	}
	
	//삭제확인
	if(confirm("정말 삭제하시겠습니까?")==false)return;
	
	
	//Ajax : g_idx , c_pwd 서버로 전송해서 삭제후 결과만 받는다
	$.ajax({
		url:'delete.do',
		data:{'idx': g_idx,'c_pwd': c_pwd},
		dataType: 'json',
		success:function(json){
			// json = {'result':'yes'};
			// json = {'result':'no_pwd'};
			// json = {'result':'no'};
			if(json.result=='no_pwd'){
				alert('비밀번호가 틀립니다');
				return;
			}
			
			if(json.result=='no'){
				alert('삭제 실패했습니다');
				return;
			}
			
			//목록페이지로 이동
			location.href='list.do';
			
		}
	});
	
	
	
	
	
}
 
</script>      
      
</head>
<body>

<!-- 비밀번호 입력창 -->
<div id="pwd_window">
	<div align="right" style="margin-bottom: 10px;">
	      <input type="button" value="x" onclick="pwd_close();">
	</div>
	<div>
	    비밀번호:<input id="c_pwd" type="password">
	             <input type="button" value="확인" onclick="pwd_confirm();"> 
	</div>	
</div>





<div id="main_box">
	<h1>:::: PhotoGallery ::::</h1>
	<hr>
	<div align="center">
	      <input type="button" value="사진올리기" 
	             onclick="location.href='insert_form.do'">
	</div>
	<hr>
	<div id="photo_box">
		
		<!-- 등록된 사진이 없을경우 -->
		<c:if test="${ empty list }">
		   <div id="empty_msg">등록된 사진이 없습니다</div>
		</c:if>
		
		
		<c:forEach var="vo"  items="${ list }">
			<div class="photo_type">
				<img src="${ pageContext.request.contextPath }/resources/upload/${ vo.filename }">
				${vo.filename}
				<div style="padding-left: 5px;">${ vo.title }</div>
				<div align="center">
				    <input type="button" value="다운" onclick="download('${ vo.filename }');">
				    <input type="button" value="삭제" onclick="del('${ vo.idx}');">
				</div>
			</div>
		</c:forEach>
		
	</div>
</div>



</body>
</html>