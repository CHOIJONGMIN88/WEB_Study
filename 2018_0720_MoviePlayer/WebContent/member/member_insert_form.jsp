<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- Daum 주소검색  -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


<script type="text/javascript">
function check_id(){
	//var id = document.getElementById("id").value.trim();
	var id = $('#id').val();
	if(id==''){
		alert('아이디를 입력하세요');
		return;
	}
	
	//서버로 요청(Ajax)
	$.ajax({
		url:'check_id.do',  //MemberCheckIdAction
		data:{ 'id' : id },
		success:function(result){
			//result : 서버로부터 응답받은 데이터
			//alert(result);
		    // result = "[{'result':'yes'}]"; 
		    //alert(result.length);
		    var json_array = eval(result);// string=>object인식
		    //  var json_array = [{'result':'yes'}];
		    //alert(json.length);
		    var json = json_array[0];
		    // var json = {'result':'yes'};
		    
		    if(json.result=='no'){
		    	alert('이미 사용중인 아이디 입니다');
		    	return;
		    }
		    
		    alert('사용가능한 아이디 입니다');
		    
		    //id입력창 읽기전용
		    //document.getElementById("id").readOnly = true;
		    /*  <input id='id' readOnly='readOnly'> */
		    $('#id').attr('readOnly',true);
		    //가입버튼 활성화
		    //document.getElementById("bt_reg").disabled=false;
		    $('#bt_reg').attr('disabled',false);
		    
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
	
	 new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            //alert("우편번호:" + data.zonecode + "\n지번주소:" +data.address);
	            //document.getElementById("zipcode").value = data.zonecode;
	            $('#zipcode').val(data.zonecode);
	            //document.getElementById("addr").value = data.roadAddress;
	            $('#addr').val(data.roadAddress);
	            
	        }
	    }).open();
	
	
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
              <input name="id" id="id">
              <input type="button" value="중복체크" onclick="check_id();">   
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