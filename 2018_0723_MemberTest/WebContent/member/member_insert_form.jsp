<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript">

	function check_id(){
		
		//var id=document.getElementById("id").value.trim();
		var id=$('#id').val();
		var pwd=$('#pwd').val();
		if(id==''){
			alert('아이디를 입력하세요');
			return;
		}
		
		//서버로 요청(Ajax)
		//제이슨 안에 제이슨, 객체 속의 객체 
	/* 	var op={url:'check_pwd.do',
					data:{'id':id},
					success:function(){},
					fail:function(){}
		}; */
		
			$.ajax({ url:'check_id.do', 
					 data:{'id':id,'pwd':pwd}, 
					 success:function(data){
				//data는 서버로부터 응답받은 데이터이다.
					if(data=='no'){
						alert('이미 사용중인 아이디 입니다.');
								}
				var json=eval(data); //string=>object인식  string을 객체로 변환한다.
				
				// json = [{'data':'yes'}];
				
	
				
				//배열상태로 넘어온 json 0번의 키값을 이용해서 사용한다.
					if(json[0].result1=='no'){
						alert('이미 사용중인 아이디 입니다.');
						return;	
					}
				
				alert('사용가능한 아이디 입니다.');
				//id입력창 읽기전용
				//document.getElementById("id").readOnly=true;
				$('#id').attr('readOnly',true);
				//document.getElementById("bt_reg").disable=false;
				$('#bt_reg').attr('disabled',false);	
					
					
			}
		});			

	}
	
	
function pop(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            //alert("우편번호:" + data.zonecode + "\n지번주소:" +data.roadAddress);
	            document.getElementById("zipcode").value = data.zonecode;
	            document.getElementById("addr").value = data.roadAddress;
	        }
	    }).open();
	}	

function send(f){
	
	//입력값 체크 : 이름,비번,우편번호,주소 

	//전송객체 지정
	f.action ="insert.do"; //MemberInsertAction => url ='/member/insert.do'
	f.submit(); //전송

}

</script>

</head>
<body>

	<form>
		<table border="1" align="center" width="700">
			<caption> ::::회원가입::::::</caption>
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
					<input name="zipcode" id="zipcode">
					<input type="button"  value="주소검색" onclick="pop();">
			</td>	
			</tr>
			
			<tr>
				<th>주소</th>
				<td><input name="addr" id="addr" style="width:98%"></td>			
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" id="bt_reg" value="가입하기" disabled="disabled" onclick="send(this.form)">
					<input type="button"  value="목록보기" onclick="location.href='list.do'">
				</td>	
					
			
			</tr>
		
		
		
		</table>
	
	</form>




</body>
</html>