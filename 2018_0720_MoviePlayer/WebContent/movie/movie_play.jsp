<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>    
    
<!-- 로그인 체크상태 -->    
<c:if test="${ empty sessionScope.user }">
   <script>
      alert('현재 컨텐츠를 이용하려면 로그인 필요합니다');
      location.href='${ pageContext.request.contextPath }/member/login_form.do';
   </script>
</c:if>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${ pageContext.request.contextPath }/js/httpRequest.js"></script>

<script type="text/javascript">

//현재 document가 load완료되면
window.onload=function(){
	
	//ajax객체을 이용해서 재생목록정보를 읽어오기
	//var url = 'movie_list_json.jsp';
	var url ='json_list.do'; // MovieListAction
	sendRequest(url,null,resultFn,'GET');
	
};

function resultFn(){
	
	if(xhr.readyState==4 && xhr.status==200){
		//서버에서 전송해주는 데이터 받기
		var data = xhr.responseText;
				
		// string
		//data="[ {'singer':'박효신','title':'그날','path':'mp4/박효신_그날.mp4'}]";
		// string=>object인식
		//data=[ {'singer':'박효신','title':'그날','path':'mp4/박효신_그날.mp4'}];
	    //alert(data.length);
		// string-> array object변환
		data = eval(data);
		
		/*  
		    data = [
				        {'singer':'박효신','title':'그날','path':'mp4/박효신_그날.mp4'},
				        {'singer':'블랙핑크','title':'뚜두뚜두','path':'mp4/blackpink_뚜두뚜두.mp4'},
				        {'singer':'모모랜드','title':'BAAM','path':'mp4/momoland_baam.mp4'}
				   ]
		*/
		
		//제어할 컨트롤 참조값을 얻어온다
		var select_movie = document.getElementById("select_movie");
		
		for(var i=0;i<data.length;i++){
			
			var singer = data[i].singer;
			var title  = data[i].title;
			var path   = "${ pageContext.request.contextPath}/" +  data[i].path; // 'mp4/momoland_baam.mp4'
			console.log(path);
			
			
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

function send(f){
	
	var movie = f.movie.value;
	if(movie==''){
		alert('업로드시킬 영상을 선택하세요');
		return;
	}
	
	f.submit();
	
	
	
}

</script>

</head>
<body>
<!-- MemberVo user -->
${ sessionScope.user.name }(${ user.id }) 님 환영합니다
<input type="button" value="로그아웃" 
       onclick="location.href='${ pageContext.request.contextPath}/member/logout.do'">

<hr>
곡명:<select id="select_movie" onchange="play();">
         <option value="">::::재생할 곡을 선택하세요::::</option>
        <!--  <option value="mp4/박효신_그날.mp4">(박효신): 그날</option>
         <option value="mp4/blackpink_뚜두뚜두.mp4">(블랙핑크): 뚜두뚜두</option>
         <option value="mp4/momoland_baam.mp4">(모모랜드): BAAM</option>  -->
     </select>
     
    
<hr>
<video id="video_movie"  controls="controls" width="400"  height="300">

</video>     
<hr>

 <!-- 업로드화일명 :  가수_곡명.mp4  -->
 <!-- MovieUploadAction : upload_movie.do  -->
 <form action = "upload.do" method="POST" 
       enctype= "multipart/form-data">
     <input type="file" name="movie">
     <input type="button"  value="영상올리기" 
                           onclick="send(this.form);">
 </form>     
 
     
</body>
</html>