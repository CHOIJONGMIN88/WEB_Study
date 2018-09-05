<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
<link rel = "stylesheet" href="../css/join_form.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript"> 

function pop(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            //alert("우편번호:" + data.zonecode + "\n지번주소:" +data.roadAddress);
            document.getElementById("m_zip_code").value = data.zonecode;
            document.getElementById("m_addr").value = data.roadAddress;
        }
    }).open();
}




</script>


</head>

<!--배경 이미지 셋팅-->
<body background="images/back_join_form.png">


  <div class="center">
     
     <label class="welcom_font">WELCOME B.B JOIN~♥♥♥</label>			
    
    </div>	
	
	
	
	
	<form>

		<!-- input:입력창 css , input_s 입력창 크기  -->

<input class="input input_s" placeholder="아이디"> 
<input  id="id_bnt" class="button button_id" type="button" value="중복확인"><br>

<input class="input input_s" placeholder="이름"><br>




<!-- ID중복체크 -->
<input class="input input_s" placeholder="닉네임">	
<input  id="id_bnt" class="button button_id" type="button" value="중복확인"><br>

<input class="input input_s" type="password" placeholder="비밀번호"><br>
<input class="input input_s" type="password" placeholder="비밀번호 확인"><br>
<input class="input input_m" placeholder="E-MAIL"><br>	
<input class="input input_s" placeholder="연락처"><br>

<!-- 주소검색 버튼  -->

<input id="m_zip_code" class="input input_s" type="text" placeholder="우편번호"> 	 	
<input type="button"  class="button button_id" value="검색" onclick="pop();"><br>
<input id="m_addr" class="input input_m" type="text" placeholder="주소">   <br>
	



<input class="input input_s" type="text" placeholder="프로필사진"> <br>
<input class="input input_s" type="text" placeholder="구장선택">  <br>		
	
	
	</form>



</body>
</html>