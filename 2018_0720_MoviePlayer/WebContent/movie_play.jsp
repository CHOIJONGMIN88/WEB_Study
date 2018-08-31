<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 로그인 체크상태 -->

<c:if test="${empty sessionScope.user}">	
	
<script>
alert('현재 컨텐츠를 이용하려면 로그인이 필요합니다.')
location.href='login_form.jsp';
</script>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${ pageContext.request.contextPath }/js/httpRequest.js"></script>

<script type="text/javascript">


function send(f){
	
	//파일 형식은 가수_곡명으로 통일해야 된다.
	f.action='upload.do'; //FileUploadAction
	f.submit(); //지정된 action으로 전송
}

//현재 document가 load완료되면
window.onload=function(){
	
	//ajax객체을 이용해서 재생목록정보를 읽어오기
	//var url = 'movie_list_json.jsp';
	var url ='movie_list.do'; // MovieListAction
	sendRequest(url,null,resultFn,'GET');
	
};

function resultFn(){
	
	if(xhr.readyState==4 && xhr.status==200){
		//서버에서 전송해주는 데이터 받기
		var data = xhr.responseText;
		
		alert(data);
		
		// string-> array object변환
		data = eval(data);
		
		/*  
		    data = [
		    	{'singer':'dog','path':'mp4/dog.mp4','title':'개'},
		    	{'singer':'pink','path':'mp4/pink.mp4','title':'에이핑크'},
		    	{'singer':'shark','path':'mp4/shark.mp4','title':'상어'}
				   ]
		*/
		
		//제어할 컨트롤 참조값을 얻어온다
		var select_movie = document.getElementById("select_movie");
		
		for(var i=0;i<data.length;i++){
			
			var singer = data[i].singer;
			var title  = data[i].title;
			var path   = data[i].path;
			
			var option = document.createElement("option"); // <option>innerHTML</option>
			option.innerHTML = '(' + singer + ') ' + title;
			option.value = path;  // <option value='path'>
			
			// <select> 자식요소로 등록
			select_movie.appendChild(option);
						
		}

	}
	
}

function play(){
	//<select>선택 곡명 얻어오기
	var path = document.getElementById("select_movie").value;
	
	//<video>참조값 얻어오기
	var video_movie = document.getElementById("video_movie");
	//
	video_movie.src = path;//재생곡명 넣어준다
	video_movie.play();    //재생
}

</script>

</head>
<body>
${sessionScope.user}님 환영합니다.

곡명:<select id="select_movie" onchange="play();">
         <option value="">::::재생할 곡을 선택하세요::::</option>
      <!-- 	<option value=""> :::::::재생할 곡을 선택하세요:::::::::::</option>
		<option value="mp4/dog.mp4"> 개동영상 </option>
		<option value="mp4/pink.mp4"> 에이핑크뚜루뚜뚜</option>
		<option value="mp4/shark.mp4"> 핑크퐁 </option> -->
     </select>
  
<hr>
<video id="video_movie"  controls="controls" width="400"  height="300">

</video>     
<hr>

 <!-- 업로드화일명 :  가수_곡명.mp4  -->
 <!-- MovieUploadAction : upload_movie.do  -->
 <form action = "upload_movie.do" method="POST" 
       enctype= "multipart/form-data">
     <input type="file" name="movie">
     <input type="button"  value="영상올리기" 
                           onclick="send(this.form);">
 </form>     
 
 최근에 출력된 파일명 ${filename}
     
</body>
</html>


	