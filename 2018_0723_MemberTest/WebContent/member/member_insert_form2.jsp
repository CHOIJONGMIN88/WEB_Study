<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#id_msg{
   display: inline-block;
   width: 400px; 
   
}

</style>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- Daum 주소검색  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


<script type="text/javascript">

//ajax를 통한 지속적인 통신방법
var reg_id = /^[a-zA-Z0-9]{4,}$/;
function check_id(){
	//var id = document.getElementById("id").value.trim();
	var id = $('#id').val();
	if(reg_id.test(id)==false){
		$('#id_msg').css('color','red');
		$('#id_msg').html('4자이상의 영문자숫자조합으로 작성하세요');
		$('#bt_reg').attr('disabled',true);
		return;
	}
	
	//서버로 요청(Ajax)
	$.ajax({
		type: 'GET',
		url:'check_id2.do',  //MemberCheckIdAction2
		data:{ 'id' : id },
		dataType: 'json', //서버로부터 수신된 데이터 타입
		success:function(data){
			// data : 서버로부터 응답받은 데이터
		    // 서버측에서 속성값은 "" 으로 표현
			// data = {"result":"yes"} 
		    
		    if(data.result=='no'){
		    	$('#id_msg').css('color','red');
		    	$('#id_msg').html('이미 사용중인 아이디 입니다');
		    	$('#bt_reg').attr('disabled',true);
		    	return;
		    }
		    $('#id_msg').css('color','blue');
		    $('#id_msg').html('사용가능한 아이디 입니다');
		    $('#bt_reg').attr('disabled',false);
		    
		    //id입력창 읽기전용
		    //document.getElementById("id").readOnly = true;
		    /*  <input id='id' readOnly='readOnly'> */
		    //$('#id').attr('readOnly',true);
		    //가입버튼 활성화
		    //document.getElementById("bt_reg").disabled=false;
		    //$('#bt_reg').attr('disabled',false);
		    
		}
	});
}



function send(f){
	
	
	//입력값 체크 : 이름,비번,우편번호,주소

	
	
	//전송방식
	f.method = 'POST';
	//전송객체 지정
	f.action = 'insert.do'; //MemberInsertAction  => url pattern =/member/insert.do
	
	f.submit();//전송
	
	
}

function find(){
	
	//alert(window.screen.width +"/"+window.screen.height);
	 var width = 500;
	 var height= 600;
	 new daum.Postcode({
		    width: width,
		    height: height,
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            //alert("우편번호:" + data.zonecode + "\n지번주소:" +data.address);
	            //document.getElementById("zipcode").value = data.zonecode;
	            $('#zipcode').val(data.zonecode);
	            //document.getElementById("addr").value = data.roadAddress;
	            $('#addr').val(data.roadAddress);
	            
	        },
			theme: {
			        searchBgColor: "#0B65C8", //검색창 배경색
			        queryTextColor: "#FFFFFF" //검색창 글자색
			    }
	    }).open(
	    	{
		        left: (window.screen.width / 2) - (width / 2),
		        top: (window.screen.height / 2) - (height / 2)
	    	}
	    );
	
	
}

</script>

</head>
<body>

<form>
    <table border="1" align="center" width="700">
        <caption>::::회원가입::::</caption>
        <tr>
           <th>이름</th>
           <td><input name="name"></td>
        </tr>
        <tr>
           <th>아이디</th>
           <td>
              <input name="id" id="id"  onkeyup="check_id();">
              <span id="id_msg"></span>
           </td>
        </tr>
        <tr>
           <th>비밀번호</th>
           <td><input type="password" name="pwd"></td>
        </tr>
        
        <tr>
           <th>우편번호</th>
           
           <td>
              <input name="zipcode"  id="zipcode">
              <input type="button" value="주소검색" onclick="find();">
           </td>
        </tr>
        <tr>
           <th>주소</th>
           <td><input name="addr" id="addr"  style="width: 98%;"></td>
        </tr>
        <tr>
        	<td colspan="2" align="center">
        	    <input type="button"  value="가입하기"  id="bt_reg" disabled="disabled"  
        	                          onclick="send(this.form);">
        	    <input type="button"  value="목록보기"  onclick="location.href='list.do'">
        	</td>
        </tr>
    
    </table>
</form>


</body>
</html>