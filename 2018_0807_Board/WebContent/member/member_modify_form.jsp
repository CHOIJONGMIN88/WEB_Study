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

function send(f){
	
	
	//입력값 체크 : 이름,비번,우편번호,주소

	
	
	
	if(confirm('정말 수정하시겠습니까?')==false)return;
	
	
	//전송방식
	f.method = 'POST';
	//전송객체 지정
	f.action = 'modify.do'; //MemberModifyAction  => url pattern =/member/modify.do
	
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
    <input type="hidden" name="idx"  value="${ vo.idx }">
    <table border="1" align="center" width="700">
        <caption>::::회원수정::::</caption>
        <tr>
           <th>이름</th>
           <td><input name="name" value="${ vo.name }"></td>
        </tr>
        <tr>
           <th>아이디</th>
           <td>
              <input name="id" readonly="readonly"  value="${ vo.id }">
           </td>
        </tr>
        <tr>
           <th>비밀번호</th>
           <td><input type="password" name="pwd"  value="${ vo.pwd }"></td>
        </tr>
        
        <tr>
           <th>우편번호</th>
           <td>
              <input name="zipcode"  id="zipcode"  value="${ vo.zipcode }">
              <input type="button" value="주소검색" onclick="find();">
           </td>
        </tr>
        <tr>
           <th>주소</th>
           <td><input name="addr" id="addr"  value="${ vo.addr }"  style="width: 98%;"></td>
        </tr>
        <tr>
        	<td colspan="2" align="center">
        	    <input type="button"  value="수정하기"  onclick="send(this.form);">
        	    <input type="button"  value="목록보기"  onclick="location.href='list.do'">
        	</td>
        </tr>
    
    </table>
</form>


</body>
</html>